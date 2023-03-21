package algo230321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10610_30 {
	static Integer[] arr;
//	static boolean[] visit;
//	static int max = Integer.MIN_VALUE;
//	static int check = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		arr = new Integer[N.length()];
		
		boolean check = false;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = N.charAt(i) - '0';
			if(arr[i] == 0) {
				check = true;
			}
			sum += arr[i];
		}
		if(!check || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
		
//		solve("", 0, arr.length);
	}
	
//	public static void solve(String ans, int cnt, int N) {
//		if(cnt == N) {
//			System.out.println(ans);
//			if(Integer.parseInt(ans) % 30 == 0) {
//				max = Math.max(max, Integer.parseInt(ans));
//				check = ans.charAt(0) - '0';
//			}
//			return;
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			if(ans.length() > 0 && (ans.charAt(0) - '0') <= check) return;
//			if(visit[i] == false) {
//				visit[i] = true;
//				solve(ans + arr[i], cnt + 1, N);
//				visit[i] = false;
//			}
//		}
//	}
	
}
