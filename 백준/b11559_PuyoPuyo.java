package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b11559_PuyoPuyo {
	static char[][] map; 
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[12][6];
		
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(startGame());
	}
	
	public static int startGame() {
		
		int chainCnt = 0;
		
		while(true) {
			boolean isRemoved = checkRemovePuyo(); 
			if(!isRemoved) break;
			
			chainCnt++;
			movePuyo();
		}
		
		return chainCnt;
	}

	public static boolean checkRemovePuyo() {
		boolean flag = false;
		boolean[][] visit = new boolean[12][6];
		List<int[]> toRemove = new ArrayList<>();
		
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if(map[i][j] != '.' && !visit[i][j]) {
					List<int[]> connected = new ArrayList<int[]>();
					dfs(i, j, map[i][j], visit, connected);
					
					if(connected.size() >= 4) {
						flag = true;
						toRemove.addAll(connected);
					}
				}
			}
		}
		
		for (int[] pos : toRemove) {
			map[pos[0]][pos[1]] = '.';
		}
		
		return flag;
	}
	
	public static void dfs(int x, int y, char puyo, boolean[][] visit, List<int[]> connected) {
		visit[x][y] = true;
		connected.add(new int[] {x, y});
		
		for (int k = 0; k < 4; k++) {
			int ni = x + dx[k];
			int nj = y + dy[k];
			
			if(ni >= 0 && nj >= 0 && ni < 12 && nj < 6 &&
					map[ni][nj] == puyo && !visit[ni][nj]) {
				dfs(ni, nj, puyo, visit, connected);
			}
		}
	}

	public static void movePuyo() {
        for (int j = 0; j < 6; j++) { // 각 열을 개별적으로 처리
            List<Character> puyos = new ArrayList<>();

            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') {
                    puyos.add(map[i][j]);
                }
            }

            int idx = 11;
            for (char puyo : puyos) {
                map[idx--][j] = puyo;
            }

            while (idx >= 0) {
                map[idx--][j] = '.';
            }
        }
	}
	
}
