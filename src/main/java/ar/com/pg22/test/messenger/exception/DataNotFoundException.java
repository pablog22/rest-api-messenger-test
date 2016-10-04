package ar.com.pg22.test.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3544701781659352788L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
