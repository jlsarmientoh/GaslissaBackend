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

import co.com.gaslissa.expo.entity.Cliente;
import co.com.gaslissa.expo.entity.Venta;

/**
 * @author Jorge
 *
 */
public interface VentaRepository extends CrudRepository<Venta, Long>, QueryDslPredicateExecutor<Venta> {

	@Query("SELECT NEW co.com.gaslissa.expo.entity.Venta(v.fecha, v.nit, v.total, v.modoPago.idModoPago) FROM Venta v WHERE v.fecha BETWEEN :desde AND :hasta GROUP BY v.fecha, v.nit, v.modoPago")
	public List<Venta> consultarVentasAgrupadas(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta
			);
	
	@Query("SELECT NEW co.com.gaslissa.expo.entity.Venta(v.nit, v.total, v.modoPago.idModoPago) FROM Venta v WHERE v.fecha BETWEEN :desde AND :hasta AND (v.nit = :nit OR v.nit = :codigo) AND v.modoPago.idModoPago = :modoPago GROUP BY v.nit, v.producto, v.modoPago")
	public List<Venta> consultarVentasAgrupadas(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("nit") String nit,
			@Param("codigo") String codigo,
			@Param("modoPago") Long modoPago 
			);
	
	@Query("SELECT NEW co.com.gaslissa.expo.entity.Venta(v.nit, v.total) FROM Venta v WHERE v.fecha BETWEEN :desde AND :hasta AND (v.nit = :nit OR v.nit = :codigo) GROUP BY v.nit, v.producto")
	public List<Venta> consultarVentasAgrupadas(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("nit") String nit,
			@Param("codigo") String codigo
			);
	
	@Query("SELECT v FROM Venta v WHERE v.fecha BETWEEN :desde AND :hasta AND (v.nit = :nit OR v.nit = :codigo)")
	public List<Venta> consultarVentasCliente(
			@Param("desde")Date desde,
			@Param("hasta")Date hasta,
			@Param("nit") String nit,
			@Param("codigo") String codigo
			);
	
	@Query("SELECT NEW co.com.gaslissa.expo.entity.Cliente(v.nit, v.cliente) FROM Venta v GROUP BY v.nit, v.cliente ORDER BY v.cliente")
	public List<Cliente> consultarClientesVentas();
}
