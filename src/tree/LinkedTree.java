package tree;

import list.List;
import stack.Stack;
import stack.StackException;
import tree.LinkedTree.TreeNode;

public class LinkedTree<E> {

	private TreeNode<E> root;

	public LinkedTree(E data) {

		root = new TreeNode<E>(data);

	}

	public LinkedTree() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> node, E data) {

		final TreeNode<E> leftnode = new TreeNode<E>(data);

		node.left = leftnode;
		return leftnode;

	}

	public TreeNode<E> insertRight(TreeNode<E> node, E data) {
		final TreeNode<E> rightnode = new TreeNode<E>(data);

		node.right = rightnode;
		return rightnode;
	}

	public void traversalPostorder(List<E> result) {
		traversalPostorder(root, result);
	}

	public void traversalPreorder(List<E> result) {
		traversalPreorder(root, result);
	}

	public void traversalInorder(List<E> result) {
		traversalInorder(root, result);
	}

	public void traversalPostorder(TreeNode<E> node, List<E> list) {

		if (node.left != null) {
			traversalPostorder(node.left, list);

		}

		if (node.right != null) {
			traversalPostorder(node.right, list);

		}

		list.add(node.data);
	}

	public void traversalPreorder(TreeNode<E> node, List<E> result) {

		result.add(node.data);

		if (node.left != null) {
			traversalPreorder(node.left, result);
		}

		if (node.right != null) {
			traversalPreorder(node.right, result);
		}

	}

	public void traversalInorder(TreeNode<E> node, List<E> result) {

		if (node.left != null) {
			traversalInorder(node.left, result);
		}

		result.add(node.data);

		if (node.right != null) {
			traversalInorder(node.right, result);
		}

	}

	public static class TreeNode<E> {
		private TreeNode<E> left;
		private TreeNode<E> right;
		private E data;

		public TreeNode(E data) {

			this.data = data;
			this.left = null;
			this.right = null;

		}

		public E getdata() {

			return data;
		}
	}

	public static double evaluteExpression(TreeNode<String> treeNode) { // 루트를
																		// 던져줌

		double result = 0;
		double left = 0;
		double right = 0;

		if (treeNode.left != null) {

			left = evaluteExpression(treeNode.left);

		}

		if (treeNode.right != null) {

			right = evaluteExpression(treeNode.right);

		}

		if (treeNode.data.equals("+")) {

			result = left + right;

		}

		else if (treeNode.data.equals("-")) {

			result = left - right;

		} else if (treeNode.data.equals("*")) {

			result = left * right;

		} else if (treeNode.data.equals("/")) {

			result = left / right;

		} else
			result = Double.parseDouble(treeNode.data);

		return result;

	}

	public static LinkedTree<String> MakeExpressionTree(String postfix) throws StackException {

		LinkedTree<String> tree = new LinkedTree<String>();

		int index = 0;
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();

		for (int i = 0; i < postfix.length(); i++) {

			TreeNode<String> treeNode = new TreeNode<String>(String.valueOf(postfix.charAt(i)));

			// System.out.println(" 노드 값 : " +postfix.charAt(i) );

			if (postfix.charAt(i) == '+' || postfix.charAt(i) == '-' || postfix.charAt(i) == '*'
					|| postfix.charAt(i) == '/') {

				treeNode.right = stack.pop();
				treeNode.left = stack.pop();
				// tree.insertRight(treeNode, stack.pop());

				// tree.insertLeft(node, (E) stack.pop());

				stack.push(treeNode);

			}

			if (postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9') {

				stack.push(treeNode);

				// System.out.println("push " + stack.peek().getdata());
			}

		}

		tree.root = stack.pop();

		System.out.println("root " + tree.getRoot().data);

		System.out.println("root " + tree.getRoot().left.data);
		System.out.println("root " + tree.getRoot().right.data);

		return tree;

	}

}
