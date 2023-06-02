package algo230602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1018_체스판다시칠하기 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N,M;
	static char map[][];
	static char clone[][];
	static boolean visit[][];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				visit = new boolean[N][M];
				visit[i][j] = true;
				clonning();
				clone[i][j] = 'B';
				bfs(i, j);
				
				visit = new boolean[N][M];
				visit[i][j] = true;
				clonning();
				clone[i][j] = 'W';
				bfs(i, j);
			}
		}
		
		System.out.println(result);
	}
	
	public static void clonning() {
		clone = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				clone[i][j] = map[i][j];
			}
		}
	}
	
	public static void bfs(int i, int j) {
		Queue<chess> queue = new LinkedList<>();
		queue.add(new chess(i, j, clone[i][j]));
		
		int cnt = 0;
		if(map[i][j] != clone[i][j]) cnt++;
		while(!queue.isEmpty()) {
			chess c = queue.poll();
			
			if(cnt >= result) break;
			
			for (int k = 0; k < 4; k++) {
				int ni = c.i + di[k];
				int nj = c.j + dj[k];
					
				if(ni >= i && nj >= j && ni < i+8 && nj < j+8 && !visit[ni][nj]) {
					if(c.color == 'W') {
						if(clone[ni][nj] == 'W') {
							cnt++;
							clone[ni][nj] = 'B';
						}
					}else {
						if(clone[ni][nj] == 'B') {
							cnt++;
							clone[ni][nj] = 'W';
						}
					}
					visit[ni][nj] = true;
					queue.add(new chess(ni, nj, clone[ni][nj]));
				}
			} 
		}
		
		result = Math.min(result, cnt);
	}
	
	public static class chess {
		int i, j;
		char color;
		
		public chess(int i, int j, char color) {
			this.i = i;
			this.j = j;
			this.color = color;
		}
	}
	
}
