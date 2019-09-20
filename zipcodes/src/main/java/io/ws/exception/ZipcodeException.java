package io.ws.exception;

/**
 * This Class will be used for all exceptions throughout
 *
 */

public class ZipcodeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8943633198007207637L;

	public ZipcodeException() {
		
	}

	/**
	 * Generates Exception with the message taken from log or from exception
	 * case
	 *
	 * @param message
	 *            from the exception case
	 */

	public ZipcodeException(String message) {
		super(message);
	}
}