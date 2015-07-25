/**
 * 
 */
package co.com.gaslissa.expo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.Egreso;

/**
 * @author Jorge
 *
 */
public interface EgresoRepository extends CrudRepository<Egreso, Long>, QueryDslPredicateExecutor<Egreso> {

	@Query("SELECT e FROM Egreso e WHERE e.fecha BETWEEN #{#desde} AND #{#hasta}")
	public List<Egreso> consultarEgresosFecha(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT e FROM Egreso e WHERE e.fechaAplica BETWEEN #{#desde} AND #{#hasta}")
	public List<Egreso> consultarEgresosAplicadosFecha(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT new java.lang.Double(e.valor) FROM Egreso e WHERE e.fechaAplica BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalEgresosAplicados(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	//TODO implementar public int guardarEgresos(List<EgresoVO> egresos, DateTime fecha, DateTime fechaAplica)
}
