package algo230321;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2447_별찍기10 {
	static char[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		star(N, 0, 0, false);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void star(int n, int x, int y, boolean check) {
		
		if(n == 3) {
			int cnt = 0;
			
			if(check) {
				for (int i = x; i < x+n; i++) {
					for (int j = y; j < y+n; j++) {
						map[i][j] = ' ';
					}
				}
			}else {
				for (int i = x; i < x+n; i++) {
					for (int j = y; j < y+n; j++) {
						cnt++;
						if(cnt == 5) {
							map[i][j] = ' ';
							continue;
						}
						map[i][j] = '*';
					}
				}
			}

			
			return;
		}
		
		int newSize = n / 3;
		if(!check) {
			star(newSize, x, y, false);
			star(newSize, x, y + newSize, false);
			star(newSize, x, y + newSize * 2, false);
			// 위
			
			star(newSize, x + newSize, y, false);
			star(newSize, x + newSize, y + newSize, true);
			star(newSize, x + newSize, y + newSize * 2, false);
			// 중앙
			
			star(newSize, x + newSize * 2, y, false);
			star(newSize, x + newSize * 2, y + newSize, false);
			star(newSize, x + newSize * 2, y + newSize * 2, false);
			// 아래
		}else {
			star(newSize, x, y, true);
			star(newSize, x, y + newSize, true);
			star(newSize, x, y + newSize * 2, true);
			// 위
			
			star(newSize, x + newSize, y, true);
			star(newSize, x + newSize, y + newSize, true);
			star(newSize, x + newSize, y + newSize * 2, true);
			// 중앙
			
			star(newSize, x + newSize * 2, y, true);
			star(newSize, x + newSize * 2, y + newSize, true);
			star(newSize, x + newSize * 2, y + newSize * 2, true);
			// 아래
		}

	}
	
}
