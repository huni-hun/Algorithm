package algo230725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14503_로봇청소기 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M;
	static int r, c, dir;
	static int result;
	static int map[][];
//	static int clone[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
//		clone = new int[N][M];
		visit = new boolean[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				clone[i][j] = map[i][j];
//			}
//		}
		clean();
		System.out.println(result);
	}
	
	public static void clean () {
		while(true) {
			
			if(!visit[r][c]) {
				visit[r][c] = true;
//				clone[r][c] = 9;
				result++;
				continue;
			}
//			System.out.println("r : " + r + " / c : " + c);
//			show();
//			System.out.println("//////////");
			
			boolean flag = false;
			for (int k = 0; k < 4; k++) {
				int ni = r + di[k];
				int nj = c + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 0 && !visit[ni][nj]) {
					move();
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				switch (dir) {
				case 0:
					if(r+1 < N && map[r+1][c] == 0) {
						r = r+1;
						break;
					} else {
						return;
					}
					
				case 1:
					if(c-1 >= 0 && map[r][c-1] == 0) {
						c = c-1;
						break;
					} else {
						return;
					}

				case 2:
					if(r-1 >= 0 && map[r-1][c] == 0) {
						r = r-1;
						break;
					} else {
						return;
					}
					
				case 3:
					if(c+1 < M && map[r][c+1] == 0) {
						c = c+1;
						break;
					} else {
						return;
					}
				}	
			}
		}
	}
	
//	public static void show() {
//		for(int i = 0; i < N; i++) {
//			
//			for(int j = 0; j < M; j++) {
//				System.out.print(clone[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
	
	public static void move() {
		while(true) {
			switch (dir) {
			case 0:
				dir = 3;
				if(c-1 >= 0 && map[r][c-1] == 0 && !visit[r][c-1]) {
					c = c-1;
					return;
				} 
				break;

			case 1:
				dir = 0;
				if(r-1 >= 0 && map[r-1][c] == 0 && !visit[r-1][c]) {
					r = r-1;
					return;
				}
				break;

			case 2:
				dir = 1;
				if(c+1 >= 0 && map[r][c+1] == 0 && !visit[r][c+1]) {
					c = c+1;
					return;
				}
				break;
				
			case 3:
				dir = 2;
				if(r+1 >= 0 && map[r+1][c] == 0 && !visit[r+1][c]) {
					r = r+1;
					return;
				}
				break;
			}	
		}
	}
}
