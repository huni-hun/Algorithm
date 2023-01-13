package algo230113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178_미로탐색 {
	static int N, M, result;
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, -1, 0, 1};
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = Integer.MAX_VALUE;
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String Line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = (Line.charAt(j) - '0');
			}
		}
		
		visit[0][0] = true;
//		dfs(0, 0, 1);
		bfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static void bfs(int i, int j, int cnt) {
		Queue<Pos> queue = new LinkedList<b2178_미로탐색.Pos>();
		Pos pos = new Pos(i, j, cnt);
		
		queue.offer(pos);
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if (now.i == N-1 && now.j == M-1) {
			result = Math.min(result, now.cnt);
			return;
		}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1 && visit[ni][nj] == false) {
					visit[ni][nj] = true;
					queue.offer(new Pos(ni, nj, now.cnt+1));
				}		
			}
		}
	}
	
//	static void dfs(int i, int j, int cnt) {
//		if(cnt > result) return;
//		System.out.println(i + " " + j + " " + cnt);
//		
//		if(i == N-1 && j == M-1) {
//			result = Math.min(result, cnt);
//			return;
//		}
//		
//		for (int k = 0; k < 4; k++) {
//			int ni = i + di[k];
//			int nj = j + dj[k];
//			
//			if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1 && visit[ni][nj] == false) {
//				visit[ni][nj] = true;
//				dfs(ni, nj, cnt+1);
//				visit[ni][nj] = false;	
//			}		
//		}
//	}
	
	static class Pos {
		int i;
		int j;
		int cnt;
		
		public Pos(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
