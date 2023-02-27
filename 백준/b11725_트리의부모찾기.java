package algo230227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11725_트리의부모찾기 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int parent[];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	
		parent = new int[N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int root = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			list.get(root).add(value);
			list.get(value).add(root);
		}
		
		dfs(1);
		bfs(1);
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(parent[i]);
		}
	}
	
	static void dfs(int x) {
		visit[x] = true;
		
		for (int i = 0; i < list.get(x).size(); i++) {
			int value = list.get(x).get(i);
			
			if(visit[value] == false) {
				parent[value] = x;
				dfs(value);
			}
		}
		
	}
	
	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(x);
		visit[x] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int value = list.get(now).get(i);
				
				if(visit[value] == false) {
					visit[value] = true;
					parent[value] = now;
					queue.add(value);
				}
			}
		}
	}
	
}
