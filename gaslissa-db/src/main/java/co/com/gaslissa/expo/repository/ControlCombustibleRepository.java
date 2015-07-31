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

import co.com.gaslissa.expo.entity.ControlCombustible;

/**
 * @author Jorge
 *
 */
public interface ControlCombustibleRepository
		extends CrudRepository<ControlCombustible, Long>, QueryDslPredicateExecutor<ControlCombustible> {
	
	@Query("SELECT c FROM ControlCombustible c WHERE c.fecha BETWEEN :desde AND :hasta")
	public List<ControlCombustible> consultarControles(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);

	@Query("SELECT c FROM ControlCombustible c WHERE c.producto.idProducto = :producto AND c.fecha BETWEEN :desde AND :hasta")
	public List<ControlCombustible> consultarControles(
			@Param("producto")Long producto,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT c FROM ControlCombustible c WHERE c.producto.idProducto = :producto AND c.fecha BETWEEN :desde AND :desde")
	public ControlCombustible consultarControl(
			@Param("producto")Long producto,
			@Param("desde")Date desde
			);
}
