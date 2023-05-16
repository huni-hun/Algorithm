package algo230516;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b15989_123더하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n == 1) {
				System.out.println(1);
				continue;
			} else if(n==2) {
				System.out.println(2);
				continue;
			}
			
			int dp[][] = new int[n+1][4];
			dp[1][1] = 1;
			dp[2][1] = 1;
			dp[2][2] = 1;
			dp[3][1] = 1;
			dp[3][2] = 1;
			dp[3][3] = 1;
			
			for (int i = 4; i <= n; i++) {
				dp[i][1] = dp[i-1][1]; 
				dp[i][2] = dp[i-2][1] + dp[i-2][2]; 
				dp[i][3] = dp[i-3][1] + dp[i-3][2] +dp[i-3][3]; 
			}
			
			int answer = dp[n][1] + dp[n][2] + dp[n][3];
			System.out.println(answer);
		}
	}
}
