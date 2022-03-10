package exchangeratesapi.adm;

import java.time.LocalDate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import exchangeratesapi.dto.Currency;
import exchangeratesapi.dto.CurrencyConvert;
import exchangeratesapi.entity.CurrencyEntity;

public class Convert {
	
	final Logger log = LoggerFactory.getLogger(Convert.class);
	
	private String UrlApi = "http://api.exchangeratesapi.io/v1/latest?access_key=607536925eb65e777a456c60966909be&format=1";
	
	public Currency findCurrency() throws Exception, Exception {

		Client client = ClientBuilder.newClient();
		Response response = client.target(UrlApi).request(MediaType.APPLICATION_JSON_TYPE).get();
		
		String stringJson = response.readEntity(String.class);
		
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		Currency root = om.readValue(stringJson, Currency.class); 

		return root;
		
	}
	
	public CurrencyEntity changeMoney(CurrencyConvert value) throws Exception {
		
		double result = 0;
		
		double originalEur = getValue(value.getFrom());
		double DestTax = getValue(value.getTo());
		
		result = ( value.getAmount() / originalEur ) *  DestTax;
		
		CurrencyEntity ce = new CurrencyEntity();
		ce.setDate(LocalDate.now());
		ce.setOriginCurrency(value.getFrom());
		ce.setDestinationCurrency(value.getTo());
		ce.setOriginAmount(value.getAmount());
		ce.setDestinationAmount(result);
		ce.setUserId("John_Snow");
		
		log.info(ce.toString());
		
		return ce;
		
	}
	
	private double getValue(String fromTo) throws Exception {
		Currency rates = findCurrency();
		
		double value = 0;
		switch (fromTo) {
		case "USD":
				value = rates.getRates().uSD;
			break;
		case "BRL":
			value = rates.getRates().bRL;
			break;
		case "PYN":
			value = rates.getRates().jPY;
			break;
		case "EUR":
			value = rates.getRates().eUR;
			break;
			
		default:
			value = 0;
			break;
		}
		
		return value;
	}
	
}
