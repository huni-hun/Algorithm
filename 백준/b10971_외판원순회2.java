package algo230328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b10971_외판원순회2 {
	static int map[][];
	static int result, N;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			dfs(i, i, 0, 0);
			visit[i] = false;
		}
		
		System.out.println(result);
	}
	
	static void dfs(int start, int end, int sum, int cnt) {
		if(cnt == N-1) {
			if(map[end][start] != 0) {
				sum += map[end][start];
				result = Math.min(result, sum);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visit[i] == false && map[end][i] != 0) {
				visit[i] = true;
				dfs(start, i, sum + map[end][i], cnt+1);
				visit[i] = false;
			}
		}
	}
	
}
