package itchy;

public class ElementNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1735884891408002728L;
	
	public ElementNotFoundException(String message) {
		super(message);
	}
}
