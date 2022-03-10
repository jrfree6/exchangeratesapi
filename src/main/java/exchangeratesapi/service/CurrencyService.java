package exchangeratesapi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import exchangeratesapi.entity.CurrencyEntity;
import exchangeratesapi.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	@Inject
	private CurrencyRepository currencyRepository;
	
	public List<CurrencyEntity> findById(Integer id) {
		return currencyRepository.findByIdTransaction(id);
	}
	
	public List<CurrencyEntity> getAll() {
		return currencyRepository.findAll();
	}
	
	public void save(CurrencyEntity object) {
		currencyRepository.save(object);
	}

}
