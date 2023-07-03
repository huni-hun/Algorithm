package algo230703;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b20300_서강근육맨 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long arr[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		long M = 0;
		if(N % 2 == 0) {
			for (int i = 0; i < N/2; i++) {
				M = Math.max(M, arr[i] + arr[N-i-1]);
			}
		} else {
			M = arr[N-1];
			for (int i = 0; i < (N-1)/2; i++) {
				M = Math.max(M, arr[i] + arr[N-i-2]);
			}
		}
		
		System.out.println(M);
	}
}
