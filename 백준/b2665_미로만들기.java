package algo231013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b2665_미로만들기 {
	static int result = 0;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		dfs(N);
		System.out.println(result);
	}
	
	public static void dfs(int N) {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(0, 0, 0));
		
		visit[0][0] = true;
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(now.x == N-1 && now.y == N-1) {
				result = now.cnt;
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int nx = now.x + dx[k];
				int ny = now.y + dy[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
					visit[nx][ny] = true;
					if(map[nx][ny] == 1) {
						pq.add(new Pos(nx, ny, now.cnt));
					} else {
						pq.add(new Pos(nx, ny, now.cnt + 1));
					}
				}
			}
		}
	}
	
	public static class Pos implements Comparable<Pos> {
		int x, y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Pos p) {
			return this.cnt - p.cnt;
		}
	}
}
