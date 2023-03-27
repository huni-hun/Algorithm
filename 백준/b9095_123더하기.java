package algo230327;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b9095_123더하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int dp[] = new int[11];
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			System.out.println(dp[n]);
				
			// 완전 탐색
//			int result = 0;
//			result = solve(n, 0);
//			System.out.println(result);
		}
	}

	// 완전 탐색
//	static int solve(int n, int sum) {
//		
//		if(n < sum) return 0;
//		
//		if(n == sum) return 1;
//		
//		int temp = 0;
//		for (int i = 1; i <= 3; i++) {
//			temp += solve(n, sum + i);
//		}
//		return temp;
//	}
	
}
