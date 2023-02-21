package algo230221;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11724_연결요소의개수 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		int result = 0;
		for (int i = 1; i < N+1; i++) {
			if(!visit[i]) {
				result++;
				dfs(i);
				bfs(i);
			}
		}
		
		System.out.println(result);
	}
	
	static void dfs(int x) {
		if(visit[x]) return;
		
		visit[x] = true;
		for (int i = 0; i < list.get(x).size(); i++) {
			int value = list.get(x).get(i);
			if(!visit[value]) {
				dfs(value);
			}
		}
	}
	
	static void bfs(int x) {
		if(visit[x]) return;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		visit[x] = true;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < list.get(temp).size(); i++) {
				int value = list.get(temp).get(i);
				if(!visit[value]) {
					queue.add(value);
					visit[value] = true;
				}
			}
		}
		
	}
}
