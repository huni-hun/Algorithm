package algo230308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10816_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int card[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(card);
		
		int M = Integer.parseInt(br.readLine());
		int answer[] = new int[M];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
			
			int start = 0;
			int end = N;
			int mid = 0;
			while(start < end) {
				mid = (start + end) / 2;
				
				if(card[mid] >= answer[i]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			
			int lower = start;
			
			start = 0;
			end = N;
			mid = 0;
			while(start < end) {
				mid = (start + end) / 2;
				
				if(card[mid] > answer[i]) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			
			int upper = start;
			
			int result = upper - lower;
			sb.append(result + " ");
		}
		
		System.out.println(sb.toString());
	}
}
