package algo230608;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b4949_균형잡힌세상 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String line = br.readLine();
			if(line.equals(".")) break;
			
			boolean flag = false;
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				
				if(c == '(' || c == '[') {
					stack.add(c);
				}else if(c == ')') {
					if(stack.size() == 0) {
						stack.add(c);
						break;
					}
					if(stack.peek() == '(') stack.pop();
					else break;
				}else if(c == ']') {
					if(stack.size() == 0) {
						stack.add(c);
						break;
					}
					if(stack.peek() == '[') stack.pop();
					else break;
				}
			}
			
			if(stack.size() == 0) flag = true;
			if(flag) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
