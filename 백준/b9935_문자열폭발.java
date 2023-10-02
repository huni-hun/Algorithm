package algo231002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9935_문자열폭발 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		String bomb = br.readLine();
		int len = bomb.length();
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			stack.add(line.charAt(i));
			
			if(stack.size() >= len) {
				boolean flag = true;
				
				for (int j = 0; j < len; j++) {
					if(stack.get(stack.size() - len + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}

				if(flag) {
					for (int j = 0; j < len; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : stack) {
			sb.append(c);
		}
		
		if(sb.toString().length() != 0) {
			System.out.println(sb);
		} else {
			System.out.println("FRULA");
		}
	}
}
