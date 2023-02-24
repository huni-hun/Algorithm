package algo230224;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667_단지번호 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int map[][];
	static int N;
	static int house;
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && visit[i][j] == false) {
					cnt++;
					house = 1;
					dfs(i, j);
					list.add(house);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(cnt);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	static void dfs(int i, int j) {
		visit[i][j] = true;
		
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			
			if(ni >= 0 && nj >= 0 && ni < N && nj < N) {
				if(map[ni][nj] == 1 && visit[ni][nj] == false) {
					house++;
					dfs(ni, nj);
				}
			}
		}
	}
	
}
