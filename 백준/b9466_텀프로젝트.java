package algo230223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9466_텀프로젝트 {
	static int arr[];
	static int result;
	static boolean visit[];
	static boolean finish[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			visit = new boolean[N+1];
			finish = new boolean[N+1];
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < N+1; i++) {
				dfs(i);
			}
			
			System.out.println(N-result);
		} // end TC
	} // end main
	
	static void dfs(int x) {
		if(finish[x]) return;
		
		if(visit[x]) {
			finish[x] = true;
			result++;
		}
		
		visit[x] = true;
		dfs(arr[x]);
		
		visit[x] = false;
		finish[x] = true;
		
	}
	
}
