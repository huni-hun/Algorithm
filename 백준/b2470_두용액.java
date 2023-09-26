package algo230926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2470_두용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		Arrays.sort(arr);
		int left = 0;
		int right = N-1;
		int small = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0, temp = 0;
		while(left < right) {
			int sum = arr[left] + arr[right];
			temp = Math.abs(sum);
			
			if(temp < small) {
				ans1 = left;
				ans2 = right;
				small = temp;
			}
			
			if(sum > 0) left++;
			else right--;
		}
		
		System.out.println(arr[ans1] + " " + arr[ans2]);
	}
}
