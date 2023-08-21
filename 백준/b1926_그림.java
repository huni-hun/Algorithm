package algo230821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1926_그림 {
	static int area;
	static int N, M;
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					cnt++;
					area = 1;
					bfs(i, j);
					result = Math.max(result, area);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(result);
	}
	
	public static void bfs(int i, int j) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(i, j));
		
		visit[i][j] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1 && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new Pos(ni, nj));
					area++;
				}
			}
		}
	}
	
	public static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
