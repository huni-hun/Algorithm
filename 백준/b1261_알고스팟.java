package algo231011;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1261_알고스팟 {
	static int result;
	static int N, M;
	static int dx[]	= {-1, 0, 1, 0}; 
	static int dy[]	= {0, 1, 0, -1}; 
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result);
	}
	
	public static void bfs() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(0, 0, 0));
		
		visit[0][0] = true;
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			if(now.x == N-1 && now.y == M-1) {
				result = now.cnt;
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && result > now.cnt && !visit[nx][ny]) {
					if(map[nx][ny] == 0) {
						pq.add(new Pos(nx, ny, now.cnt));
					} else {
						pq.add(new Pos(nx, ny, now.cnt+1));
					}
					visit[nx][ny] = true;
				}
			}
		}
	}
	
	public static class Pos implements Comparable<Pos>{
		int x, y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		public int compareTo(Pos p) {
			return this.cnt - p.cnt;
		}
 	}
}
