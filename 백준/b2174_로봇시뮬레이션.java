package algo0411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2174_로봇시뮬레이션 {
	static int R, C, N, M;
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int map[][];
	static String robot[][];
	static String command[][];
	static boolean result_flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		robot = new String[N][3];
		command = new String[M][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				robot[i][j] = st.nextToken();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				command[i][j] = st.nextToken();
			}
		}
		
		for(int i = 0; i < N; i++) { // 로봇위치에 9 넣기
			int x = (R - Integer.parseInt(robot[i][1]));
			int y = Integer.parseInt(robot[i][0]) - 1;
			
			map[x][y] = 9;
		}
		
		for (int i = 0; i < M; i++) {
			if (result_flag) // 오류발견하면 브레이크
				break;
			start(command[i][0], command[i][1], command[i][2], robot[Integer.parseInt(command[i][0]) - 1][2]); // 명령 하나씩 실행
		}
		if (result_flag == false) { // 오류없으면
			System.out.println("OK");
		}
		
	}

	public static void start(String num, String rule, String cnt, String dir) {
		int i = (R - Integer.parseInt(robot[Integer.parseInt(num) - 1][1]));  
		int j = Integer.parseInt(robot[Integer.parseInt(num) - 1][0]) - 1;

		int ndir = 0;
		switch (dir) {  // 방향
		case "N":
			ndir = 0;
			break;
		case "E":
			ndir = 1;
			break;
		case "S":
			ndir = 2;
			break;
		case "W":
			ndir = 3;
			break;
		}

		int tempi = i; // 좌표를 바꿔써서 마지막에 필요함
		int tempj = j;
		
		switch (rule) { // 명령에 따른 실행
		case "L":  
			for (int k = 0; k < Integer.parseInt(cnt); k++) {
				ndir -= 1;
				if (ndir == -1) {
					ndir = 3;
				}
			}
			break;
		case "R":
			for (int k = 0; k < Integer.parseInt(cnt); k++) {
				ndir += 1;
				if (ndir == 4) {
					ndir = 0;
				}
			}
			break;
		case "F":
			for (int k = 0; k < Integer.parseInt(cnt); k++) {
				int ni = i + di[ndir];
				int nj = j + dj[ndir];
				
				if (ni >= 0 && nj >= 0 && ni < R && nj < C && map[ni][nj] != 9) {
					i = ni;
					j = nj;
				} else if (ni < 0 || nj < 0 || ni >= R || nj >= C) {
					System.out.println("Robot " + num + " crashes into the wall");
					result_flag = true;
					return;
				} else if (map[ni][nj] == 9) {
					int num2 = check(ni, nj); 	// 부딪힌 로봇 몇번인지 체크
					System.out.println("Robot " + num + " crashes into robot " + num2);
					result_flag = true;
					return;
				}
			}
			map[tempi][tempj] = 0;  // 로봇 떠난자리 0
			tempi = i;
			tempj = j;
			break;
		}

		if (ndir == 0) { // 방향 다시 세팅
			dir = "N";
		} else if (ndir == 1) {
			dir = "E";
		} else if (ndir == 2) {
			dir = "S";
		} else {
			dir = "W";
		}
		
		tempi = R-tempi; // 좌표 다시 세팅
		tempj = tempj+1;
		robot[Integer.parseInt(num) - 1][0] = tempj + "";
		robot[Integer.parseInt(num) - 1][1] = tempi + "";
		robot[Integer.parseInt(num) - 1][2] = dir;

	}

	public static int check(int i, int j) {
		for (int k = 0; k < N; k++) {
			if (i == (R-Integer.parseInt(robot[k][1])) && Integer.parseInt(robot[k][0])-1 == j) {
				return k + 1;
			}

		}

		return 0;
	}

}
