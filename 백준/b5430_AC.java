package algo230913;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class b5430_AC {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		firstloop : for (int tc = 0; tc < TC; tc++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < N; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 0;
			boolean isRight = false;
			for (int i = 0; i < command.length(); i++) {
				if(command.charAt(i) == 'R') {
					isRight = !isRight;
				} else {
					if(isRight) {
						if(deque.pollLast() == null) {
							sb.append("error").append("\n");
							continue firstloop;
						}
					} else {
						if(deque.pollFirst() == null) {
							sb.append("error").append("\n");
							continue firstloop;
						}
					}
				}
			}
			
			int size = deque.size();
			sb.append("[");
			for (int i = 0; i < size; i++) {
				if(isRight) sb.append(deque.pollLast());
				else sb.append(deque.pollFirst());
				if(i == size-1) continue;
				sb.append(",");
			}
			sb.append("]").append("\n");
			
		}
		System.out.println(sb);
		
	}
}
