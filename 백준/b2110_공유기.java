package algo230309;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2110_공유기 {
	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[N-1] - arr[0] + 1;
		int mid;
		while(start < end) {
			mid = (start + end) / 2;
			
			if(cal(mid) < C) {
				end = mid;
			} else {
				start = mid + 1;
			}
			
		}
		
		System.out.println(start - 1);
	}
	
	static int cal(int mid) {
		
		int count = 1;
		int house = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			int locate = arr[i];
			
			if(locate - house >= mid) {
				count++;
				house = locate;
			}
		}
		return count;
	}
}
