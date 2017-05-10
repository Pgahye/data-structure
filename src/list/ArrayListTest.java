package list;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> list=new ArrayList<Integer>();
		
		
		//add 연산
		list.add(11);
		list.add(22);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(44);
		
		list.add(5, 10);
		
		//size 연산

		int count=list.size();
		System.out.println("리스트크기: "+list.size() );
		
		//get 연산 test
		for(int i=0;i<count;i++){
			
			
			System.out.println(i + "번째 항목 :  "+ list.get(i));
			
		}
		
		list.remove(6);
		//remove test
		
		//list.removeAll();
		
	//	count=list.size();
	//	System.out.println("리스트크기: "+list.size() );
		count=list.size();
		System.out.println("리스트크기: "+list.size() );
		
		//get 연산 test
		for(int i=0;i<count;i++){
			
			
			System.out.println(i + "번째 항목 :  "+ list.get(i));
			
		}
		
		try{
		//	list.get(0);
		
		}catch(IndexOutOfBoundsException e){
			
			
			e.printStackTrace();
		}

	}

}
