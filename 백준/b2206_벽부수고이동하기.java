package algo230628;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2206_벽부수고이동하기 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M, result = -1;
	static int map[][];
	static boolean visit[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M][2];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(new Pos(0, 0, 1, false));
		
		visit[0][0][0] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
//			System.out.println(now.i + " / " + now.j + " / cnt : " + now.cnt + " / using : " + now.using);
			if(now.i == N - 1 && now.j == M - 1) {
				result = now.cnt;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				
//				System.out.println(ni + " / " + nj);
				// 벽 부수기 사용
				if(now.using) {
					if(ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[ni][nj][1] && map[ni][nj] == 0) {
						queue.add(new Pos(ni, nj, now.cnt + 1, true));
						visit[ni][nj][1] = true;
					}
				} 
				// 벽부수기 미사용
				else {
					if(ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[ni][nj][0]) {
						if(map[ni][nj] == 0) {
							queue.add(new Pos(ni, nj, now.cnt + 1, false));
							visit[ni][nj][0] = true;
						}else if(map[ni][nj] == 1) {
							queue.add(new Pos(ni, nj, now.cnt + 1, true));
							visit[ni][nj][1] = true;
						}
					}
				}
			}
		}
	}
	
	public static class Pos {
		int i, j;
		int cnt;
		boolean using;
		
		public Pos(int i, int j, int cnt, boolean using) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.using = using;
		}
	}
}
