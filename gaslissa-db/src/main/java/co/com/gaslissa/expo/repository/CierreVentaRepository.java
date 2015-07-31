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

import co.com.gaslissa.expo.entity.CierreVenta;

/**
 * @author Jorge
 *
 */
public interface CierreVentaRepository
		extends CrudRepository<CierreVenta, Long>, QueryDslPredicateExecutor<CierreVenta> {

	@Query("SELECT NEW java.lang.Long(COUNT(c.idCierre)) FROM CierreVenta c WHERE c.fecha BETWEEN :desde AND :hasta AND c.turno = :turno AND c.isla IN(:isla) AND c.codEmpleado = :codEmp")
	public long consultarCuentaCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")long turno,
			@Param("isla") long isla,
			@Param("codEmp") long codEmp);
	
	@Query("SELECT c FROM CierreVenta c WHERE c.fecha BETWEEN :desde AND :hasta")
	public List<CierreVenta> consultarCierres(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
	
	//TODO cambiar esto por la tabla de detalle cierre
	@Query("SELECT NEW co.com.gaslissa.expo.entity.CierreVenta(SUM(c.bigPass), SUM(c.creditos), SUM(c.efectivo), c.fecha, SUM(c.otros), SUM(c.sodexo), SUM(c.tarjetaPlus), SUM(c.tarjetas), SUM(c.ticketTronik), SUM(c.totalVentas)) FROM CierreVenta c WHERE c.fecha BETWEEN :desde AND :hasta GROUP BY c.fecha")
	public List<CierreVenta> consultarCierresAgrupados(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
	
	//TODO cambiar esto por la tabla de detalle cierre
	@Query("SELECT NEW java.lang.Long(COUNT(c.idCierre)) FROM CierreVenta c WHERE c.fecha BETWEEN :desde AND :hasta AND c.turno = :turno AND c.isla IN(:isla) AND c.codEmpleado = :codEmp")
	public Double consultarTotalMedioPago(
			/*@Param("medio") long medio,*/
			@Param("desde")Date desde,
			@Param("hasta")Date hasta);
}
