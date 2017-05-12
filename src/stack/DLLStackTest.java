package stack;

public class DLLStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DLLStack<String> stack = new DLLStack<String>();
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.empty() == false) {
				String s = stack.pop();
				System.out.println(s);
			}

			System.out.println("======================================");

			stack = new DLLStack<String>();
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (StackException e) {

			System.out.println(e);
		}

	}

}