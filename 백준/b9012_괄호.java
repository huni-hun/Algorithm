package algo230503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012_괄호 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String Line = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for(int j = 0; j < Line.length(); j++) {
				if(stack.size() == 0) {
					stack.add(Line.charAt(j));
					
				}else {
					if(stack.peek() == '(') {
						if(Line.charAt(j) == ')') stack.pop();
						else stack.add(Line.charAt(j));
					}
				}
				
			}
			if(stack.size() == 0) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
}
