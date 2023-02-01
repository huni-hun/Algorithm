package algo230201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2468_안전영역 {
	static int map[][];
	static boolean visit[][];
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int maxHeight = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		int result = 0;
		for (int height = 1; height < maxHeight; height++) {
			visit = new boolean[N][N];
			int area = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] <= height) {
						visit[i][j] = true;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visit[i][j] == false) {
						area++;
						dfs(i, j);
					}
				}
			}
			
			result = Math.max(result, area);
		}
		
		System.out.println(result);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		
		for (int k = 0; k < 4; k++) {
			int dx = x + di[k];
			int dy = y + dj[k];
			
			if(dx < N && dx >= 0 && dy < N && dy >= 0 && visit[dx][dy] == false) {
				dfs(dx, dy);
			}
		}
	}
}
