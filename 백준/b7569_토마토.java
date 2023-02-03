package algo230203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7569_토마토 {
	static int map[][][];
	static boolean visit[][][];
	static int di[] = {-1, 0, 1, 0, 0, 0};
	static int dj[] = {0, 1, 0, -1, 0, 0};
	static int dk[] = {0, 0, 0, 0, 1, -1};
	static Queue<Tomato> queue;
	static int ans = 0;
	static int N, M, H;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int zero = 0;
		map = new int[M][N][H];
		visit = new boolean[M][N][H]; 
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < N; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if(map[j][k][i] == 0) zero++;
				}
			}
		}
		
		if(zero == 0) {
			System.out.println(0);
			return;
		}
		
		queue = new LinkedList<Tomato>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k][i] == 1) {
						queue.add(new Tomato(j, k, i, 0));
						visit[j][k][i] = true;
					}
				}
			}
		}
		
		bfs();
		zero = 0;		
        for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(map[j][k][i] == 0) {
						zero++;
					}
				}
			}
		}
        
		if(zero == 0) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}
		
	}
	
	static void bfs() {
		
		while(!queue.isEmpty()) {
			Tomato now = queue.poll();
			if(now.day >= ans) ans = now.day;
			
			for (int t = 0; t < 6; t++) {
				int ni = now.x + di[t];
				int nj = now.y + dj[t];
				int nk = now.z + dk[t];
				
				if(ni >= 0 && nj >= 0 && nk >= 0 && ni < M && nj < N && nk < H && map[ni][nj][nk] == 0 &&
						visit[ni][nj][nk] != true) {
					visit[ni][nj][nk] = true;
					map[ni][nj][nk] = 1;
					queue.add(new Tomato(ni, nj, nk, now.day + 1));
				}
			}
		}
	}
	
	static class Tomato {
		int x, y, z, day;
		
		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
}
