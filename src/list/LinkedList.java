package list;

public class LinkedList<E> implements List<E> {

	
	private Node<E> head= null;
	private Node<E> tail = null;
	
	private int size =0 ;
	

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

		Node<E> newNode = new Node<E>(element);

		if (head == null) {
			head = newNode;
			tail = newNode;
			
			
		} else {

			Node<E> x = tail;


			x.next = newNode;
			tail=newNode;

		}
		size++;

	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

		Node<E> newNode = new Node<E>(element);

		if (index > size) {

			throw new IndexOutOfBoundsException("Index :" + index + ",size :" + size);
		}

		Node<E> x = head;
		Node<E> y = head;

		if (index == 0) {

			newNode.next = y;
			head = newNode;

		} else {

			for (int i = 0; i < index; i++) {

				y = x;
				x = x.next;

			}

			newNode.next = y.next;
			y.next = newNode;
			
			if(index==size){
				
				tail=newNode;
			}

		}

		size++;

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		
		if(size<= index){
			
			throw new IndexOutOfBoundsException("Index :"+index+",size :"+size);
		}
		
		Node<E> x=head;
		
		for(int i=0; i<index; i++){
			
			x=x.next;
			
		}
		
		
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub

		if (size <= index) {

			throw new IndexOutOfBoundsException("Index :" + index + ",size :" + size);
		}

		Node<E> x = head;
		Node<E> y = head;

		for (int i = 0; i < index; i++) {

			y = x;
			x = x.next;

		}

		if (index == 0) {

			head = y.next;

		} else {

			y.next = x.next;
			
			if(y.next==null){
				
				tail=y;
			}

		}
		size--;

		return tail.data;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		for(Node<E> x=head; x!=null;){
			
			Node<E> next=x.next;
			
			x.data=null;
			x.next=null;
			x=next;
			
		}
		
		tail=null;
		head=null;
		size=0;

	}

	@Override
	public int size() {
		
		// TODO Auto-generated method stub
		return size;
	}
	


	
	private static class Node<E>{
		private Node<E> next;
		private E data;
		
		private Node(E element){
			
			this.data=element;
			this.next=null;
			
			
		}

		private Node(E element, Node<E> next){
			this.data=element;
			this.next=next;
			
		}
		
	}
	
	public Object[] toArray() { 
				Object[] arr = new Object[ size ]; 
		 
		 		Node<E> x = head; 
		 		int index = 0; 
		 		while( x != null ) { 
		 			arr[ index++ ] = x.data; 
		 			x = x.next; 
		 		}		 
		 		return arr; 
		 	}	 

		
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<E>(){

			private int index=0;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < size;
			}

			
			
			@Override
			public E next() {
				// TODO Auto-generated method stub
				
			
				return get(index++);
			} //익명클래스 
			
			
			
		};
	}
	
}
