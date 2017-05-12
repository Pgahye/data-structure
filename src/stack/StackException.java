package stack;

public class StackException extends Exception {
	
	private static long serialVersionUID=1L;
	
	public StackException(){
		
		super("Stack Exception Occurs");
		
	}
	
	public StackException(String message){
		
		super(message);
		
	}
	
	

}
