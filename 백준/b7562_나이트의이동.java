package algo230809;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b7562_나이트의이동 {
	static int result;
	static int di[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int dj[] = {1, 2, 2, 1, -1, -2, -2, -1};
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visit = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken()); 
			int start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int target_x = Integer.parseInt(st.nextToken()); 
			int target_y = Integer.parseInt(st.nextToken());
			
			bfs(start_x, start_y, target_x, target_y, N);
			System.out.println(result);
		}
	}
	
	public static void bfs(int sx, int sy, int tx, int ty, int N) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(sx, sy, 0));
		
		visit[sx][sy] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();

			if(now.x == tx && now.y == ty) result = now.cnt;
			for (int k = 0; k < 8; k++) {
				int nx = now.x + di[k];
				int ny = now.y + dj[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {
					visit[nx][ny] = true;
					queue.add(new Pos(nx, ny, now.cnt + 1));
				}
			}
		}
	}
	
	public static class Pos {
		int x, y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
