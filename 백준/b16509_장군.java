package algo0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16509_장군 {
	static int map[][];
	static int di[] = { -3, -3, -2, 2, 3, 3, 2, -2};
	static int dj[] = { -2, 2, 3, 3, 2, -2, -3, -3};
	static int king[];
	static int result = Integer.MAX_VALUE;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][9];
		visit = new boolean[10][9];
		king = new int[2];
		int sang[] = new int[2];

		st = new StringTokenizer(br.readLine());
		sang[0] = Integer.parseInt(st.nextToken());
		sang[1] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		king[0] = Integer.parseInt(st.nextToken());
		king[1] = Integer.parseInt(st.nextToken());
		map[king[0]][king[1]] = 9;

		bfs(sang[0], sang[1], 0);
		System.out.println(result);
	}

	public static void bfs(int i, int j, int cnt) {
		Queue<Pos> queue = new LinkedList<Pos>();
		Pos pos = new Pos(i, j, cnt);

		queue.offer(pos);
		while (!queue.isEmpty()) {
			Pos now = queue.poll();
			if (result < now.cnt)
				continue;

//			System.out.println("nowi, nowj : " + now.i +" "+ now.j);
			for (int k = 0; k < 8; k++) {
				int ni = now.i + di[k];
				int nj = now.j + dj[k];
				
//				System.out.println("before ni, nj : " + ni +" "+ nj);
				if (ni >= 0 && nj >= 0 && ni < 10 && nj < 9) {
					if(k == 0) {
						if(map[now.i-1][now.j] == 9 || map[now.i-2][now.j-1] == 9)
							continue;
					}else if(k == 1) {
						if(map[now.i-1][now.j] == 9 || map[now.i-2][now.j+1] == 9)
							continue;
					}else if(k == 2) {
						if(map[now.i][now.j+1] == 9 || map[now.i-1][now.j+2] == 9)
							continue;
					}else if(k == 3) {
						if(map[now.i][now.j+1] == 9 || map[now.i+1][now.j+2] == 9)
							continue;
					}else if(k == 4) {
						if(map[now.i+1][now.j] == 9 || map[now.i+2][now.j+1] == 9)
							continue;
					}else if(k == 5) {
						if(map[now.i+1][now.j] == 9 || map[now.i+2][now.j-1] == 9)
							continue;
					}else if(k == 6) {
						if(map[now.i][now.j-1] == 9 || map[now.i+1][now.j-2] == 9)
							continue;
					}else if(k == 7) {
						if(map[now.i][now.j-1] == 9 || map[now.i-1][now.j-2] == 9)
							continue;
					}
					
					if(map[ni][nj] == 9) {
						result = now.cnt+1;
						continue;
					}
					if(visit[ni][nj] == true) continue;
//					System.out.println("ni, nj : " + ni +" "+ nj);
					visit[ni][nj] = true;
					queue.add(new Pos(ni, nj, now.cnt+1));
				}
			}
		}
	}

	public static class Pos {
		int i;
		int j;
		int cnt;

		public Pos(int i, int j, int cnt) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
}
