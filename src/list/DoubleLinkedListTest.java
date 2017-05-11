package list;

import java.util.Arrays;

public class DoubleLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> list=new DoubleLinkedList<Integer>();
		
		
		//add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
		
		System.out.println(Arrays.toString(list.toArray()));
		

		list.add(0, 17);
		System.out.println(Arrays.toString(list.toArray()));
		
	
		list.add(55);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		
		list.add(3, 10);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		list.add(9,100);
	
		System.out.println(Arrays.toString(list.toArray()));
		
		
		list.remove(0);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		list.remove(5);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		int count=list.size();
		
		System.out.println("리스트크기: "+list.size() );
		
		list.remove(7);
		
		System.out.println(Arrays.toString(list.toArray()));
		
		
		
		//remove test
		
		list.removeAll();
			
		Iterator<Integer> it=list.iterator();
		
		System.out.print(" iterator : [");
		
		while(it.hasNext()){
			
			int i=it.next(); //auto boxing
			
			System.out.print(i+" ");
		}
		
		System.out.println(" ] ");
			
			try{
			//	list.get(0);
			
			}catch(IndexOutOfBoundsException e){
				
				
				e.printStackTrace();
			}

	}

}
