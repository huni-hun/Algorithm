package algo230313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1780_종이의개수 {
	static int map[][];
	static int white, black, gray;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		black = 0;
		white = 0;
		gray = 0;
		
		division(0, 0, N);
		
		System.out.println(black);
		System.out.println(gray);
		System.out.println(white);
	}
	
	static void division(int row, int col, int size) {
		
		if(check(row, col, size)) {
			if(map[row][col] == 1) {
				white++;
			} else if(map[row][col] == -1) {
				black++;
			} else {
				gray++;
			}
			
			return;
		}
		
		int newSize = size / 3;
		division(row, col, newSize); // 왼쪽 위
		division(row, col + newSize, newSize); // 가운데 위
		division(row, col + newSize * 2, newSize); // 오른쪽 위
		
		division(row + newSize, col, newSize); // 가운데 왼쪽 
		division(row + newSize, col + newSize, newSize); // 정가운데 
		division(row + newSize, col + newSize * 2, newSize); // 가운데 오른쪽
		
		division(row + newSize * 2, col, newSize); // 왼쪽 아래 
		division(row + newSize * 2, col + newSize, newSize); // 가운데 아래 
		division(row + newSize * 2, col + newSize * 2, newSize); // 오른쪽 아래
	}
	
	static boolean check(int row, int col, int size) {
		int color = map[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if(map[i][j] != color) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
