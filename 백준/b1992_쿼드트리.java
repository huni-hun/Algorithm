package algo230314;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1992_쿼드트리 {
	static int map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String Line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = (Line.charAt(j) - '0');
			}
		}
		
		division(0, 0, N);
		
		System.out.println(sb);
	}
	
	static void division(int x, int y, int size) {
		
		if(check(x, y, size)) {
			sb.append(map[x][y]);
			
			return;
		}
		
		int newSize = size /2;
		if(size <= 0) return;
		sb.append("(");
		division(x, y, newSize); // 왼쪽 위
		division(x, y + newSize, newSize); // 오른쪽 위
		division(x + newSize, y, newSize); // 왼쪽 아래
		division(x + newSize, y + newSize, newSize); // 오른쪽 아래
		sb.append(")");
	}
	
	static boolean check(int x, int y, int size) {
		int color = map[x][y];
		
		for (int i = x; i < x + size; i++) {
			
			for (int j = y; j < y + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
}
