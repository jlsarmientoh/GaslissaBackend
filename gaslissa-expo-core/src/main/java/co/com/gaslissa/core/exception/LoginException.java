/**
 * 
 */
package co.com.gaslissa.core.exception;

/**
 * @author Jorge
 *
 */
public class LoginException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8686265675521635853L;

	/**
	 * @param message
	 * @param cause
	 */
	public LoginException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public LoginException(String message) {
		super(message);
	}	
}
