package algo230224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2146_다리만들기 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N;
	static int map[][];
	static int MIN = Integer.MAX_VALUE;
	static int islandNum = 1;
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) {
					visit[i][j] = true;
					islandBfs(i, j);
					islandNum++;
				}
			}
		}
		
		islandNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == islandNum) {
					visit = new boolean[N][N];
					visit[i][j] = true;
					bridgeBfs(i, j);
					islandNum++;
				}
			}
		}
		
		System.out.println(MIN);
	}
	
	static void islandBfs(int i, int j) {
		map[i][j] = islandNum;
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(i, j));
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && visit[ni][nj] == false && map[ni][nj] == 1) {
					map[ni][nj] = islandNum;
					visit[ni][nj] = true;
					queue.offer(new Pos(ni, nj));
				}
			}
		}
	}
	
	static void bridgeBfs(int i, int j) {
		Queue<Pos> queue = new LinkedList<b2146_다리만들기.Pos>();
		queue.offer(new Pos(i, j, 0, false));
		
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			if(now.zeroCnt > MIN) continue;
			
			for (int k = 0; k < 4; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && visit[ni][nj] == false) {
					if(map[ni][nj] == islandNum) {
						visit[ni][nj] = true;
						queue.offer(new Pos(ni, nj, 0, false));
					}else if (map[ni][nj] == 0) {
						visit[ni][nj] = true;
						queue.offer(new Pos(ni, nj, now.zeroCnt + 1, true));
					}else {
						if(now.sea == true) {
							if(MIN > now.zeroCnt) {
								MIN = Math.min(MIN, now.zeroCnt);
							}
						} 
						visit[ni][nj] = true;
					}
				}
			}
		}
	}
	
	static class Pos {
		int i, j;
		int zeroCnt;
		boolean sea;
		
		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		public Pos(int i, int j, int zeroCnt, boolean sea) {
			this.i = i;
			this.j = j;
			this.zeroCnt = zeroCnt;
			this.sea = sea;
		}
	}
}
