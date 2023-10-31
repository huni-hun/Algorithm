package algo231031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2467_용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = N-1;
		int val = Integer.MAX_VALUE;
		int result[] = new int[2];
		while(start < end) {
			int temp = arr[start] + arr[end];
			if(Math.abs(temp) < val) {
				val = temp;
				result[0] = arr[start];
				result[1] = arr[end];
			}
			
			if(temp >= 0) end--;
			else start++;
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
}
