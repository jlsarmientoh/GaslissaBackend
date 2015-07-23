/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.VolumenesTanque;

/**
 * @author Jorge
 *
 */
public interface VolumenTanqueRepository
		extends CrudRepository<VolumenesTanque, Long>, QueryDslPredicateExecutor<VolumenesTanque> {

	@Query("SELECT v FROM VolumenesTanque v WHERE v.tanque.idTanque = #{#tanque} AND v.producto.idProducto = #{#producto}")
	public List<VolumenesTanque> consultarVolumenes(
			@Param("tanque")Integer idTanque,
			@Param("producto")Integer idProducto
			);
	
	@Query("SELECT v FROM VolumenesTanque v WHERE v.tanque.idTanque = #{#tanque} AND v.producto.idProducto = #{#producto} AND v.lecturaCm = #{#cms}")
	public VolumenesTanque consultarVolumen(
			@Param("tanque")Integer idTanque,
			@Param("producto")Integer idProducto,
			@Param("cms")Double cms
			);
}
