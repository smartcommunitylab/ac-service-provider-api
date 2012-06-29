package eu.trentorise.smartcampus.ac.provider;

public class AcServiceException extends Exception {
	private static final long serialVersionUID = 1263952752723997093L;

	public AcServiceException() {
		super();
	}

	public AcServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AcServiceException(String message) {
		super(message);
	}

	public AcServiceException(Throwable cause) {
		super(cause);
	}

	
}
