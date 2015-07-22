/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.Cliente;

/**
 * @author Jorge
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente, Long>, QueryDslPredicateExecutor<Cliente> {

	@Query("SELECT c FROM Cliente c WHERE c.#{#campo} LIKE CONCAT('%',#{#valor},'%')")
	public List<Cliente> consultarClientes(
			@Param("campo")String campo,
			@Param("valor")String valor
			);
	
	@Query("SELECT c FROM Cliente c WHERE c.codigo = #{#codigo}")
	public Cliente consultarClienteByCodigo(
			@Param("codigo")String codigo
			);
}
