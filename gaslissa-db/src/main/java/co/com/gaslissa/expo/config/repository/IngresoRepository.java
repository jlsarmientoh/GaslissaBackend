/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.Ingreso;

/**
 * @author Jorge
 *
 */
public interface IngresoRepository extends CrudRepository<Ingreso, Long>, QueryDslPredicateExecutor<Ingreso> {

	@Query("SELECT i FROM Ingreso i WHERE i.fecha BETWEEN #{#desde} AND #{#hasta}")
	public List<Ingreso> consultarIngresosFecha(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(i.valor) FROM Ingreso i WHERE i.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalIngresosFecha(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
}
