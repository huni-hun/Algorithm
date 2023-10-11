package algo231011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b13549_숨바꼭질3 {
	static int result;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		visit = new boolean[100001];
		bfs(N, K);
		System.out.println(result);
	}
	
	public static void bfs(int N, int K) {
		PriorityQueue<Pos> pq = new PriorityQueue<Pos>();
		pq.add(new Pos(N, 0));
		
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(now.position == K) {
				result = now.cnt;
				return;
			}
			
			visit[now.position] = true;
			if(now.position*2 <= 100000 && !visit[now.position*2]) {
				pq.add(new Pos(now.position*2, now.cnt));
			}
			if(now.position+1 <= 100000 && !visit[now.position+1]) {
				pq.add(new Pos(now.position+1, now.cnt+1));
			}
			if(now.position-1 >= 0 && !visit[now.position-1]) {
				pq.add(new Pos(now.position-1, now.cnt+1));
			}
		}
	}
	
	public static class Pos implements Comparable<Pos>{
		int position;
		int cnt;
		
		public Pos(int position, int cnt) {
			this.position = position;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Pos p) {
			return this.cnt - p.cnt;
		}
	}
}
