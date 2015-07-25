/**
 * 
 */
package co.com.gaslissa.expo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.ModoPago;

/**
 * @author Jorge
 *
 */
public interface ModoPagoRepository extends CrudRepository<ModoPago, Long>, QueryDslPredicateExecutor<ModoPago> {

	@Query("SELECT m FROM ModoPago m WHERE m.idModoPadre = 0")
	public List<ModoPago> consultarModosPagoPadre();
	
	@Query("SELECT m FROM ModoPago m WHERE m.idModoPadre = #{#padre}")
	public List<ModoPago> consultarModosPagoHijo(@Param("padre")int idPadre);
}
