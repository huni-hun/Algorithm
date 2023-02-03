package algo230203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b7795_먹을것인가먹힐것인가 {
	static int A[];
	static int B[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sizeA = Integer.parseInt(st.nextToken()); 
			int sizeB = Integer.parseInt(st.nextToken()); 
			
			A = new int[sizeA];
			B = new int[sizeB];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < A.length; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
				
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < B.length; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int ans = 0;
			for (int i = 0; i < B.length; i++) {
				int start = 0;
				int end = A.length - 1;
				int mid = 0;
				
				while(start <= end) {
					mid = (start + end) / 2;
					
					if(B[i] < A[mid]) {
						end = mid-1;
					} else {
						start = mid + 1;
					}
				}
				ans += (A.length - start);
			}
			
			System.out.println(ans);
		}
		
	}
}
