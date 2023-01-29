package algo230129;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b20125_쿠키의신체측정 {
	static char map[][];
	static int waist_x = 0, waist_y = 0;
	static int left_arm = 0, right_arm = 0, waist = 0, left_leg = 0, right_leg = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String Line = br.readLine();
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Line.charAt(j);
			}
		}
		
		
		Loop1 : for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '*') {
					calc(i, j);
					break Loop1;
				}
			}
		}
		
	} // end main
	
	static void calc(int x, int y) {
		int heart_x = x + 1;
		int heart_y = y;
		
		System.out.println( (heart_x + 1) + " " + (heart_y + 1)); // 심장
		
		calc_left_arm(heart_x, heart_y);
		calc_right_arm(heart_x, heart_y);
		calc_waist(heart_x, heart_y);
		calc_left_leg(waist_x, waist_y - 1);
		calc_right_leg(waist_x, waist_y + 1);
		
	}
	
	static void calc_left_arm(int x, int y) {
		while(true) {
			if(y-1 < 0) break;
			if(map[x][y-1] == '*') {
				left_arm++;
				y = y - 1;
			}else {
				break;
			}
		}
		
		System.out.print(left_arm + " ");
	}
	
	static void calc_right_arm(int x, int y) {
		while(true) {
			if(y+1 >= map.length) break;
			if(map[x][y+1] == '*') {
				right_arm++;
				y = y + 1;
			}else {
				break;
			}
		}
		
		System.out.print(right_arm + " ");
	}
	
	static void calc_waist(int x, int y) {
		while(true) {
			if(x+1 >= map.length) break;
			if(map[x+1][y] == '*') {
				waist++;
				x = x + 1;
			}else {
				break;
			}
		}
		
		waist_x = x;
		waist_y = y;
		System.out.print(waist + " ");
	}
	
	static void calc_left_leg(int x, int y) {
		while(true) {
			if(x+1 >= map.length) break;
			if(map[x+1][y] == '*') {
				left_leg++;
				x = x + 1;
			}else {
				break;
			}
		}
		
		System.out.print(left_leg + " ");
	}
	
	static void calc_right_leg(int x, int y) {
		while(true) {
			if(x+1 >= map.length) break;
			if(map[x+1][y] == '*') {
				right_leg++;
				x = x + 1;
			}else {
				break;
			}
		}
		
		System.out.print(right_leg + " ");
	}
	
}
