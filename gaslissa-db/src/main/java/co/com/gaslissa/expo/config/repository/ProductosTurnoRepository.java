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

import co.com.gaslissa.expo.entity.ProductosTurno;

/**
 * @author Jorge
 *
 */
public interface ProductosTurnoRepository
		extends CrudRepository<ProductosTurno, Long>, QueryDslPredicateExecutor<ProductosTurno> {

	@Query("SELECT NEW co.com.gaslissa.expo.entity.ProductosTurno(p.fecha, p.galones, p.producto, p.valor) FROM ProductosTurno p WHERE p.fecha BETWEEN #{#desde} AND #{#hasta} GROUP BY p.fecha, p.producto")
	public List<ProductosTurno> consultarProductosAgrupados(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(p.valor) FROM ProductosTurno p WHERE p.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalConsumo(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(p.galones) FROM ProductosTurno p WHERE p.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalGalones(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
}
