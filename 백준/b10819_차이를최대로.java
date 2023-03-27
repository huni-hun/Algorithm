package algo230327;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10819_차이를최대로 {
	static int arr[];
	static int temp[];
	static boolean use[];
	static int N;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		temp = new int[N];
		use = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		System.out.println(result);
	}
	
	static void permutation(int n) {
		if(n == N) {
			
			int sum = 0;
			for (int i = 0; i < N-1; i++) {
				sum += Math.abs(temp[i] - temp[i+1]);
			}
			
			result = Math.max(result, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(use[i]) continue;
			
			use[i] = true;
			temp[n] = arr[i];
			permutation(n+1);
			use[i] = false;
		}
	}
	
}
