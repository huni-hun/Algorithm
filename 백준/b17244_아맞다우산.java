package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17244_아맞다우산 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M;
	static int startX, startY, endX, endY;
	static char map[][];
	static HashMap<String, Integer> itemMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		itemMap = new HashMap<String, Integer>();
		
		int idx = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'S') {
					startX = i;
					startY = j;
				} else if(map[i][j] == 'E') {
					endX = i;
					endY = j;
				} else if(map[i][j] == 'X') {
					itemMap.put(i + "," + j, idx++);
				}
			}
		}
		
		System.out.println(idx);
		System.out.println(bfs(idx));
	}
	
	public static int bfs(int idx) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(startX, startY, 0, 0));
		
		boolean visit[][][] = new boolean[N][M][1 << idx];
		visit[startX][startY][0] = true;
		
		int result = 0;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if(now.x == endX && now.y == endY && now.item == (1 << idx) - 1) {
				result = now.time;
				break;
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				int itemState = now.item;
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != '#') {
					if(map[ni][nj] == 'X') {
						int itemIdx = itemMap.get(ni + "," + nj);
						itemState |= (1 << itemIdx);
					}
					
					if(visit[ni][nj][itemState]) continue;
					
					visit[ni][nj][itemState] = true;
					queue.add(new Pos(ni, nj, now.time + 1, itemState));
				}
			}
			
		}
		
		return result;
	}
	
	public static class Pos {
		int x, y, time, item;
		
		public Pos(int x, int y, int time, int item) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.item = item;
		}
	}
}
