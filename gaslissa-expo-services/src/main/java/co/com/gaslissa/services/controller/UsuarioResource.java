/**
 * 
 */
package co.com.gaslissa.services.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.gaslissa.common.dto.Usuario;
import co.com.gaslissa.core.exception.LoginException;
import co.com.gaslissa.core.usuario.UsuarioCore;

/**
 * @author Jorge
 *
 */
@RestController
@RequestMapping("/gaslissa/usuario")
public class UsuarioResource {
	
	final static Logger logger = LoggerFactory.getLogger(UsuarioResource.class);
	
	private final UsuarioCore usuarioCore;

	/**
	 * @param usuarioCore
	 */
	@Autowired
	public UsuarioResource(UsuarioCore usuarioCore) {
		super();
		this.usuarioCore = usuarioCore;
	}
	
	@RequestMapping(value = "/autenticar", method = RequestMethod.POST)
	public ResponseEntity<Usuario> autenticar(@RequestBody Usuario usuario){
		try {
			Usuario user = usuarioCore.validarUsuario(usuario.getUsuario(), usuario.getPwd());
			if(user == null){
				return new ResponseEntity<Usuario>(user, HttpStatus.NOT_FOUND);
			}else{
				return new ResponseEntity<Usuario>(user, HttpStatus.OK);
			}
				
		} catch (LoginException e) {
			logger.error("No se pudo obtener información del usuario " + e.getMessage());
			return new ResponseEntity<Usuario>(new Usuario(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> adicionarUsuario(@RequestBody Usuario usuario){
		try {
			usuarioCore.adicionarUsuario(usuario);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} catch (LoginException e) {
			logger.error("No se pudo obtener información del usuario " + e.getMessage());
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
