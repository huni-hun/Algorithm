package algo230103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2583_영역구하기 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};	
	static int map[][];
	static int M, N, K;
	static int cnt;
	static List<Integer> arrayList;
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visit = new boolean[M][N];
				
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = 1;
				}
			}
			
		}
		
		int area = 0;
		arrayList = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 1 && visit[i][j] == false) {
					area++;
					cnt = 1;
					visit[i][j] = true;
//					dfs(i, j);
					bfs(i, j);
					arrayList.add(cnt);
				}
				
			}
		}

		System.out.println(area);
		Collections.sort(arrayList);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
	}
	
	static void dfs(int x, int y) {
		for(int k = 0; k < 4; k++) {
			int dx = x + di[k];
			int dy = y + dj[k];
			
			if(dx >= 0 && dx < M && dy >= 0 && dy < N && visit[dx][dy] == false && map[dx][dy] == 0) {
				cnt++;
				visit[dx][dy] = true;
				dfs(dx, dy);
			}
		}
	}
	
	static void bfs(int x, int y) {
		Queue<Pos> list = new LinkedList();
		Pos pos = new Pos(x, y);
		
		list.add(pos);
		while(!list.isEmpty()) {
			Pos now = list.poll();
			
			for (int k = 0; k < 4; k++) {
				int dx = now.x + di[k];	
				int dy = now.y + dj[k];
				
				if(dx >= 0 && dx < M && dy >= 0 && dy < N && visit[dx][dy] == false && map[dx][dy] == 0) {
					cnt++;
					visit[dx][dy] = true;
					list.offer(new Pos(dx, dy));
				}
			}
		}
	}
	
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
