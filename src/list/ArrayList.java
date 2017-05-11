package list;


public class ArrayList<E> implements List<E> {
	
	
	private static final int INIT_CAPACITY=10;
	private int size; //자료정의
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		
		size=0;
		//data=(E[])new Object[INIT_CAPACITY];
		resize();
		
	}
	
	private void resize() {

		int capacity = (data==null)? INIT_CAPACITY : data.length*2; //젤처음일때 (null일때) 를 위해서...
		E[] temp = (E[]) new Object[capacity];

		for (int i = 0; i < size; i++) {

			temp[i] = data[i];

		}

		data = temp;

	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		
		if(data.length <= size){
			
			resize();
			
		}
		
		data[size]=element; //퍼퍼가 없을때는 1, 꽉차있을때는 n 최악을 항상 고려하기때문에 add 연산에서 복잡도는 n 
		size++;
		

	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

		E temp = null;
		E temp1 = null;
		if (data.length <= size) {

			resize();

		}

		for (int i = 0; i < size; i++) {

			if (i == index) {

				temp = data[i];
				data[i] = element;

				size++;
			} else if (i > index) {

				temp1 = data[i];
				data[i] = temp;
				temp = temp1;

			}

		}

	}

	@Override
	public E get(int index) { //시간복잡도 1임 
		// TODO Auto-generated method stub
		
		if(index == size){
			
			throw new IndexOutOfBoundsException("Index :"+index+",size :"+size);
		}
		
		return data[index];
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub

		
		
		if(index == size){
			
			throw new IndexOutOfBoundsException("Index :"+index+",size :"+size);
		}
		
		for(int i=0;i< size;i++){
			
			if(i>=index){
				
				data[i]=data[i+1];
				
				
			}
			
		}
		size--;
		
		return null;
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<size;i++){
			
			data[i]=null;
			
			
		}
		size=0;

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public Object[] toArray(){
		
		return null;
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
				
			
				return data[index++];
			} //익명클래스 
			
			
			
		};
	}
	

	

}
