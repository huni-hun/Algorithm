package algo231113;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import algo0530.Solution;

public class b2258_정육점 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int meats[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			meats[i][0] = Integer.parseInt(st.nextToken());
			meats[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meats, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(meats[i][0] + " / " + meats[i][1]);
		}
		
		int result = Integer.MAX_VALUE;
		int sum = 0;
		int total = 0;
		boolean isOk = false;
		for (int i = 0; i < N; i++) {
			sum += meats[i][0];
			
			if(i > 0 && meats[i-1][1] == meats[i][1]) {
				total += meats[i][1];
			} else {
				total = meats[i][1];
			}
			
			if(sum >= M) {
				isOk = true;
				result = Math.min(result, total);
			}
		}
		
		System.out.println(isOk ? result : -1);
	}
}
