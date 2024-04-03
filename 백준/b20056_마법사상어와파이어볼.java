package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b20056_마법사상어와파이어볼 {
	static int di[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dj[] = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static Fireball map[][];
	static boolean visit[][];
	static Queue<Fireball> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			queue.add(new Fireball(r, c, m, s, d, 1));
		}
		
		map = new Fireball[N][N];
		while(K-- > 0) {
			visit = new boolean[N][N];
			move();
		}
		
		int result = 0;
		while(!queue.isEmpty()) {
			Fireball now = queue.poll();
			result += now.m;
		}
		
		System.out.println(result);
	}
	
	public static void move() {
		while(!queue.isEmpty()) {
			Fireball now = queue.poll();
			
			int xi = (di[now.d] * now.s) % N;
			int xj = (dj[now.d] * now.s) % N;
			
			int ni = 0;
			int nj = 0;
			if(now.r + xi < 0) {
				ni = N + (now.r + xi);
			} else if(now.r + xi >= N) {
				ni += Math.abs(N- (xi + now.r));
			} else {
				ni = now.r + xi;
			}

			if(now.c + xj < 0) {
				nj = N + (now.c + xj);
			} else if(now.c + xj >= N) {
				nj += Math.abs(N - (xj + now.c));
			} else {
				nj = now.c + xj;
			}
			
			if(map[ni][nj] == null) {
				map[ni][nj] = new Fireball(ni, nj, now.m, now.s, now.d, now.cnt);
			} else {
				visit[ni][nj] = true;
				Fireball temp = map[ni][nj];
				
				boolean oddFlag = false;
				boolean evenFlag = false;
				if(temp.cnt >= 2) {
					if(temp.odd) {
						if(now.d % 2 == 1) oddFlag = true; 
					} else if(temp.even) {
						if(now.d % 2 == 0) evenFlag = true;
					}
					
					map[ni][nj] = new Fireball(nj, nj, now.m + temp.m, now.s + temp.s, now.d, now.cnt + temp.cnt, oddFlag, evenFlag);
					continue;
				}				
				
				if(now.d % 2 == 0 && temp.d % 2 == 0) evenFlag = true;
				else if (now.d % 2 == 1 && temp.d % 2 == 1) oddFlag = true;
				
				map[ni][nj] = new Fireball(nj, nj, now.m + temp.m, now.s + temp.s, now.d, now.cnt + temp.cnt, oddFlag, evenFlag);
			}
		}
		
		divide();
	}
	
	public static void divide() {
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				if(visit[i][j]) {
					int weight = map[i][j].m / 5; 
					if(weight == 0) {
						map[i][j] = null;
						continue;
					}
					int speed = map[i][j].s / map[i][j].cnt;
					
					if(map[i][j].odd || map[i][j].even) {
						for (int k = 0; k < 8; k += 2) {
							queue.add(new Fireball(i, j, weight, speed, k, 1));
						}
					} else {
						for (int k = 1; k < 8; k += 2) {
							queue.add(new Fireball(i, j, weight, speed, k, 1));
						}
					}
					map[i][j] = null;
				} else {
					if(map[i][j] != null) {
						queue.add(map[i][j]);
						map[i][j] = null;
					}
				}
			}
		}
	}
	
	public static class Fireball {
		int r, c;
		int m;
		int s;
		int d;
		int cnt;
		boolean odd, even;
		
		public Fireball(int r, int c, int m, int s, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
		}	

		public Fireball(int r, int c, int m, int s, int d, int cnt, boolean odd, boolean even) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
			this.odd = odd;
			this.even = even;
		}	
	}
}
