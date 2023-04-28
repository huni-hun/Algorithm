package algo230428;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1912_연속합 {
	static int arr[];
	static Integer dp[];
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new Integer[N];
		dp[0] = arr[0];
		max = arr[0];
		
//		bottom-up
//		for(int i = 1; i < N; i++) {
//			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
//			
//			max = Math.max(dp[i], arr[i]);
//		}
		recursion(N-1);
		System.out.println(max);
	}
	
	public static int recursion(int cnt) {
		if(dp[cnt] == null) {
			dp[cnt] = Math.max(recursion(cnt-1) + arr[cnt], arr[cnt]);
			
			max = Math.max(dp[cnt], max);
		}
		
		return dp[cnt];
	}
}
