package algo231123;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b3020_개똥벌레 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int down[] = new int[H+2];
		int up[] = new int[H+2];
		for (int i = 0; i < N/2; i++) {
			down[Integer.parseInt(br.readLine())]++;
			up[H-Integer.parseInt(br.readLine())+1]++;
		}
		
		for (int i = 1; i < H+1; i++) {
			down[i] += down[i-1]; 
		}
		
		for (int i = H; i >= 1; i--) {
			up[i] += up[i+1];
		}
		
		int min = N;
		int result = 0;
		for (int i = 1; i <= H; i++) {
			int cnt = (N/2 - down[i-1]) + (N/2 - up[i+1]);

            if(min > cnt) {
				min = cnt;
				result = 1;
				continue;
			}
            
			if(min == cnt) {
				result++;
			}
		}
		System.out.println(min + " " + result);

		/*
		 
		이분탐색
		int down[] = new int[N/2];
		int up[] = new int[N/2];
		for (int i = 0; i < N/2; i++) {
			down[i] = Integer.parseInt(br.readLine());
			up[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(down);
		Arrays.sort(up);
		int min = N;
		int result = 0;
		for (int i = 1; i <= H; i++) {
			int cnt = binarySearch(0, N/2, i, down) + binarySearch(0, N/2, H-i+1, up);
			
			if(min == cnt) {
				result++;
				continue;
			}
			if(min > cnt) {
				min = cnt;
				result = 1;
			} 
		}
		
		System.out.println(min + " " + result);
		
		*/
	}

	public static int binarySearch(int start, int end, int h, int[] arr) {
		
		while(start < end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] >= h) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		
		return arr.length - end;
	}
}
