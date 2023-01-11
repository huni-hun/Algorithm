package algo230111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697_숨바꼭질 {
	static int MIN = Integer.MAX_VALUE;
	static boolean[] list = new boolean[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		 
		bfs(N, K);
		System.out.println(MIN);
	}

	static void bfs(int n, int k) {
		Queue<Pos> queue = new LinkedList<Pos>();
		Pos pos = new Pos(n, 0);
		
		queue.add(pos);
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if(MIN <= now.time) continue;
			System.out.println(now.num + " / " + now.time);
			
			if(now.num == k) {
				MIN = Math.min(MIN, now.time);
			}
			
			if(now.num - 1 >= 0) {
				if(!list[now.num - 1]) {
					queue.offer(new Pos(now.num - 1, now.time+1));
					list[now.num - 1] = true;	
				}
			}
			
			if(now.num + 1 <= 100000) {
				if(!list[now.num + 1]) {
					queue.offer(new Pos(now.num + 1, now.time+1));
					list[now.num + 1] = true;
				}
			}
			
			if(now.num * 2 <= 100000) {
				if(!list[now.num * 2]) { 
					queue.offer(new Pos(now.num * 2, now.time+1));
					list[now.num * 2] = true;
				}
			}
		}
		
	}
	
	static class Pos {
		int num;
		int time;
		
		public Pos(int num, int time) {
			this.num = num;
			this.time = time;
		}
	}
	
//	static void dfs(int n, int k, int time) {
//
//		if(time > MIN) {
//			list[n+1] = false;
//			return;
//		}
//		if(n == k) {
//			MIN = Math.min(MIN, time);
//			list[n+1] = false;
//			return;
//		}
//		
//		if(n + 1 <= 100000) {
//			dfs(n + 1, k, time + 1);			
//		}
//		if(n - 1 >= 0) {
//			dfs(n - 1, k, time + 1);			
//		}
//		if(n * 2 <= 100000) {
//			dfs(n * 2, k, time + 1);			
//		}
//	}
	
}
