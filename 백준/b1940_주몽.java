package algo230605;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1940_주몽 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		boolean visit[] = new boolean[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			
			for (int j = i+1; j < N; j++) {
				if(visit[j]) continue;
				
				int sum = arr[i] + arr[j];
				if(sum == M) {
					visit[i] = true;
					visit[j] = true;
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
		
	}
}
