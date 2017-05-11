package list;



public class CircularLinkedList<E> implements List<E> {
	
	
	private int size=0;
	private Node<E> tail;
	private Node<E> pos;

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
		final Node<E> newNode=new Node<E>(element);
		
		
		if(tail == null){
			
			newNode.next=newNode;
			tail = newNode;
		}else{
			
			newNode.next=tail.next; //head
			tail.next=newNode;
			tail=tail.next;
			
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

		Node<E> x = tail.next; // head

		if (index == 0) {

			x = tail;

		} else {

			for (int i = 0; i < index - 1; i++) {

				x = x.next;

			}

		}

		newNode.next = x.next; // head
		x.next = newNode;

		if (x == tail) {

			tail = newNode;
		}

		size++;

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
	if(size<= index){
			
			throw new IndexOutOfBoundsException("Index :"+index+",size :"+size);
		}
		
		Node<E> x=tail.next; //head
		for(int i=0; i< index; i++){
			
			x=x.next;
			
		}
		
		return x.data;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		
		if(size<= index){
			
			throw new IndexOutOfBoundsException("Index :"+index+",size :"+size);
		}
		Node<E> x=tail.next; //head
		Node<E> y=tail.next;
		
		if (index == 0) {

			tail.next =x.next;
			x.next=null;

		} else {

			for (int i = 0; i < index; i++) {
				
				y = x;
				x = x.next;

			}

		}

	

		if (x == tail) {
			
			y.next = x.next;
			tail=y;
			
		}else{
			
			y.next = x.next; // head
			x.next = null;
			
		}

		
		size--;
		
		
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
		Node<E> x= tail.next; //head로 이동
		
		while(x != tail){
			
			Node<E> next=x.next;
			
			x.next=null;
			x=next;
			
			
		}
		
		tail.next=null;
		tail=null;
		size=0;
		

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	public Object[] toArray(){
		
		Object[] arr=new Object[size];
		
		
		if(tail==null){
			
			return arr;
		}
		Node<E> x=tail.next; 
		
		int index=0;
		while(x!=null){
			
			arr[index++] = x.data;
			x=x.next;
			
			if(x==tail.next){ //다시 head로 돌아옴 
				
				break;
			}
			
		}
		
		return arr;
	}

	public E next() {



		if (tail.next == null) {

			return null;
			
		} else {

			if(pos==null){
				
				pos = tail.next;
			}
			else{
			pos = pos.next;
			}
		}

		return pos.data;

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
