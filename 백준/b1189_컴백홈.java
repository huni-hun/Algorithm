package algo230630;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1189_컴백홈 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int R, C, K, result = 0;
	static char map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		K--;
		visit[R-1][0] = true;
		dfs(R-1, 0, 0);
		System.out.println(result);
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt > K) return;
		if(x == 0 && y == C-1) {
			if(cnt == K) result++;
			return;
		}
		
		for (int k = 0; k < 4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];
			
			if(ni >= 0 && nj >= 0 && ni < R && nj < C && !visit[ni][nj] && map[ni][nj] != 'T') {
				visit[ni][nj] = true;
				dfs(ni, nj, cnt+1);
				visit[ni][nj] = false;
			}
		}
	}
}
