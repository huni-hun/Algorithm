package algo230612;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b6593_상범빌딩 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int dk[] = {-1, 1};
	static int L, R, C;
	static int result;
	static char map[][][];
	static boolean visit[][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			String temp = br.readLine();
			if(temp.length() != 0) st = new StringTokenizer(temp);
			else st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;

			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			
			int start_f = 0;
			int start_x = 0;
			int start_y = 0;
			for (int l = 0; l < L; l++) {
				for (int r = 0; r < R; r++) {
					String line = br.readLine();
					if(line.length() == 0) {
						r--;
						continue;
					}
					for (int c = 0; c < C; c++) {
						map[l][r][c] = line.charAt(c);
						if(map[l][r][c] == 'S') {
							start_f = l;
							start_x = r;
							start_y = c;
						}
					}
				}
			}
			
			result = 0;
			bfs(start_f, start_x, start_y);
			if(result == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + result + " minute(s).");
			}
		} // end while 
		
	}
	
	public static void bfs(int start_f, int x, int y) {
		Queue<Move> queue = new LinkedList<Move>();
		queue.add(new Move(start_f, x, y, 0));
		
		visit[start_f][x][y] = true;
		flag : while(!queue.isEmpty()) {
			Move now = queue.poll();
			
			for (int f = 0; f < 2; f++) {
				int nf = now.floor + dk[f];
				
				if(nf >= 0 && nf < L) {
					if(map[nf][now.x][now.y] == 'E') {
						result = now.cnt + 1;
						break flag;
					}
					if(map[nf][now.x][now.y] == '.' && !visit[nf][now.x][now.y]) {
						visit[nf][now.x][now.y] = true;
						queue.add(new Move(nf, now.x, now.y, now.cnt+1));
					}
				}
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && ni < R && nj >= 0 && nj < C) {
					if(map[now.floor][ni][nj] == 'E') {
						result = now.cnt + 1;
						break flag;
					}
					if(map[now.floor][ni][nj] == '.' && !visit[now.floor][ni][nj]) {
						visit[now.floor][ni][nj] = true;
						queue.add(new Move(now.floor, ni, nj, now.cnt+1));
					}
				}
			}
		}
	}
	
	public static class Move {
		int floor;
		int x;
		int y;
		int cnt;
		
		public Move(int floor, int x, int y, int cnt) {
			this.floor = floor;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
