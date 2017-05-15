package recursion;

public class FibonacciTest {
	
	
	public static int countofcall=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		for(int i=0; i<=11; i++){
			
			countofcall=0;
			System.out.print(fibonacci(i) + " "+countofcall);
			
		}
		
		
	}
	public static int fibonacciLoop(int n){
		
		return 0;
	}
	public static int fibonacci(int n) {
		
		countofcall++;
		
		if(n==0){
			return 0;
		}
		else if (n==1){
			
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
		
	
	}
	
	

}
