package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14500_테트로미노 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M, result;
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visit[i][j] = false;
				
				calcTop(i, j, map[i][j]);
				calcBottom(i, j, map[i][j]);
				calcRight(i, j, map[i][j]);
				calcLeft(i, j, map[i][j]);
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int i, int j, int sum, int cnt) {
		if(cnt == 4) {
			result = Math.max(result, sum);
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(ni >= 0 && nj >= 0 && ni < N && nj < M && !visit[ni][nj]) {
				visit[ni][nj] = true;
				dfs(ni, nj, sum + map[ni][nj], cnt + 1);
				visit[ni][nj] = false;
			}
		}
	}
	
	public static void calcTop(int i, int j, int num) {
		if(i-1 < 0 || j-1 < 0 || j+1 >= M) return;
		
		num += map[i-1][j] + map[i][j-1] + map[i][j+1];
		result = Math.max(result, num);
	}
	
	public static void calcBottom(int i, int j, int num) {
		if(i+1 >= N || j-1 < 0 || j+1 >= M) return;
		
		num += map[i+1][j] + map[i][j-1] + map[i][j+1];
		result = Math.max(result, num);
	}
	
	public static void calcRight(int i, int j, int num) {
		if(j+1 >= M || i-1 < 0 || i+1 >= N) return;
		
		num += map[i][j+1] + map[i-1][j] + map[i+1][j];
		result = Math.max(result, num);
	}
	
	public static void calcLeft(int i, int j, int num) {
		if(j-1 < 0 || i-1 < 0 || i+1 >= N) return;
		
		num += map[i][j-1] + map[i-1][j] + map[i+1][j];
		result = Math.max(result, num);
	}
}
