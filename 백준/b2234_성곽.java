package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2234_성곽 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M;
	static int rooms[][];
	static Wall map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new Wall[N][M];
		rooms = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				boolean e = false;
				boolean w = false;
				boolean s = false;
				boolean n = false;
				for (int k = 0; k < 4; k++) {
					if(k == 0) {
						if(num % 2 == 1) w = true;
						num /= 2;
					} else if(k == 1) { 
						if(num % 2 == 1) n = true;
						num /= 2;
					} else if(k == 2) {
						if(num % 2 == 1) e = true;
						num /= 2;
					} else {
						if(num % 2 == 1) s = true;
						num /= 2;
					}
				}
			
				map[i][j] = new Wall(i, j, e, w, s, n);
			}
		}
		
		int roomCnt = 0;
		int maxArea = 0;
		int roomIdx = 0;
		List<Integer> areas = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					roomCnt++;
					visit[i][j] = true;
					int area = bfs(i, j, roomIdx);
					roomIdx++;
					areas.add(area);
					maxArea = Math.max(maxArea, area);
				}
			}
		}

		int sumArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					
					if(ni >= 0 && nj >= 0 && ni < N && nj < M) {
						if(rooms[i][j] != rooms[ni][nj]) {
							sumArea = Math.max(sumArea, areas.get(rooms[i][j]) + areas.get(rooms[ni][nj]));
						}
					}
				}
			}
		}
		
		System.out.println(roomCnt);
		System.out.println(maxArea);
		System.out.println(sumArea);
	}
	
	public static int bfs(int i, int j, int idx) {
		Queue<Wall> queue = new LinkedList<Wall>();
		queue.add(map[i][j]);
		
		rooms[i][j] = idx;
		int area = 1;
		while(!queue.isEmpty()) {
			Wall now = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				if(k == 0) {
					if(now.north) continue;
				} else if(k == 1) {
					if(now.east) continue;
				} else if(k == 2) {
					if(now.south) continue;
				} else {
					if(now.west) continue;
				}
				
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[ni][nj]) {
					visit[ni][nj] = true;
					rooms[ni][nj] = idx;
					queue.add(map[ni][nj]);
					area++;
				}
			}
		}
	
		return area;
	}
	
	
	public static class Wall {
		int x, y;
		boolean east, west, south, north;
		
		public Wall(int x, int y, boolean east, boolean west, boolean south, boolean north) {
			this.x = x;
			this.y = y;
			this.east = east;
			this.west = west;
			this.south = south;
			this.north = north;
		}
	}
}
