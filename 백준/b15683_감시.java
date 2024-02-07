package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15683_감시 {
	static int di[] = { -1, 0, 1, 0 };
	static int dj[] = { 0, 1, 0, -1 };
	static int N, M, result;
	static int map[][];
	static int check[][];
	static List<CCTV> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new CCTV(map[i][j], i, j));
					check[i][j] = 81;
				} else if(map[i][j] == 6) check[i][j] = 81;
			}
		}

		result = 81;
		simulation(0);

		System.out.println(result);
	}

	public static void simulation(int idx) {
		if (idx == list.size()) {
			result = Math.min(result, calc());
			return;
		}

		CCTV now = list.get(idx);

		if (now.type == 1) {
			for (int dir = 0; dir < 4; dir++) {
				marking(now.x, now.y, dir);
				simulation(idx + 1);
				cleanning(now.x, now.y, dir);
			}
		} else if (now.type == 2) {
			for (int dir = 0; dir < 2; dir++) {
				marking(now.x, now.y, dir);
				marking(now.x, now.y, dir + 2);
				simulation(idx + 1);
				cleanning(now.x, now.y, dir);
				cleanning(now.x, now.y, dir + 2);
			}
		} else if (now.type == 3) {
			for (int dir = 0; dir < 4; dir++) {
				marking(now.x, now.y, dir);
				if (dir + 1 == 4)
					marking(now.x, now.y, 0);
				else
					marking(now.x, now.y, dir + 1);
				simulation(idx + 1);
				cleanning(now.x, now.y, dir);
				if (dir + 1 == 4)
					cleanning(now.x, now.y, 0);
				else
					cleanning(now.x, now.y, dir + 1);
			}
		} else if (now.type == 4) {
			for (int dir = 0; dir < 4; dir++) {
				if (dir == 0)
					marking(now.x, now.y, 3);
				else
					marking(now.x, now.y, dir - 1);
				marking(now.x, now.y, dir);
				if (dir + 1 == 4)
					marking(now.x, now.y, 0);
				else
					marking(now.x, now.y, dir + 1);
				simulation(idx + 1);
				if (dir == 0)
					cleanning(now.x, now.y, 3);
				else
					cleanning(now.x, now.y, dir - 1);
				cleanning(now.x, now.y, dir);
				if (dir + 1 == 4)
					cleanning(now.x, now.y, 0);
				else
					cleanning(now.x, now.y, dir + 1);
			}
		} else {
			for (int dir = 0; dir < 4; dir++) {
				marking(now.x, now.y, dir);
			}
			simulation(idx + 1);
			for (int dir = 0; dir < 4; dir++) {
				cleanning(now.x, now.y, dir);
			}
		}
	}

	public static void marking(int x, int y, int dir) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += di[dir];
			ny += dj[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6)
				break;
			check[nx][ny]++;
		}
	}

	public static void cleanning(int x, int y, int dir) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += di[dir];
			ny += dj[dir];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6)
				break;
			if(check[nx][ny] > 0) check[nx][ny]--;
		}
	}

	public static int calc() {
		int num = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (check[i][j] == 0)
					num++;
			}
		}

		return num;
	}

	public static class CCTV {
		int type;
		int x, y;

		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
	}
}
