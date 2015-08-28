/**
 * 
 */
package co.com.gaslissa.expo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.DetalleCierre;

/**
 * @author Jorge
 *
 */
public interface DetalleCierreRepository
		extends CrudRepository<DetalleCierre, Long>, QueryDslPredicateExecutor<DetalleCierre> {

	@Query("SELECT d FROM DetalleCierre d WHERE d.cierreVenta.idCierre = :cierre")
	public List<DetalleCierre> consultarDetallesCierre(
			@Param("cierre") long idCierre);
	
}
