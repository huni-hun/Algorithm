package algo230811;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2579_계단오르기 {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			
		int arr[] = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		int dp[] = new int[N+1];
//		dp[0] = 0;
//		dp[1] = arr[1];
//		if (N >= 2) dp[2] = arr[1] + arr[2];
//		for (int i = 3; i <= N; i++) {
//			dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
//			System.out.println(dp[i]);
//		}
		
		Integer[] dp = new Integer[N+1];
		dp[0] = 0;
		dp[1] = arr[1];
		if (N >= 2) dp[2] = arr[1] + arr[2];
		findDP(N, arr, dp);
		System.out.println(dp[N]);
	}
	
	public static int findDP(int N, int[] arr, Integer[] dp) {
		if(dp[N] == null) {
			dp[N] = Math.max(findDP(N-2, arr, dp), findDP(N-3, arr, dp) + arr[N-1]) + arr[N];
		}
		
		return dp[N];
	}
}
