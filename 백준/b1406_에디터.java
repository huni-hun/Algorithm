package algo230831;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1406_에디터 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String text = br.readLine();
		int n = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < text.length(); i++) {
			list.add(text.charAt(i));
		}
		
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) iter.next();
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			char key = line.charAt(0);
			if(key == 'L') {
				if(iter.hasPrevious())
					iter.previous();
			} else if(key == 'D') {
				if(iter.hasNext())
					iter.next();
			} else if(key == 'B') {
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				iter.add(line.charAt(2));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}
		System.out.println(sb);

//     	스택 풀이		
//		Stack<String> leftStack = new Stack<>();
//		Stack<String> rightStack = new Stack<>();
//		
//		String Line = br.readLine();
//		int N = Integer.parseInt(br.readLine());
//		
//		for (int i = 0; i < Line.length(); i++) {
//			leftStack.push(Line.substring(i, i+1));
//		}
//		
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			String command = st.nextToken();
//			if(command.equals("L")) {
//				if(leftStack.empty()) {
//					continue;
//				}else {
//					rightStack.push(leftStack.pop());
//				}
//				
//			}else if(command.equals("D")) {
//				if(rightStack.empty()) {
//					continue;
//				}else {
//					leftStack.push(rightStack.pop());
//				}
//			}else if(command.equals("B")) {
//				if(leftStack.empty()) {
//					continue;
//				}else {
//					leftStack.pop();
//				}
//			}else if(command.equals("P")) {
//				String add = st.nextToken();
//				leftStack.push(add);
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < leftStack.size(); i++){
//            sb.append(leftStack.get(i));
//        }
//        for (int i = rightStack.size() - 1; i >= 0; i--){
//        	sb.append(rightStack.get(i));
//        }
//        
//        System.out.println(sb);
	}
}
