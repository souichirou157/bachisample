package demo.app.warning;

public class InputMissmatchException extends Exception{

	public InputMissmatchException (){}
	
	public InputMissmatchException (String message) {
		
		new Exception(message);
	}
}
