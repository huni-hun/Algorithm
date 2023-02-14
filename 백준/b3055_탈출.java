package algo230214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3055_탈출 {
	static Queue<Pos> queue = new LinkedList<b3055_탈출.Pos>();
	static Queue<Pos> waterQueue = new LinkedList<b3055_탈출.Pos>();
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static char map[][];
	static boolean visit[][];
	static int R,C;
	static int result = Integer.MAX_VALUE;
	static int end_x;
	static int end_y;
	static int checkTime = 0;
	static boolean arrive = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		int start_x = 0;
		int start_y = 0;
		end_x = 0;
		end_y = 0;
		for (int i = 0; i < R; i++) {
			String Line = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = Line.charAt(j);
				if(map[i][j] == 'S') {
					start_x = i;
					start_y = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'D') {
					end_x = i;
					end_y = j;
				}
			}
		}
		
		start(start_x, start_y);
		if(arrive) {
			System.out.println(result);
		}else {
			System.out.println("KAKTUS");
		}
		
	}
	
	static void start(int x, int y) {
		visit[x][y] = true;
		queue.offer(new Pos(x, y, 0));
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == '*') {
					waterQueue.offer(new Pos(i, j, 0));
				}
			}
		}
		while(!queue.isEmpty()) {
			water();
//			watch();
			move();
			checkTime++;
		}
	}
//	static void watch() {
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//	}
	
	static void move() {
		while(!queue.isEmpty()) {
			Pos pos = queue.peek();

			if(pos.time > checkTime) break;
			pos = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int ni = pos.x + di[k]; 
				int nj = pos.y + dj[k];
				

				if(ni >= 0 && ni < R && nj >= 0 && nj < C) {
					if(map[ni][nj] == 'D') {
						result = Math.min(result, pos.time+1);
						arrive = true;
						continue;
					}
					if(map[ni][nj] == '.' && visit[ni][nj] == false){
						queue.offer(new Pos(ni, nj, pos.time+1));
						visit[ni][nj] = true;
					}
				}
			}
		}
	}
	
	static void water() {
		while (!waterQueue.isEmpty()) {
			Pos pos = waterQueue.peek();
			if(pos.time > checkTime) break;
			
			pos = waterQueue.poll();
			for (int k = 0; k < 4; k++) {
				int ni = pos.x + di[k]; 
				int nj = pos.y + dj[k];
				
				if(ni >= 0 && ni < R && nj >= 0 && nj < C && map[ni][nj] == '.') {
					map[ni][nj] = '*';
					waterQueue.offer(new Pos(ni, nj, pos.time+1));
				}
			}
		}
	}
	
	static class Pos {
		int x, y;
		int time;
		
		public Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	
}
