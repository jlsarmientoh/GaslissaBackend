/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.gaslissa.expo.entity.Banco;

/**
 * @author Jorge
 *
 */
interface BancoRepository extends CrudRepository<Banco, Long> {

}
