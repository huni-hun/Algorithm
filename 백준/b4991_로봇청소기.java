package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b4991_로봇청소기 {
	static int di[] = {-1, 0, 1, 0};	
	static int dj[] = {0, 1, 0, -1};
	static int N, M, result;
	static char map[][];
	static boolean use[];
	static boolean visit[][];
	static List<List<Node>> list;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;;
			
			map = new char[N][M];
			
			int dustIdx = 1;
			Pos[] dusts = new Pos[11];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				
				for (int j = 0; j < M; j++) {
					map[i][j] = temp.charAt(j);
					
					if(map[i][j] == 'o') {
						dusts[0] = new Pos(i, j, 0);
					} else if(map[i][j] == '*') {
						dusts[dustIdx++] = new Pos(i, j, 0);
					}
				}
			}
			
			list = new ArrayList<>();
			for (int i = 0; i < dustIdx; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < dustIdx - 1; i++) {
				
				for (int j = i + 1; j < dustIdx; j++) {
					int num = bfs(dusts[i], dusts[j]);
					if(num == -1) continue;
					list.get(i).add(new Node(j, num));
					list.get(j).add(new Node(i, num));
				}
			}
			
			result = Integer.MAX_VALUE;
			use = new boolean[dustIdx];
			use[0] = true;
			search(0, 0, 0, dustIdx);
			
			System.out.println(result != Integer.MAX_VALUE ? result : -1);
		}
		
	}
	
	public static void search(int start, int depth, int sum, int len) {
		if(depth == len - 1) {
			result = Math.min(result, sum);
			return;
		}
		
		for(Node node : list.get(start)) {
			if(use[node.point]) continue;
			use[node.point] = true;
			search(node.point, depth + 1, sum + node.cost, len);
			use[node.point] = false;
		}
	}
	
	public static int bfs(Pos start, Pos target) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(start);
		
		visit = new boolean[N][M];
		visit[start.x][start.y] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if(now.x == target.x && now.y == target.y) {
				return now.cnt;
			}
			
			for (int k = 0; k < 4; k++) {
				int ni = now.x + di[k];
				int nj = now.y + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != 'x' && !visit[ni][nj]) {
					visit[ni][nj] = true;
					queue.add(new Pos(ni, nj, now.cnt + 1));
				}
			}
		}
		
		return -1;
	}
	
	public static class Node {
		int point;
		int cost;
		
		public Node(int point, int cost) {
			this.point = point;
			this.cost = cost;
		}
	}
	
	public static class Pos {
		int x, y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
