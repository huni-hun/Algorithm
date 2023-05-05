package algo230505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b12851_숨바꼭질2 {
	static int result = 0;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		if(N < X) {
			bfs(N, X);
		}else {
			result = N - X;
			count = 1;
		}
		System.out.println(result);
		System.out.println(count);
	}
	
	public static void bfs(int n, int x) {
		Queue<Move> queue = new LinkedList<Move>();
		queue.add(new Move(n, 0));
		
		int[] visit = new int[100001];
		visit[n] = 1;
		boolean flag = false;
		while(!queue.isEmpty()) {
			Move now = queue.poll();
			
			if(now.point == x) {
				result = now.cnt;
				count++;
				flag = true;
			}
			
			if(flag && result < now.cnt) break;
			
			for(int i = 0; i < 3; i++) {
				int next = 0;
				
				if(i == 0) next = now.point - 1;
				else if(i == 1) next = now.point + 1;
				else next = now.point * 2;
				
				if(next < 0 || next > 100000) continue;
				
				if(visit[next] == 0 || visit[next] == visit[now.point] + 1) {
					queue.add(new Move(next, now.cnt + 1));
					visit[next] = visit[now.point] + 1;
				}
			}
			
		}
	}
	
	public static class Move {
		int point;
		int cnt;
		
		public Move(int point, int cnt) {
			this.point = point;
			this.cnt = cnt;
		}
	}
}
