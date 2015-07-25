/**
 * 
 */
package co.com.gaslissa.expo.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import co.com.gaslissa.expo.entity.DetalleCierre;

/**
 * @author Jorge
 *
 */
public interface DetalleCierreRepository
		extends CrudRepository<DetalleCierre, Long>, QueryDslPredicateExecutor<DetalleCierre> {

}
