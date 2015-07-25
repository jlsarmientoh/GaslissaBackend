/**
 * 
 */
package co.com.gaslissa.core.cierre;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.gaslissa.core.exception.ClienteExpoException;
import co.com.gaslissa.expo.config.repository.ClienteRepository;
import co.com.gaslissa.expo.entity.Cliente;

/**
 * @author Jorge
 *
 */
public class ClientesExpoCore {
	
	final static Logger logger = LoggerFactory.getLogger(ClientesExpoCore.class);
	
	private final ClienteRepository clienteRepositoryExpo;
	
	public ClientesExpoCore(ClienteRepository clienteRepositoryExpo){
		this.clienteRepositoryExpo = clienteRepositoryExpo;
	}
	
	public List<Cliente> consultarClientes() throws ClienteExpoException{
		try{
			return (List<Cliente>) this.clienteRepositoryExpo.findAll();
		}catch(Exception ex){
			logger.error("No se puede obtener la lista de clientes desde la base de datos Expo: " + ex.getMessage());
			throw new ClienteExpoException("No se puede obtener la lista de clientes desde la base de datos Expo: " + ex.getMessage(), ex);
		}
	}

}
