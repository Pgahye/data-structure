package tree.test;


import queue.Queue;

import tree.Comparator;

import tree.PriorityQueue;



public class PriorityTest02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> pq = new PriorityQueue<String>(10, new Comparator<String>()
		{

			@Override

			public int compare(String o1, String o2) {

				return o1.length() - o2.length();

			}

		});

			// 초기에 사이즈를 잡아줌 , 배열로 되어있다 . 끝노드 삽입 위치를 찾아주는데 용이함, 인터페이스를 생성해주면서 바로
			// 넣어줌
		
		pq.offer("A");
		pq.peek();
		pq.offer("ABCDEF");
		pq.peek();
		pq.offer("ABC");
		pq.peek();
		pq.offer("ABCDEFGHI");
		pq.peek();
		pq.offer("ABCDE");
		pq.peek();
		pq.offer("AB");
		pq.peek();
		
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		System.out.println(pq.poll());
		pq.peek();
		//.out.println(pq.poll());
		//System.out.println(pq.poll());
		//System.out.println(pq.poll());
		//System.out.println(pq.poll());

	
	}

}
