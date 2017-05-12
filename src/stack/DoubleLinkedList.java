package stack;



public class DoubleLinkedList<E> implements List<E> {
	
	
	
	private int size=0;
	private Node<E> head = null;
	private Node<E> tail = null;
	
	

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub

		final Node<E> newNode = new Node<E>(element);

		if (head == null) {

			head = newNode;
			tail = newNode;

		} else {

			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;

		}

		size++;

	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

		final Node<E> newNode = new Node<E>(element);

		if (size < index) {

			throw new IndexOutOfBoundsException("Index :" + index + ",size :" + size);
		}

		Node<E> x = head; // head
		Node<E> y = head; // head

		if (index == 0) {

			newNode.next = x;
			x.prev = newNode;
			newNode.prev = null;
			head = newNode;

		} else {

			if (size != index) {

				for (int i = 0; i < index - 1; i++) {

					x = x.next;
					y = x.next;

				}

				newNode.next = x.next; // head
				y.prev = newNode;
				x.next = newNode;
				newNode.prev = x;
			} else if ( size == index ){

				for (int i = 0; i < index - 1; i++) {

					x = x.next;

				}

				newNode.next = x.next;
				x.next = newNode;
				newNode.prev = x;
				tail=newNode;

			}

		}

		size++;

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub

		if (size <= index) {

			throw new IndexOutOfBoundsException("Index :" + index + ",size :" + size);
		}

		Node<E> x = head;

		for (int i = 0; i < index; i++) {

			x = x.next;

		}

		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub

		if (size <= index) {

			throw new IndexOutOfBoundsException("Index :" + index + ",size :" + size);
		}

		E data = null; 
			if( 0 == index ) {  // head 삭제 
				 
				data = head.data; 
					head = head.next; 
				if( head != null ) { 
					head.prev = null; 
					} 
			 
				} else if( size-1 == index ) { // tail 삭제 
		 			data = tail.data; 
					tail.prev.next = null; 
		 			tail = tail.prev; 
		 		} else { // 중간 삭제 
		
		 			Node<E> x = head; 
					for( int i = 0; i < index; i++ ) { 
		 				x = x.next; 
					} 
		 
		 
		 			data = x.data; 
		 			x.next.prev = x.prev; 
		 			x.prev.next = x.next; 
		 		} 
		 		 
		 		size--; 
		 		return data; 


	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
		Node<E> x=head;
		
		
		while(x!=null){
			
			Node<E> next=x.next;
			
			x.next=null;
			x.prev=null;
			x=next;
			
			
		}
		
		head=null;
		tail=null;
		size=0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public Object[] toArray() {
		Object[] arr = new Object[size];

		Node<E> x = head;
		int index = 0;
		while (x != null) {
			arr[index++] = x.data;
			x = x.next;
		}
		return arr;
	}	 

	
	private static class Node<E>{
		private Node<E> next;
		private Node<E> prev;
		private E data;
		
		private Node(E element){
			
			this.data=element;
			this.next=null;
			this.prev=null;
			
			
		}

		
	}
	
	
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
