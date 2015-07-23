/**
 * 
 */
package co.com.gaslissa.common.enums;

/**
 * @author Jorge
 *
 */
public enum EstadoCliente {
	
	NO_FIDELIZADO("CLIENTE NO FIDELIZADO");
	
	private final String estado;

	EstadoCliente(String estado){
		this.estado = estado;
	}
	
	public String descripcion(){
		return this.estado;
	}
}
