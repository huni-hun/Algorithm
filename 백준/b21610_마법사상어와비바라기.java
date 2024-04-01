package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b21610_마법사상어와비바라기 {
	static int di[] = {0, -1, -1 ,-1, 0, 1, 1, 1}; 
	static int dj[] = {-1, -1, 0 , 1, 1, 1, 0, -1};
	static int N, M;
	static int map[][];
	static boolean visit[][];
	static Queue<int[]> cloud = new LinkedList<int[]>(); 
	static Queue<int[]> rain = new LinkedList<int[]>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cloud .add(new int[] {N-1, 0});
		cloud .add(new int[] {N-1, 1});
		cloud .add(new int[] {N-2, 0});
		cloud .add(new int[] {N-2, 1});
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			move(d-1, s);
		}
		
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += map[i][j];
			}
		}
		
		System.out.println(result);
	}
	
	public static void move(int d, int s) {
		while(!cloud.isEmpty()) {
			int[] now = cloud.poll();
			
			int xi = (di[d] * s) % N;
			int xj = (dj[d] * s) % N;
			
			int ni = 0;
			int nj = 0;
			if(now[0] + xi < 0) {
				ni = N + (now[0] + xi);
			} else if(now[0] + xi >= N) {
				ni += Math.abs(N - (xi + now[0]));
			} else {
				ni = now[0] + xi; 
			}
			
			if(now[1] + xj < 0) {
				nj = N + (now[1] + xj);
			} else if(now[1] + xj >= N) {
				nj += Math.abs(N - (xj + now[1]));
			} else {
				nj = now[1] + xj; 
			}
			
			rainning(ni, nj);
		}
	
		waterCopy();
	}
	
	public static void rainning(int x, int y) {
		map[x][y]++;
		rain.add(new int[] {x, y});
	}
	
	public static void waterCopy() {
		visit = new boolean[N][N];
		
		while(!rain.isEmpty()) {
			int[] now = rain.poll();
			visit[now[0]][now[1]] = true;
			
			for (int k = 1; k < 8; k += 2) {
				int ni = now[0] + di[k];
				int nj = now[1] + dj[k];
				
				if(ni >= 0 && nj >= 0 && ni < N && nj < N) {
					if(map[ni][nj] > 0) map[now[0]][now[1]]++;
				}
			}
		}
		
		addCloud();
	}
	
	public static void addCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					if(map[i][j] >= 2) {
						cloud.add(new int[] {i, j});
						map[i][j] -= 2;
					}
				}
			}
		}
	}
}
