package exchangeratesapi.controller;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exchangeratesapi.adm.Convert;
import exchangeratesapi.dto.CurrencyConvert;
import exchangeratesapi.entity.CurrencyEntity;
import exchangeratesapi.service.CurrencyService;
import model.Message;

@RestController
public class ConverterController  {
	
	@Inject
	private CurrencyService currencyService;
	
	private String[] available = new String[] {"BRL", "USD", "EUR", "JPY" };
	
	@PostMapping
	@RequestMapping("/Exchange")
	public Response getExchange(@RequestBody CurrencyConvert money) throws Exception {
	
		Message msg = checkCurrency(money);
		if(msg.getCode() != null && msg.getCode().equalsIgnoreCase("202")) {
			return Response.ok(msg).build();	
		}
		Convert cv = new Convert();
		CurrencyEntity ce = cv.changeMoney(money);
		currencyService.save(ce);
		
		return Response.ok(ce).build();
		
	}
	private Message checkCurrency(CurrencyConvert value) {
		
		String message = new String();
		boolean boolFrom = false, boolTo = false;
		for (String key : available) {
			if(key.equals(value.getFrom())){
				boolFrom = true;
			}
			if(key.equals(value.getTo())){
				boolTo = true;
			}
		}
		if(!boolFrom) {
			message = "Conversion not available for currency:" +value.getFrom() ;
		}
		if(!boolTo) {
			message += "Conversion not available for currency:" +value.getTo() ;
		}
		
		Message msg = new Message();
		if(!message.isEmpty() ) {
			msg.setMessage(message);
			msg.setError(message);
			msg.setCode("202");
		}
		return msg;
	}

}
