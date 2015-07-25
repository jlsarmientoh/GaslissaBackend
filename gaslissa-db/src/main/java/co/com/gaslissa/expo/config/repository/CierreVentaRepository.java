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

import co.com.gaslissa.expo.entity.CierreVenta;

/**
 * @author Jorge
 *
 */
public interface CierreVentaRepository
		extends CrudRepository<CierreVenta, Long>, QueryDslPredicateExecutor<CierreVenta> {

	@Query("SELECT NEW java.lang.Integer(COUNT(c.idCierre)) FROM CierreVenta c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta} AND c.turno = #{#turno} ADN c.isla IN(#{#isla}) AND c.codEmp = #{#codEmp}")
	public int consultarCuentaCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")long turno,
			@Param("isla") long isla,
			@Param("codEmp") long codEmp);
	
	@Query("SELECT c FROM CierreVenta c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta}")
	public List<CierreVenta> consultarCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
	
	//TODO cambiar esto por la tabla de detalle cierre
	@Query("SELECT NEW co.com.gaslissa.expo.entity.CierreVenta(SUM(c.bigPass), SUM(c.creditos), SUM(c.efectivo), c.fecha, SUM(c.otros), SUM(c.sodexo), SUM(c.tarjetaPlus), SUM(c.tarjetas), SUM(c.ticketTronik), SUM(c.totalVentas)) FROM CierreVenta c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta} GROUP BY c.fecha")
	public List<CierreVenta> consultarCierresAgrupados(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
	
	//TODO cambiar esto por la tabla de detalle cierre
	@Query("SELECT NEW java.lang.Integer(COUNT(c.#{#medio})) FROM CierreVenta c WHERE c.fecha BETWEEN #{#desde} AND #{#hasta} AND c.turno = #{#turno} ADN c.isla IN(#{#isla}) AND c.codEmp = #{#codEmp}")
	public Double consultarTotalMedioPago(
			@Param("medio") long medio,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
}
