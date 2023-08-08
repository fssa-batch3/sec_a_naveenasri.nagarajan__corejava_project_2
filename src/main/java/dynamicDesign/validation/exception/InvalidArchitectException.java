package dynamicDesign.validation.exception;

public class InvalidArchitectException extends Exception {

	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidArchitectException(String msg) {
		super(msg);
	}

	public InvalidArchitectException(Throwable e) {
		super(e);
	}
}