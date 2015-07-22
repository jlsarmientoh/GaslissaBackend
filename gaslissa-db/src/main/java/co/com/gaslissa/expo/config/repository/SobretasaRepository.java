/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.Sobretasa;

/**
 * @author Jorge
 *
 */
public interface SobretasaRepository extends CrudRepository<Sobretasa, Long>, QueryDslPredicateExecutor<Sobretasa> {

	@Query("SELECT s FROM Sobretasa s WHERE s.anioVigencia = #{#anio} AND s.mesVigencia = #{#mes} AND s.diaInicioVigencia <= #{#dia} AND s.diaFinVigencia >= #{#dia}")
	public List<Sobretasa> consultarSobretasas(
			@Param("anio") Integer anio,
			@Param("mes") Integer mes,
			@Param("dia") Integer dia
			);
	
	@Query("SELECT s FROM Sobretasa s WHERE s.producto.idProducto = #{#producto} AND s.anioVigencia = #{#anio} AND s.mesVigencia = #{#mes} AND s.diaInicioVigencia <= #{#dia} AND s.diaFinVigencia >= #{#dia}")
	public List<Sobretasa> consultarSobretasaProducto(
			@Param("anio") Integer anio,
			@Param("mes") Integer mes,
			@Param("dia") Integer dia,
			@Param("producto") Long idPorducto
			);
	
	
}
