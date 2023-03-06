package algo230306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1654_랜선자르기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int line[] = new int[K];
		int min = 0;
		int max = 0;
		for (int i = 0; i < K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(line[i], max);
		}
		
		int mid = 0;
		while(max > min) {
			mid = (max + min) / 2;
			int sum = 0;
			
			for (int i = 0; i < K; i++) {
				sum += (line[i] / mid);
			}
			
			if(sum < N) {
				max = mid;
			} else {
				min = mid + 1;
			}
		} // end while
		
		System.out.println(max);
		System.out.println(mid);
		System.out.println(min);
	}
}
