package algo230626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b5427_불 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M, result;
	static char map[][];
	static boolean visit[][];
	static Queue<Integer> fireQ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			result = 0;
			map = new char[N][M];
			visit = new boolean[N][M];
			fireQ = new LinkedList<>();
			
			int start_x = 0;
			int start_y = 0;
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '@') {
						start_x = i;
						start_y = j;
					}
					
					if(map[i][j] == '*') {
						fireQ.add(i);
						fireQ.add(j);
					}
				}
			}
			
			escape(start_x, start_y);
			if(result == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(result);
			}
		}
	}
	
	public static void escape(int x, int y) {
		visit[x][y] = true;
		Queue<SK> queue = new LinkedList<SK>();
		
		queue.add(new SK(x, y, 0));
		while(!queue.isEmpty()) {
			
			int size = fireQ.size();
			for(int f = 0; f < size; f += 2) {
				int i = fireQ.poll();
				int j = fireQ.poll();
											
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
							
					if(ni >= 0 && nj >= 0 && ni < N && nj < M 
							&& map[ni][nj] != '*' && map[ni][nj] != '#') {
						map[ni][nj] = '*';
						fireQ.add(ni);
						fireQ.add(nj);
					}
				}
			}
			
			size = queue.size();
			for (int q = 0; q < size; q++) {
				SK now = queue.poll();
				
				if(now.x == 0 || now.x == N-1 || now.y == 0 || now.y == M-1) {
					result = now.cnt + 1;
					break;
				}
				
				for (int k = 0; k < 4; k++) {
					int ni = now.x + di[k];
					int nj = now.y + dj[k];
					
					if(ni >= 0 && ni < N && nj >= 0 && nj < M 
							&& visit[ni][nj] == false && map[ni][nj] == '.') {
						queue.add(new SK(ni, nj, now.cnt + 1));
						visit[ni][nj] = true;
					}
				}
			}
		}
	}
	
	public static class SK {
		int x, y;
		int cnt;
		
		public SK(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
