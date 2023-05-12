package algo230512;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17144_미세먼지안녕 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int R, C, T;
	static int map[][];
	static int cloneMap[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		int cleaner_x = 0;
		map = new int[R][C];
		cloneMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < C; j++) {
				int k = Integer.parseInt(st.nextToken());
				map[i][j] = k;
				cloneMap[i][j] = k;
				if(k == -1) {
					cleaner_x = i;
				}
			}
		}
		
		while(T-- > 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j] != 0 && map[i][j] != -1)
						spread(i, j);
				}
			}

			upperClear(cleaner_x-1, 0);
			underClear(cleaner_x, 0);
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j] = cloneMap[i][j];
				}
			}
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += map[i][j];
			}
		}
		
		result += 2;
		System.out.println(result);
	}
	
	public static void spread(int i, int j) {
		int dust = map[i][j]/5;
		if(dust < 1) return;
		
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
//			if(ni < 0 || nj < 0 || ni >= R || nj >= C || map[ni][nj] == -1) 
			if(ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] != -1) {
				cloneMap[ni][nj] += dust;
				if(cloneMap[i][j] - dust < 0) cloneMap[i][j] = 0;
				else cloneMap[i][j] -= dust;
			}
		}
	}
	
	public static void upperClear(int i, int j) {
		int temp = cloneMap[i][1];
		cloneMap[i][1] = 0;
		for (int y = 2; y < C; y++) {
			int t = cloneMap[i][y];
			cloneMap[i][y] = temp; 
			temp = t;
		}
		
		for (int x = i-1; x >= 0; x--) {
			int t = cloneMap[x][C-1];
			cloneMap[x][C-1] = temp;
			temp = t;
		}
		
		for (int y = C-2; y >= 0; y--) {
			int t = cloneMap[0][y];
			cloneMap[0][y] = temp;
			temp = t;
		} 
		
		for (int x = 1; x < i; x++) {
			int t = cloneMap[x][0];
			cloneMap[x][0] = temp;
			temp = t;
		}
	}
	
	public static void underClear(int i, int j) {
		int temp = cloneMap[i][1];
		cloneMap[i][1] = 0;
		for (int y = 2; y < C; y++) {
			int t = cloneMap[i][y];
			cloneMap[i][y] = temp; 
			temp = t;
		}
		
		for (int x = i+1; x < R; x++) {
			int t = cloneMap[x][C-1];
			cloneMap[x][C-1] = temp;
			temp = t;
		}
		
		for (int y = C-2; y >= 0; y--) {
			int t = cloneMap[R-1][y];
			cloneMap[R-1][y] = temp;
			temp = t;
		} 
		
		for (int x = R-2; x > i; x--) {
			int t = cloneMap[x][0];
			cloneMap[x][0] = temp;
			temp = t;
		}
	}
}
