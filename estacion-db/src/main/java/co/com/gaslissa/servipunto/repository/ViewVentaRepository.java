/**
 * 
 */
package co.com.gaslissa.servipunto.repository;

import java.math.BigDecimal;
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
public interface ViewVentaRepository extends CrudRepository<ViewVenta, Long>, QueryDslPredicateExecutor<ViewVenta> {

	@Query("SELECT v FROM ViewVenta v WHERE v.cliente <> :cliente AND v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla) AND v.codEmp = :codEmp")
	public List<ViewVenta> consultarVentasFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") List<Integer> isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.cliente = :cliente AND v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla) AND v.codEmp = :codEmp")
	public List<ViewVenta> consultarVentasNoFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") List<Integer> isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla) AND v.codEmp = :codEmp")
	public List<ViewVenta> consultarVentasTurno(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") List<Integer> isla,
			@Param("codEmp") String codEmp);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.tiquete_Nro = :tiquete")
	public ViewVenta consultarVentasByTiquete(@Param("tiquete")Integer tiquete_Nro);
	
	@Query("SELECT v FROM ViewVenta v WHERE v.tiquete_Nro = :tiquete AND v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla)")
	public ViewVenta consultarVentasByTiqueteTurno(
			@Param("tiquete")Long tiquete_Nro,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") List<Integer> isla);
	
	@Query("SELECT v.total FROM ViewVenta v WHERE v.cliente <> :cliente AND v.fecha BETWEEN :desde AND :hasta AND v.turno = :turno AND v.isla IN(:isla) AND v.codEmp = :codEmp")
	public BigDecimal consultarTotalVentasFidelizados(
			@Param("cliente") String cliente,
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("turno")int turno,
			@Param("isla") List<Integer> isla,
			@Param("codEmp") String codEmp);
}
