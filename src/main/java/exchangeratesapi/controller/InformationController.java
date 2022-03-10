package exchangeratesapi.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exchangeratesapi.adm.Convert;
import exchangeratesapi.dto.Currency;
import exchangeratesapi.entity.CurrencyEntity;
import exchangeratesapi.service.CurrencyService;

@RestController
public class InformationController {
	
	@Inject
	private CurrencyService currencyService;
	
	
	@GetMapping
	@RequestMapping("/Information")
	public List<CurrencyEntity> getAllTransaction() throws Exception {
		
		Convert convert = new Convert();
		convert.findCurrency();
		
		return currencyService.getAll();
	}
	@GetMapping
	@RequestMapping("/ConversionRate")
	public Currency getConversionRates() throws Exception {
		Convert convert = new Convert();
		convert.findCurrency();
		
		return convert.findCurrency();
	}
	
	@GetMapping
	@RolesAllowed({"admin", "user"})
	@RequestMapping("/Information/{id}")
	public List<CurrencyEntity> getById(@PathVariable("id") Integer id) {
		return currencyService.findById(id);
	}


}
