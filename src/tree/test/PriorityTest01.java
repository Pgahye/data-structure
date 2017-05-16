package tree.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> pq = new PriorityQueue<String>(10, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) { // 값 비교후 노드값을 바꿔줄때 사용 
				// TODO Auto-generated method stub
				return o1.length() - o2.length(); //앞에가 길면 +, 같으면 0, 짧으면 -  앞에가 작은 게 기본임....(minheap) 
			}

		}); // 초기에 사이즈를 잡아줌 , 배열로 되어있다 . 끝노드 삽입 위치를 찾아주는데 용이함, 인터페이스를 생성해주면서 바로
			// 넣어줌
		
		pq.offer("A");
		pq.offer("ABCDE");
		pq.offer("ABC");
		pq.offer("ABCDEFGHI");
		pq.offer("ABCDE");
		
		while(pq.isEmpty()==false){
			
			
			System.out.println(pq.poll());
			
			
		}
	}

}
