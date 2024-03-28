package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2638_치즈 {
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	static int N, M;
	static int map[][];
	static boolean meltdown[][];
	static boolean outside[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		outside = new boolean[N][M];
		meltdown = new boolean[N][M];
		
		int cheeze = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) cheeze++;
			}
		}
		
		int result = 0;
		while(true) {
			innerCheck();
			
			for (int i = 0; i < N; i++) {
				
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						int cnt = 0;
						
						for (int k = 0; k < 4; k++) {
							int ni = i + di[k];
							int nj = j + dj[k];
							
							if(ni >= 0 && nj >= 0 && ni < N && nj < M) {
								if(outside[ni][nj]) {
									cnt++;
								}
							}
						}
						
						if(cnt >= 2) {
							meltdown[i][j] = true;
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(meltdown[i][j] && map[i][j] == 1) {
						map[i][j] = 0;
						cheeze--;
					}
				}
			}
			
			result++;
			if(cheeze == 0) break;
		}
		
		System.out.println(result);
	}
	
	public static void innerCheck() {
		outside = new boolean[N][M];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0});
		
		outside[0][0] = true;
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int k = 0; k < 4; k++) {
				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 0 && !outside[ni][nj]) {
					 outside[ni][nj] = true;
					 queue.add(new int[] {ni, nj});
				}
			}
		}
	}
}
