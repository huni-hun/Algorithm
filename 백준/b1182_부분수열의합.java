package algo230510;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1182_부분수열의합 {
	static int arr[];
	static int result = 0;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N; i++) {
			combination(i, S, 0, 0);
		}
		if(S == 0) result--;
		System.out.println(result);
	}
	
	public static void combination(int N, int S, int idx, int depth) {
		if(depth == N) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(visit[i]) {
					System.out.print(arr[i] + "/");
					sum += arr[i];
				}
			}
			System.out.println();

			if(sum == S) result++;
			return;
		} else {
			for (int i = idx; i < arr.length; i++) {
				if(visit[i]) continue;
				visit[i] = true;
				combination(N, S, i, depth+1);
				visit[i] = false;
			}
		}
		
	}
}
