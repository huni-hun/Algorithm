package algo230705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16234_인구이동 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, R, C, sum, result = 0;
	static boolean flag;
	static int map[][];
	static boolean visit[][];
	static List<Pos> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			flag = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						list = new LinkedList<Pos>();
						bfs(i, j);
						list.add(new Pos(i, j));
						if(list.size() > 1) {
							sum += map[i][j];
							movePop();
						}
						sum = 0;
					}
				}
			}
			
			if(!flag) break;
			else result++;
			
			visit = new boolean[N][N];
		}
		
		System.out.println(result);
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(x, y));
		
		visit[x][y] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N && !visit[ni][nj]) {
					int num = Math.abs(map[now.x][now.y] - map[ni][nj]);
					if(num >= R && num <= C) {
						flag = true;
						queue.add(new Pos(ni, nj));
						list.add(new Pos(ni, nj));
						sum += map[ni][nj];
						visit[ni][nj] = true;
					}
				}
			}
		}
	}
	
	public static void movePop() {
		int size = list.size();
		int cnt = sum / size;
		
		for (int i = 0; i < size; i++) {
			Pos now = list.get(i);
			map[now.x][now.y] = cnt;
		}
	}
	
	public static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
