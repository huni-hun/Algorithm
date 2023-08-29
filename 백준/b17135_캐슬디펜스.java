package algo230829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17135_캐슬디펜스 {
	static int result = 0;
	static int kill = 0;
	static int oneCnt = 0;
	static int N, M, D, temp;
	static int di[] = {0, -1, 0};
	static int dj[] = {-1, 0, 1};
	static int map[][]; 
	static int clone[][]; 
	static boolean check[][]; 
	static boolean visit[][];
	static boolean position[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		clone = new int[N][M];
		check = new boolean[N][M];
		visit = new boolean[N][M];
		position = new boolean[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) oneCnt++; 
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				clone[i][j] = map[i][j];
			}
		}
		
		temp = oneCnt;
		playGame(0, 0);
		System.out.println(result);
	}
	
	public static void playGame(int cnt, int idx) {
		if(cnt == 3) {
			kill = 0;
			
			while(oneCnt > 0) {
				for (int i = 0; i < M; i++) {
					if(position[i]) {
						attack(N, i);
						visit = new boolean[N][M];
					}
				}
				
				cleanning();
				move();
			}
			
			result = Math.max(result, kill);
			oneCnt = temp;
			clonning();
			return;
		}
		
		for(int i = idx; i < M; i++) {
			if(position[i]) continue;
			
			position[i] = true;
			playGame(cnt + 1, i + 1);
			position[i] = false;
		}
	}
	
	public static void attack(int r, int c) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(r, c, 0));
		
		start : while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for(int k = 0; k < 3; k++) {
				int nx = now.x + di[k];
				int ny = now.y + dj[k];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && now.distance < D && !visit[nx][ny]) {
					if(map[nx][ny] == 1) {
						check[nx][ny] = true;
						break start;
					}
					visit[nx][ny] = false;
					queue.add(new Pos(nx, ny, now.distance + 1));
				}
			}
		}
	}
	
	public static void clonning() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = clone[i][j];
			}
		}
	}
	
	public static void cleanning() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j]) {
					kill++;
					map[i][j] = 0;
					check[i][j] = false;
					oneCnt--;
				}
			}
		}
	}

	public static void move() {
		for (int j = 0; j < M; j++) {
			if(map[N-1][j] == 1) {
				map[N-1][j] = 0;
				oneCnt--;
			}
		}
		
		for (int i = N-1; i > 0; i--) {
			
			for (int j = 0; j < M; j++) {
				if(map[i-1][j] == 1) {
					map[i][j] = 1;
					map[i-1][j] = 0;
				}
			}
		}
	}
	
	public static class Pos {
		int x, y;
		int distance;
		
		public Pos(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
}
