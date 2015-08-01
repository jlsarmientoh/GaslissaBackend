/**
 * 
 */
package co.com.gaslissa.expo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.gaslissa.expo.entity.Usuario;

/**
 * @author Jorge
 *
 */
public interface UsuarioRespository extends CrudRepository<Usuario, String>, QueryDslPredicateExecutor<Usuario> {

	@Query("SELECT u FROM Usuario u WHERE u.idUsuario = :usuario AND u.pwd = :pwd")
	public Usuario consultarUsuario(
			@Param("usuario")String usuario,
			@Param("pwd")String password
			);
	
	@Query("SELECT u FROM Usuario u WHERE u.idUsuario = :usuario")
	public Usuario consultarUsuario(
			@Param("usuario")String usuario
			);
}
