/**
 * 
 */
package co.com.gaslissa.core.exception;

/**
 * @author Jorge
 *
 */
public class ClienteExpoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4752217027677320008L;
	/**
	 * @param message
	 */
	public ClienteExpoException(String message) {
		super(message);
	}
	/**
	 * @param message
	 * @param cause
	 */
	public ClienteExpoException(String message, Throwable cause) {
		super(message, cause);
	}

}
