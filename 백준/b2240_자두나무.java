package algo230507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2240_자두나무 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int dp[][] = new int[T+1][W+1];
		for (int i = 1; i <= T; i++) {
			int tree = Integer.parseInt(br.readLine());
			
			for(int j = 0; j <= W; j++) {
				
				if(j == 0) {
					if(tree == 1) {
						dp[i][j] = dp[i-1][j] + 1;
					} else {
						dp[i][j] = dp[i-1][j];
					}
					
					continue;
				}

				if(j % 2 == 0) {
					if(tree == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
					}else {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}
				} else {
					if(tree == 1) {
						dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);
					}else {
						dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
					}
				}
				
			}
			
		}
		int ans = 0;
		for (int j = 0; j <= W; j++) {
			ans = Math.max(ans, dp[T][j]);
		}
		
		System.out.println(ans);
		
		
	}
}
