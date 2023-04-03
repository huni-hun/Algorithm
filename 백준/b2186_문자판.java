package algo230403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2186_문자판 {
	static int dp[][][];
	static char map[][];
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M, K;
	static String goal;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String Line = br.readLine();
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Line.charAt(j); 
			}
		}
		
		goal = br.readLine(); 
		dp = new int[N][M][goal.length()];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == goal.charAt(0)) {
					dfs(i, j, 0);
					result += dp[i][j][0];
				}
			}
		}
		
		System.out.println(result);
		
	} // end main
	
	static int dfs(int i, int j, int step) {
		if(dp[i][j][step] != -1) return 0;
		if(step == goal.length() - 1) {
			return 1;
		}
		
		dp[i][j][step] = 0;
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k <= K; k++) {
				int ni = i + (di[d] * k);
				int nj = j + (dj[d] * k);
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == goal.charAt(step+1)) {
					dp[i][j][step] += dfs(ni, nj, step + 1);
				}
			}
		}
		
		return dp[i][j][step];
	}
	
}
