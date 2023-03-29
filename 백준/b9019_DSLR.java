package algo230329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b9091_DSLR {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start = st.nextToken(); 
			int end = Integer.parseInt(st.nextToken());
			
			Queue<Value> queue = new LinkedList<Value>();
			queue.add(new Value(start, ""));
			boolean visit[] = new boolean[10000];
			visit[Integer.parseInt(start)] = true;
			
			while(!queue.isEmpty()) {
				Value now = queue.poll();
				if(Integer.parseInt(now.num) == end) {
					System.out.println(now.command);
					break;
				}
				
				int temp = Integer.parseInt(now.num);
				temp = Value.getD(temp);
				if(!visit[temp]) {
					queue.add(new Value(temp+"", now.command + "D"));
					visit[temp] = true;
				}
				
				temp = Integer.parseInt(now.num);
				temp = Value.getS(temp);
				if(!visit[temp]) {
					queue.add(new Value(temp+"", now.command + "S"));
					visit[temp] = true;
				}
				
				String str = now.num;
				str = Value.getL(str);
				if(!visit[Integer.parseInt(str)]) {
					queue.add(new Value(str, now.command + "L"));
					visit[Integer.parseInt(str)] = true;
				}
				
				str = now.num;
				str = Value.getR(str);
				if(!visit[Integer.parseInt(str)]) {
					queue.add(new Value(str, now.command + "R"));
					visit[Integer.parseInt(str)] = true;
				}
				
			}
			
		}
	}
	
	public static class Value {
		String num;
		String command;
		
		public Value(String num, String command) {
			this.num = num;
			this.command = command;
		}
		
		static int getD(int num) {
			int temp = num * 2;
			if(temp * 2 > 9999) {
				temp %= 10000;
			}
			return temp;
		}

		static int getS(int num) {
			if(num == 0) {
				return 9999;
			}
			int temp = num - 1;
			return temp;
		}
		
		static String getL(String str) {
			int len = str.length();
			if(len == 1) {
				str = "000" + str;
			}else if(len == 2) {
				str = "00" + str;
			}else if(len == 3) {
				str = "0" + str;
			}

			char fir = str.charAt(0);
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < 3; i++) {
				sb.setCharAt(i, str.charAt(i+1));
			}
			sb.setCharAt(3, fir);
			return sb.toString();	
			
		} // end L
		
		static String getR(String str) {
			int len = str.length();
			if(len == 1) {
				str = "000" + str;
			}else if(len == 2) {
				str = "00" + str;
			}else if(len == 3) {
				str = "0" + str;
			}
			
			char end = str.charAt(3);
			StringBuilder sb = new StringBuilder(str);
			for (int i = 3; i > 0; i--) {
				sb.setCharAt(i, str.charAt(i-1));
			}
			sb.setCharAt(0, end);
			return sb.toString();			
		} // end R
		
	}
	
}
