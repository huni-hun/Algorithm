package algo230629;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14620_꽃길 {
	static int di[] = {-1, 0, 1, 0}; 
	static int dj[] = {0, 1, 0, -1}; 
	static int N, result;
	static int map[][];
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = Integer.MAX_VALUE;
		
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0, 0);
		System.out.println(result);
	}
	
	public static void search(int cnt, int sum) {
		
		if(cnt == 3) {
			result = Math.min(result, sum);
			return;
		}
		
		for (int i = 1; i < N-1; i++) {
			for (int j = 1; j < N-1; j++) {

				if(visit[i][j] || check(i, j)) continue;
				
				visit[i][j] = true;
				sum += map[i][j];
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					
					sum += map[ni][nj];
					visit[ni][nj] = true;
				}

				search(cnt+1, sum);
				sum -= map[i][j];
				for (int k = 0; k < 4; k++) {
					int ni = i + di[k];
					int nj = j + dj[k];
					
					sum -= map[ni][nj];
					visit[ni][nj] = false;
				}
				visit[i][j] = false;
			}
		}
		
	}
	
	public static boolean check(int i, int j) {
		boolean flag = false;
		
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(visit[ni][nj]) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
}
