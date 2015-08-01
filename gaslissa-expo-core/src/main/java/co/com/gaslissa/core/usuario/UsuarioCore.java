/**
 * 
 */
package co.com.gaslissa.core.usuario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.common.dto.Usuario;
import co.com.gaslissa.core.exception.LoginException;
import co.com.gaslissa.expo.repository.UsuarioRespository;

/**
 * @author Jorge
 *
 */
public class UsuarioCore {
	
	final static Logger logger = LoggerFactory.getLogger(UsuarioCore.class);
	
	private final UsuarioRespository usuarioRepository;

	/**
	 * @param usuarioRepository
	 */
	public UsuarioCore(UsuarioRespository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	/**
	 * 
	 * @param user
	 * @param pwd
	 * @return
	 * @throws LoginException
	 */
	public Usuario validarUsuario(String user, String pwd) throws LoginException{
		try{
			Usuario dto = null;
			co.com.gaslissa.expo.entity.Usuario usuario = usuarioRepository.consultarUsuario(user, pwd);
			
			if(usuario != null){
				dto = new Usuario(usuario.getIdUsuario(), usuario.getPwd(), usuario.getEsAdmin() == 1 ? true : false);
			}
			
			return dto;
		}catch(Exception ex){
			logger.error("No se pudo consultar la información del usuario en la base de datos Expo: " + ex.getMessage());
			throw new LoginException("No se pudo consultar la información del usuario en la base de datos Expo: " + ex.getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param usuario
	 * @throws LoginException
	 */
	public void adicionarUsuario(Usuario usuario) throws LoginException{
		try{
			co.com.gaslissa.expo.entity.Usuario user = usuarioRepository.consultarUsuario(usuario.getUsuario());
			
			if(user != null)
				throw new LoginException("Usuario ["+ usuario.getUsuario() +"] ya existe");
			
			user = new co.com.gaslissa.expo.entity.Usuario();
			user.setEsAdmin(usuario.isAdmin() ? 1 : 0);
			user.setIdUsuario(usuario.getUsuario());
			user.setPwd(usuario.getPwd());
			
			usuarioRepository.save(user);
			
			logger.info("Usuario ["+ user.getIdUsuario() +"] ha sido creado");
		}catch(Exception ex){
			logger.error("No se pudo guardar la información del usuario en la base de datos Expo: " + ex.getMessage());
			throw new LoginException("No se pudo guardar la información del usuario en la base de datos Expo: " + ex.getMessage(), ex);
		}
	}

}
