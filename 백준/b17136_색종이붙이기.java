package algo230502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17136_색종이붙이기 {
	static int map[][] = new int[10][10];
	static int paper[] = {0, 5, 5, 5, 5, 5};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(x >= 9 && y > 9) {
			result = Math.min(result, cnt);
			return;
		}
		
		if(cnt >= result) {
			return;
		}
		
		if(y > 9) {
			dfs(x + 1, 0, cnt); // 아래쪽으로 이동
			return;
		}
		
		if(map[x][y] == 1) {
			for (int i = 5; i >= 1; i--) {
				if(paper[i] > 0 && isVisit(x, y, i)) {
					paper[i]--;
					visit(x, y, i, 0);
					dfs(x, y + 1, cnt + 1);
					visit(x, y, i, 1);
					paper[i]++;
				}
			}
		} else {
			dfs(x, y + 1, cnt); // 오른쪽으로 이동
		}
		
	}
	
	public static void visit(int x, int y, int size, int state) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	public static boolean isVisit(int x, int y, int size) {
		for(int i = x; i < x + size; i++) {
			if(i >= 10) return false;
			for (int j = y; j < y + size; j++) {
				if(j >= 10) return false;
				
				if(map[i][j] != 1) return false;
			}
		}
		
		return true;
	}
}
