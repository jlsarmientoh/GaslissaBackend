/**
 * 
 */
package co.com.gaslissa.servipunto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.servipunto.entity.ViewVenta;

/**
 * @author Jorge
 *
 */
public interface ViewVentaRepository extends CrudRepository<ViewVenta, Integer>, QueryDslPredicateExecutor<ViewVenta> {

	@Query("SELECT v FROM ViewVenta v WHERE v.cliente <> #{#cliente} AND v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla}) AND v.codEmp = #{#codEmp}")
	public List<ViewVenta> consultarVentasFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")short turno,
			@Param("isla") String isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.cliente = #{#cliente} AND v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla}) AND v.codEmp = #{#codEmp}")
	public List<ViewVenta> consultarVentasNoFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")short turno,
			@Param("isla") String isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla}) AND v.codEmp = #{#codEmp}")
	public List<ViewVenta> consultarVentasTurno(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")short turno,
			@Param("isla") String isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.tiquete_Nro = #{#tiquete}")
	public ViewVenta consultarVentasByTiquete(@Param("tiquete")Integer tiquete_Nro);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.tiquete_Nro = #{#tiquete} AND v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla})")
	public ViewVenta consultarVentasByTiqueteTurno(
			@Param("tiquete")Integer tiquete_Nro,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")short turno,
			@Param("isla") String isla);
	
	@Query("SELECT new java.lang.Double(v.total) FROM v.cliente <> #{#cliente} AND ViewVenta v WHERE v.fecha BETWEEN #{#desde} AND #{#hasta} AND v.turno = #{#turno} ADN v.isla IN(#{#isla}) AND v.codEmp = #{#codEmp}")
	public Double consultarTotalVentasFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")short turno,
			@Param("isla") String isla,
			@Param("codEmp") String codEmp);
}
