package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15684_사다리조작 {
	static int N, M, H;
	static boolean ladder[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new boolean[H+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			ladder[a][b] = true;
		}
		
		int result = -1;
		for (int i = 0; i < 4; i++) {
			if(dfs(0, i)) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}
	
	public static boolean dfs(int count, int target) {
		if(count == target) {
			return isValid();
		}
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]) {
					ladder[i][j] = true;
					
					if(dfs(count + 1, target)) {
						return true;
					}
					ladder[i][j] = false;
				}
			}
		}
		
		return false;
	}

	public static boolean isValid() {
		for (int start = 1; start <= N; start++) {
			int position = start;
			
			for (int k = 1; k <= H; k++) {
				if(position < N && ladder[k][position]) {
					position++;
				} else if(position > 1 && ladder[k][position - 1]) {
					position--;
				}
			}
			if(position != start) return false;
		}
		
		return true;
	}
	
}
