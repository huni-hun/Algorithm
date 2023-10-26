package algo231025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1253_좋다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N <= 2) {
			System.out.println(0);
			return;
		}
		
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < N; i++) {
			int min = 0;
			int max = N-1;
			
			while(min < max) {
				if(min == i) min++;
				else if(max == i) max--;
				
				if(min == max) break;
				
				if(arr[i] > arr[min] + arr[max]) {
					min++;
				} else if(arr[i] < arr[min] + arr[max]) {
					max--;
				} else {
					System.out.println(min + " / " + max);
					System.out.println("result : " + arr[i]);
					result++;
					break;
				}
			}
		}
		
		System.out.println(result);
	}
}
