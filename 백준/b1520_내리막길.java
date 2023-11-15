package algo231115;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1520_내리막길 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, -1, 0, 1};
	static int N, M;
	static int map[][];
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	public static int dfs(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		
		if(dp[x][y] != -1) return dp[x][y];
		
		dp[x][y] = 0;
		for (int k = 0; k < 4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];
			
			if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[x][y] > map[ni][nj]) {
				dp[x][y] += dfs(ni,	nj);
			}
		}
		
		return dp[x][y];
	}
}
