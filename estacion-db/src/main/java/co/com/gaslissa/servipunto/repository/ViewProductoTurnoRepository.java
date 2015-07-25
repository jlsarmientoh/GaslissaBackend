/**
 * 
 */
package co.com.gaslissa.servipunto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.servipunto.entity.ViewProductosTurno;

/**
 * @author Jorge
 *
 */
public interface ViewProductoTurnoRepository extends QueryDslPredicateExecutor<ViewProductosTurno> {

	@Query("SELECT NEW co.com.gaslissa.servipunto.entity.ViewProductosTurno(v.fecha, v.galones, v.isla, v.producto, v.turno, v.valor) FROM ViewProductosTurno v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla})")
	public List<ViewProductosTurno>consultarProductosTurno(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") String isla
			);
	
	@Query("SELECT NEW java.lang.Double(SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla})")
	public Double consultarTotalProductosTurno(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") String isla
			);
	
	@Query("SELECT NEW co.com.gaslissa.servipunto.entity.ViewProductosTurno(v.fecha, SUM(v.galones), v.isla, v.producto, v.turno, SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta} GROUP BY v.fecha, v.producto")
	public List<ViewProductosTurno> consultarProductosAgrupados(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(SUM(v.valor)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalConsumo(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW java.lang.Double(SUM(v.galones)) FROM ViewProductosTurno v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta}")
	public Double consultarTotalGalones(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
}
