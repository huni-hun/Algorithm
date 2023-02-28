package algo230228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1967_트리의지름 {
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static boolean visit[];
	static int result = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		for (int i = 0; i < V+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < V-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int cnt = st.countTokens();
			while(cnt > 1) {
				cnt -= 2;
				int end = Integer.parseInt(st.nextToken());
				int length = Integer.parseInt(st.nextToken());
				list.get(start).add(new Node(end, length));
				list.get(end).add(new Node(start, length));
			}
		}
		
		for (int i = 1; i < V+1; i++) {
			visit = new boolean[V+1];
			dfs(i, 0);
		}
		System.out.println(result);
	}
	
	static void dfs(int x, int total) {
		if(result < total) {
			result = total;
		}
		visit[x] = true;
		
		for (int i = 0; i < list.get(x).size(); i++) {
			int value = list.get(x).get(i).node;
			
			if(visit[value] == false) {
				visit[value] = true;
				dfs(value, total + list.get(x).get(i).length);
			}
		}
	}
	
	static class Node {
		int node;
		int length;
		
		public Node(int node, int length) {
			this.node = node;
			this.length = length;
		}
	}
}
