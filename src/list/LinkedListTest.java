package list;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	List<Integer> list=new LinkedList<Integer>();
		
		
		//add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
		
		printList(list);
		
		System.out.println("1번에 10 추가 ");
		
		list.add(1, 10);
		
		printList(list);
		
		System.out.println("0번에 17 추가 ");
		
		
		list.add(0, 17);
		
		printList(list);
		
		System.out.println("마지막에 55 추가, 9번에 100추가  ");
		list.add(55);
		
		list.add(9,100);
	

		printList(list);
		
		System.out.println("7번 삭제후 tail은 : "+list.remove(7));
		
		printList(list);
		
		//remove test
		
	//	list.removeAll();
		
	//	count=list.size();
	//	System.out.println("리스트크기: "+list.size() );
		
		
		try{
			//list.get(0);
		
		}catch(IndexOutOfBoundsException e){
			
			
			e.printStackTrace();
		}
		
	

	}
	
	public static void printList(List list){
		
		int count=list.size();
		
		System.out.println("리스트크기: "+list.size() );
		
		
		System.out.print("[");
		//get 연산 test
		for(int i=0;i<count;i++){
			
			
			//System.out.println(i + "번째 항목 :  "+ list.get(i));
			System.out.print( list.get(i) +",");
		
		}
		System.out.println("]");
		
		
	}

}
