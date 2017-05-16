package tree;

import java.util.Arrays;

import queue.Queue;

public class PriorityQueue<E> implements Queue<E> {
	
	private int size;
	private Comparator<E> comparator;
	private E[] arrayHeap;
	
	
	public PriorityQueue ( int capacity, Comparator<E> comparator){
		
		this.size=0;
		this.comparator= comparator;
		resize (capacity );
		
		
	}
	
	private void resize( int capacity ){
		
		E[] temp = (E[]) new Object[capacity ];
		
		for(int i= 0; i < size; i++){
			
			temp[ i ] = arrayHeap [i];
		}
		
		arrayHeap= temp;
		
	}
	
	public void offer(E item){
		
		if(arrayHeap.length <= size){
			
			resize(arrayHeap.length * 2);
		}
		
		int index= size+1;
		
		while(index != 1){
			
			int parentIndex = index / 2 ;
			//우선순위 알고리즘 
			
			int result =  comparator.compare(arrayHeap[parentIndex], item);
			if(result <= 0 ){
				
				break;
			}
			
			arrayHeap[index] = arrayHeap[parentIndex];
			index=parentIndex;
			
		}
		arrayHeap[index]=item;
		size++;
		
		
	}
	
	public E poll(){
		
		if(size == 0){
			
			throw new IndexOutOfBoundsException();
			
		}
		
		E data=arrayHeap[ 1 ];
		
		E lastItem = arrayHeap[size];
		
		int parentIndex = 1;
		
		while( true){
			
			int childIndex = 0; 
			int leftChildIndex = parentIndex * 2 ; 
			
			if(leftChildIndex > size){ //left가 없다는 이야기 , 왼쪽 자식 노드가 없음 
				
				break;
				
			}
			
			if(leftChildIndex == size){
				
				childIndex = leftChildIndex;
				
			}else{
				
				int rightChildIndex =  parentIndex * 2+1;
				
				int result= comparator.compare(arrayHeap[leftChildIndex], arrayHeap[rightChildIndex]);
				if(result <=0){
					
					childIndex = leftChildIndex;
					
				}else{
					childIndex = rightChildIndex;
				}
				
			}
			int result= comparator.compare(lastItem, arrayHeap[childIndex]);
			if(result <= 0 ){
				break;
			}
			
			arrayHeap[parentIndex] = arrayHeap[childIndex];
		
			parentIndex= childIndex;
			
		}
		
		arrayHeap[parentIndex] = lastItem;
		arrayHeap[size]=null;
		size--;
		
		//?
		return data;
		
	}
	public E peek(){
		System.out.println(Arrays.toString(arrayHeap));
		return arrayHeap[1];
	}


	

}
