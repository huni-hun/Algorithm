package algo230310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10815_숫자카드 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int card[] = new int[N];
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int target[] = new int[M];
		for (int i = 0; i < target.length; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		for (int i = 0; i < target.length; i++) {
			int start = 0;
			int end = N;
			
			while(start < end) {
				int mid = (start + end) / 2;
				
				if(target[i] < card[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} // end while
			int lower = start;
			
			start = 0;
			end = N;
			
			while(start < end) {
				int mid = (start + end) / 2;
				
				if(target[i] <= card[mid]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			} // end while
			int upper = start;
			
			if(upper - lower == 0) {
				System.out.print(0 + " ");
			} else {
				System.out.print(1 + " ");
			}
		}
		
	}
}
