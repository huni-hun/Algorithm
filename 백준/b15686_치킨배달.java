package algo230214;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b15686_치킨배달 {
	static int map[][];
	static int N, M;
	static List<Pos> house;
	static List<Pos> chicken;
	static boolean chickenCount[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		house = new ArrayList<Pos>();
		chicken = new ArrayList<Pos>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					house.add(new Pos(i, j));
				} else if(map[i][j] == 2) {
					chicken.add(new Pos(i, j));
				}
			}
		}
		
		chickenCount = new boolean[chicken.size()];
		
		result = Integer.MAX_VALUE;
		dfs(0, 0);
		
		System.out.println(result);
	}
	
	static void dfs(int m, int idx) {
		if(m == M) {
			int temp = 0;
			for (Pos h : house) {
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < chicken.size(); k++) {
					if(chickenCount[k] == true) {
						int length = Math.abs(h.x - chicken.get(k).x) + Math.abs(h.y - chicken.get(k).y);
						min = Math.min(min, length);
					}
				}
				
				temp += min;
			}
			
			result = Math.min(temp, result);
		}
		
		for (int i = idx; i < chickenCount.length; i++) {
			if(chickenCount[i] == false) {
				chickenCount[i] = true;
				dfs(m+1, i+1);
				chickenCount[i] = false;
			}
		}
	}
	
	static class Pos {
		int x, y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
