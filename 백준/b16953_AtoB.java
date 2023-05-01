package algo230501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16953_AtoB {
	static int result = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		bfs(A, B);
		System.out.println(result);
	}
	
	public static void bfs(int a, int b) {
		Queue<Num> queue = new LinkedList<Num>();
		queue.add(new Num(a, 1));
		
		String t = b + "";
		int len = t.length();
		while(!queue.isEmpty()) {
			Num now = queue.poll();
			
			if(now.n == b) {
				result = now.cnt;
				break;
			}
			
			if(now.n * 2 < b)
			queue.add(new Num(now.n * 2, now.cnt + 1));
			
			t = now.n + "";
			if(len > t.length()) {
				String temp = now.n + "1";
				queue.add(new Num(Double.parseDouble(temp), now.cnt + 1));
			}
		}
	}
	
	public static class Num {
		double n;
		int cnt;
		
		public Num(double n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}
