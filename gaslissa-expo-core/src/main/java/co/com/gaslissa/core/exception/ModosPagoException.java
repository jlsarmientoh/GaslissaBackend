/**
 * 
 */
package co.com.gaslissa.core.exception;

/**
 * @author Jorge
 *
 */
public class ModosPagoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3991005702960532155L;

	/**
	 * @param message
	 */
	public ModosPagoException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ModosPagoException(String message, Throwable cause) {
		super(message, cause);
	}
}
