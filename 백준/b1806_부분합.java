package algo231116;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1806_부분합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int preFix[] = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			preFix[i] += Integer.parseInt(st.nextToken()) + preFix[i-1];
		}
		
		int s = 0;
		int e = 0;
		int result = N+1;
		while(s <= N || e <= N) {
			if(e <= N) {
				if(preFix[e] - preFix[s] < S) {
					e++;
				} else {
					result = Math.min(result, e-s);
					s++;
				}
			} else {
				if(preFix[e-1] - preFix[s] >= S) {
					result = Math.min(result, e-s);
				}
				s++;
			}
		}
		
		System.out.println(result == N+1 ? 0 : result);
	}
}
