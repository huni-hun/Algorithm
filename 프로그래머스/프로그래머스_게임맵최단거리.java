package algo230317;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_게임맵최단거리 {
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};
	static int map[][];
	static boolean visit[][];
    static int N, M, answer;
    
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		solution(maps);
	}
	
	public static int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        map = maps;
        N = map.length;
        M = map[0].length;
        visit = new boolean[N][M];
        
        visit[0][0] = true;
        bfs();
//        dfs(0, 0, 1);
        System.out.println(answer);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
	
	public static void bfs() {
		Queue<Pos> queue = new LinkedList<프로그래머스_게임맵최단거리.Pos>();
		queue.add(new Pos(0, 0, 1));
		
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();

			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1 && visit[ni][nj] == false) {
					visit[ni][nj] = true;
					queue.add(new Pos(ni, nj, now.cnt + 1));
					if(ni == N-1 && nj == M-1) {
						answer = now.cnt+1;
						return;
					}
				}
			}
		}
		
	}
	
	public static class Pos{
		int x;
		int y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void dfs(int x, int y, int cnt) {
		if(cnt > answer) return;
		
		if(x == N-1 && y == M-1) {
			answer = Math.min(answer, cnt);
			return;
		}
			
		for (int k = 0; k < 4; k++) {
			int ni = x + di[k];
			int nj = y + dj[k];
			
			if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] == 1 && visit[ni][nj] == false) {
				visit[ni][nj] = true;
				dfs(ni, nj, cnt + 1);
				visit[ni][nj] = false;
			}
		}
	}
}
