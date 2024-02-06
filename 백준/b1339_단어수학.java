package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1339_단어수학 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < line.length(); j++) {
				char c = line.charAt(j);
				
				arr[c-'A'] += (int) Math.pow(10, line.length() - j - 1);
			}
		}
		

		Arrays.sort(arr);
		int result = 0;
		int idx = 25;
		for (int i = 9; i >= 1; i--) {
			result += arr[idx--] * i;
		}
		
		System.out.println(result);
	}
}
