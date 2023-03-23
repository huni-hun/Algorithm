package algo230323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class b1744_수묶기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		boolean[] use = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if(use[i]) continue;
			
			if(arr[i] < 0) {
				for (int j = i+1; j < arr.length; j++) {
					if(arr[j] < 0) {
						result += (arr[i] * arr[j]);
						System.out.println("1 : " + result);
						use[i] = true;
						use[j] = true;
						break;
					}else if(arr[j] == 0) {
						use[i] = true;
						use[j] = true;
						break;
					}
				}
				continue;
			}
		}
		
		for (int i = N-1; i >= 0; i--) {
			if(use[i]) continue;
			
			for (int j = i-1; j >= 0; j--) {
				if(use[j]) continue;
				
				if(arr[i] > 0 && arr[j] > 0 && arr[i] >= arr[j]) {
					if(arr[j] == 1) {
						result += arr[i] + arr[j];
						System.out.println("2 : " + result);
						use[i] = true;
						use[j] = true;
						break;
					}else {
						result += (arr[i] * arr[j]);
						System.out.println("3 : " + result);
						use[i] = true;
						use[j] = true;
						break;
					}
				}
			}
			
			if(use[i]) continue;
			result += arr[i];
			System.out.println("4 : " + result + " / arr : " + arr[i]);
			use[i] = true;
		}
		
		System.out.println(result);
	}
}
