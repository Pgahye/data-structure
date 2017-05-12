package queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Queue<String> q = new DoubleLinkedList<String>(); 

		q.offer( "둘리" );
		q.offer( "마이콜" );
		q.offer( "도우넛" );
		q.offer( "또치" );
				
		System.out.println( q.poll() );
		System.out.println( q.poll() );
		System.out.println( q.peek() );
		System.out.println( q.poll() );
		System.out.println( q.poll() );
		System.out.println( q.poll() );
		System.out.println( q.peek() );

		
	}

}
