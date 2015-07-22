/**
 * 
 */
package co.com.gaslissa.servipunto.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.gaslissa.servipunto.entity.Cliente;

/**
 * @author Jorge
 *
 */
public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
