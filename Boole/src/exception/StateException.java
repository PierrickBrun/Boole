package exception;

@SuppressWarnings("serial")
public class StateException extends Exception {

	private String message;

	public StateException(String message) {
		this.message = message;
	}

	public String toString() {
		return message;
	}

}
