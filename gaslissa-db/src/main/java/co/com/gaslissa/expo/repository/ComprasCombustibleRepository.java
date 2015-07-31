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

import co.com.gaslissa.expo.entity.ComprasCombustible;

/**
 * @author Jorge
 *
 */
public interface ComprasCombustibleRepository
		extends CrudRepository<ComprasCombustible, Long>, QueryDslPredicateExecutor<ComprasCombustible> {
	
	@Query("SELECT c FROM ComprasCombustible c WHERE c.fecha BETWEEN :desde AND :hasta")
	List<ComprasCombustible> consultarComprasFecha(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(c.cantidad) FROM ComprasCombustible c WHERE c.fecha BETWEEN :desde AND :hasta AND c.producto.idProducto = :producto")
	public Double consultarComprasGalonesFechaProducto(
			@Param("producto")Long producto,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);

}
