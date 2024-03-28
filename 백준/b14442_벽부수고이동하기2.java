package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b14442_벽부수고이동하기2 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M, K, result;
	static int map[][];
	static boolean visit[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[K+1][N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result != Integer.MAX_VALUE ? result : -1);
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0, 1, K));
		
		visit[0][0][0] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if(now.x == N-1 && now.y == M-1) {
				result = now.cnt;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || visit[now.chance][ni][nj]) continue;
				if(map[ni][nj] == 1) {
					if(now.chance == 0) continue;
					
					visit[now.chance ][ni][nj] = true;
					queue.add(new Pos (ni, nj, now.cnt + 1, now.chance - 1));
				} else {
					visit[now.chance][ni][nj] = true;
					queue.add(new Pos(ni, nj, now.cnt + 1, now.chance));
				}
			}
		}
	}
	
	public static class Pos {
		int x, y;
		int cnt;
		int chance;
		
		public Pos(int x, int y, int cnt, int chance) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.chance = chance;
		}
		
	}
}
