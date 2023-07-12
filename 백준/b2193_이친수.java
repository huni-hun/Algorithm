package algo230712;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2193_이친수 {
	static long d[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		d = new long[N+1];
		
		d[0] = 0;
		d[1] = 1;
		
//		for (int i = 2; i < N+1; i++) {
//			d[i] = d[i-1] + d[i-2];
//		}
		
		System.out.println(d[N]);
//		System.out.println(dp(N));
	}
	
	public static long dp(int n) {
		
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(d[n] > 0) return d[n];
		
		d[n] = dp(n-2) + dp(n-1);
		return d[n];
	}
}
