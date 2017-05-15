package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import list.LinkedList;
import list.List;
import tree.LinkedTree;
import tree.MakeExpressionTree;

public class postfixCal {
	
	
	
	public static void main(String[] args) throws StackException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		try {
			
			System.out.print("수식을 입력하시오 : ");
			String input= br.readLine();
			
			String postfix= toPostfix(input.replaceAll("",""));
			
			
			
			System.out.println(postfix);
			LinkedTree<String> tr = LinkedTree.MakeExpressionTree( postfix ); 

			LinkedTree<String> trs=new LinkedTree<String>();
			
			trs.MakeExpressionTree( postfix );  ///이건 왜 안되지????
			
			
			double result =  LinkedTree.evaluteExpression( tr.getRoot() );		
		
			System.out.println("결과 " + result);
			
			List<String> list = new LinkedList<String>(); 
			
			tr.traversalPostorder( list );
			//System.out.println( list.toString() ); 
			
			
		//	double result = calculator(postfix);
			
			//System.out.println(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static double calculator(String postfix) throws StackException{
		
		double number1=0;
		double number2=0;

		Stack<Double> stack = new Stack<Double>();
		
	
		
		
		for (int i = 0; i < postfix.length(); i++) {
			
			if (postfix.charAt(i) == '+' ) {
				
				number2=stack.pop();
				number1=stack.pop();
				

				stack.push(number1+number2);
				
				
			}else if(postfix.charAt(i) == '-' ){
				number2=stack.pop();
				number1=stack.pop();
				
			
				stack.push(number1-number2);
				
			}
			else if(postfix.charAt(i) == '*' ){
				number2=stack.pop();
				number1=stack.pop();
				
			
				stack.push(number1*number2);
				
			}else if(postfix.charAt(i) == '/' ){
				number2=stack.pop();
				number1=stack.pop();
				
		
				stack.push(number1/number2);
				
			}
			
		else if (postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9') {
				
				stack.push( Double.valueOf(postfix.charAt(i))-48);
				
				
				
			}
			
			
		}
		
		return stack.pop();
		
		
	}
	
	public static String toPostfix(String infix) throws StackException {

		String number = "";

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < infix.length(); i++) {

			if (infix.charAt(i) == '+' || infix.charAt(i) == '-') {

				if (stack.empty() == true) {

					stack.push(infix.charAt(i));

				} else if (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-') {

					while (stack.empty() != true) {

						if (stack.peek() != '(') {
							// System.out.println(stack.peek());

							number = number + stack.pop();

						} else {
							break;
						}
					}

					stack.push(infix.charAt(i));

				} else if (stack.peek() == '(') {

					stack.push(infix.charAt(i));

				}

			} else if (infix.charAt(i) == '*' || infix.charAt(i) == '/') {

				if (stack.empty() == true) {

					stack.push(infix.charAt(i));

				} else if (stack.peek() == '*' || stack.peek() == '/') {

					while (stack.empty() != true) {

						if (stack.peek() != '(') {
							// System.out.println(stack.peek());

							number = number + stack.pop();

						} else {
							break;
						}
					}

					stack.push(infix.charAt(i));

				} else if (stack.peek() == '+' || stack.peek() == '-') {

					stack.push(infix.charAt(i));

				} else if (stack.peek() == '(') {

					stack.push(infix.charAt(i));

				}

			}

			else if (infix.charAt(i) == '(') {

				stack.push(infix.charAt(i));

			} else if (infix.charAt(i) == ')') {

				while (stack.peek() != '(') {

					number = number + stack.pop();
				}

				if (stack.peek() == '(') {

					stack.pop();
				}

			} else if (infix.charAt(i) >= '0' && infix.charAt(i) <= '9') {

				number = number + infix.charAt(i);

			}

		}

		while (stack.empty() != true) {

			number = number + stack.pop();
		}

		return number;
	}

}
