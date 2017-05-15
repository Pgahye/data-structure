package tree;

import list.LinkedList;
import list.List;
import stack.Stack;
import stack.StackException;
import tree.LinkedTree.TreeNode;

public class MakeExpressionTree<E> extends LinkedTree<E> {

	

 		 


	
	LinkedTree.TreeNode<E> node;
	LinkedTree<E> tree;
	Stack<LinkedTree<E>> stack=new Stack<LinkedTree<E>>();
	String postfix=null;
	
	public MakeExpressionTree(E data) throws StackException {
		super(data);
		this.postfix=(String) data;
		// TODO Auto-generated constructor stub
		
		//System.out.println(postfix);
		
		MakeExpressionTree();
		
	}
	public LinkedTree<E> MakeExpressionTree() throws StackException{
		
		for (int i = 0; i < postfix.length(); i++) {

			node = new LinkedTree.TreeNode(postfix.charAt(i));
			
			 System.out.println(" 노드 값 : " +postfix.charAt(i) );

			if (stack.size() == 2) {
				
				tree=new LinkedTree(node);
	
				tree.insertRight(node, (E) stack.pop());
				
				tree.insertLeft(node, (E) stack.pop());
				
			//	stack.push(node);
			//	System.out.println("트리생성 peek " + stack.peek().getdata());

			}

			if (postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9') {

			//	stack.push(node);

			//	System.out.println("push " + stack.peek().getdata());
			}
			
		}
		
		stack.pop();
	

		
		return tree;
		
	}
	



	
	


	
	
	
	
}
