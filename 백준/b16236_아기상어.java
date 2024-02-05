package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16236_아기상어 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, -1, 0, 1};
	static int N, result;
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		result = 0;
		
		int start_x = 0;
		int start_y = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					start_x = i;
					start_y = j;
				}
			}
		}
		
		bfs(start_x, start_y);
		System.out.println(result);
	}
	
	public static void bfs(int x, int y) {
		Queue<Shark> queue = new PriorityQueue<>();
		queue.add(new Shark(x, y, 2, 0, 0));
		
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Shark now = queue.poll();
			
			if(map[now.x][now.y] != 0 && map[now.x][now.y] < now.size) {
				int nextSize = now.size;
				int nextFidding = now.fidding + 1;
				if(now.fidding + 1 == now.size) {
					nextSize++;
					nextFidding = 0;
				}
				
				while(!queue.isEmpty()) queue.poll();
				visit = new boolean[N][N];
				visit[now.x][now.y] = true;
				map[now.x][now.y] = 0;
				now = new Shark(now.x, now.y, nextSize, nextFidding, now.move);
				result = now.move;
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj>= 0 && ni < N && nj < N &&
						!visit[ni][nj] && map[ni][nj] <= now.size) {
					visit[ni][nj] = true;
					
					queue.add(new Shark(ni, nj, now.size, now.fidding, now.move + 1));
				}
			}
		}
	}
	
	public static void showMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static class Shark implements Comparable<Shark> {
		int x, y;
		int size;
		int fidding;
		int move;
		
		public Shark(int x, int y, int size, int fidding, int move) {
			this.x = x;
			this.y = y;
			this.fidding = fidding;
			this.size = size;
			this.move = move;
		}
		
		@Override
		public int compareTo(Shark o) {
			if(o.move == this.move) {
				if(o.x == this.x) {
					return this.y - o.y;
				} else {
					return this.x - o.x;
				}
			} else {
				return this.move - o.move;
			}
		}
	}
	
}
