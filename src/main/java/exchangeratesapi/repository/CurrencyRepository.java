package exchangeratesapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exchangeratesapi.entity.CurrencyEntity;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

	@Query("select u from CurrencyEntity u where u.id=:id ")
	List<CurrencyEntity> findByIdTransaction(@Param("id") Integer id);
	
}
