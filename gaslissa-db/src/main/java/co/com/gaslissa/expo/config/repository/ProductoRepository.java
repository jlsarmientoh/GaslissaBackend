/**
 * 
 */
package co.com.gaslissa.expo.config.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.gaslissa.expo.entity.Producto;

/**
 * @author Jorge
 *
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

}
