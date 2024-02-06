package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3190_뱀 {
	static int di[] = {0, 1, 0, -1};
	static int dj[] = {1, 0, -1, 0};
	static int N;
	static int map[][];
	static Queue<int[]> snake;
	static Map<Integer, String> order;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 9;
		}
		
		int L = Integer.parseInt(br.readLine());
		order = new HashMap<Integer, String>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			
			order.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}
		
		snake = new LinkedList<int[]>();
		System.out.println(play());
	}
	
	public static int play() {
		int cx = 0, cy = 0;
		int time = 0;
		int dir = 0;
		
		snake.add(new int[] {0, 0});
		while(!snake.isEmpty()) {
			int[] now = snake.peek();
			time++;

			int nx = cx + di[dir];
			int ny = cy + dj[dir];
			
			if(move(nx, ny)) break;
			if(map[nx][ny] == 9) {
				map[nx][ny] = 0;
			} else {
				snake.poll();
			}
			
			snake.add(new int[] {nx, ny});
			
			if(order.containsKey(time)) {
				String direction = order.get(time);
				
				if(direction.equals("D")) {
					dir++;
					if(dir == 4) dir = 0;
				} else {
					dir--;
					if(dir == -1) dir = 3;
				}
			}
			
			cx = nx;
			cy = ny;
		}
		
		return time;
	}
	
	public static boolean move(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y>= N) return true;
		
		for(int[] temp : snake) {
			if(temp[0] == x && temp[1] == y) return true;
		}
		
		return false;
	}
	
}
