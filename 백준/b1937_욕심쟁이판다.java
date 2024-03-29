package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1937_욕심쟁이판다 {
	static int di[] = {-1, 0, 1, 0}; 
	static int dj[] = {0, 1, 0, -1};
	static int N;
	static int map[][];
	static int record[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		record = new int[N][N];
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j);
				
				result = Math.max(result, record[i][j]);
			}
		}
		
		System.out.println(result);
	}
	
	public static int dfs(int x, int y) {
		if(record[x][y] != 0) return record[x][y];
		
		record[x][y] = 1;
		
		for (int k = 0; k < 4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];
				
			if(ni >= 0 && nj >= 0 && ni < N && nj < N && map[ni][nj] > map[x][y]) {
				record[x][y] = Math.max(dfs(ni, nj) + 1, record[x][y]);
				dfs(ni, nj);
			}
		}
		
		return record[x][y];
	}
	
}
