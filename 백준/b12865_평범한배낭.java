package algo231102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12865_평범한배낭 {
	static Integer dp[][];
	static int W[];
	static int V[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		V = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new Integer[N][K+1];
		
		/* 
		bottom up 
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= K; j++) {
				
				if(W[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - W[i]] + V[i]);
				}
			}
		}
		*/
		
		System.out.println(Topdown(N-1, K));
	}
	
	public static int Topdown(int i, int k) {
		if(i < 0) return 0;
		
		if(dp[i][k] == null) {
			if(W[i] > k) {
				dp[i][k] = Topdown(i-1, k);
			} else {
				dp[i][k] = Math.max(Topdown(i-1, k), Topdown(i - 1, k - W[i]) + V[i]);
			}
		}
		
		return dp[i][k];
	}
}
