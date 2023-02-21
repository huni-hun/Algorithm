package algo230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1707_이분그래프 {
	static ArrayList<ArrayList<Integer>> list;
	static int color[];
	static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			result = "YES";
			list = new ArrayList<>();
			color = new int[V+1];
			for (int i = 0; i < V+1; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				list.get(start).add(end);
				list.get(end).add(start);
			}
			
			for (int i = 1; i < V+1; i++) {
				if(result.equals("NO")) break;
				if(color[i] == 0) {
					dfs(i, 1);
				}
			}
			
			System.out.println(result);
		} // end TC
		
	} // end main
	
	static void dfs(int x, int type) {
		color[x] = type;
		
		for (int i = 0; i < list.get(x).size(); i++) {
			int value = list.get(x).get(i);
			if(color[value] == type) {
				result = "NO";
				return;
			}
			if(color[value] == 0) {
				dfs(value, -type);
			}
		}
		
	}
}
