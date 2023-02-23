package algo230223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b10451_순열사이클 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean visit[];
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N+1];
			
			list = new ArrayList<>();
			visit = new boolean[N+1];
			result = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N+1; i++) {
				list.add(new ArrayList<>());
			}
			for (int i = 1; i < N+1; i++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 1; i < N+1; i++) {
				if(visit[i] == false) {
					dfs(i);
					bfs(i);
					result++;
				}
			}
			
			System.out.println(result);
			
		} // end TC
		
	} // end main
	
	static void dfs(int x) {
		visit[x] = true;
		
		for (int i = 0; i < list.get(x).size(); i++) {
			int value = list.get(x).get(i);
			
			if(visit[value] == true) {
				return;
			}
			
			if(visit[value] == false) {
				dfs(value);
			}
		}
	}
	
	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		
		visit[x] = true;
		queue.offer(x);
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < list.get(temp).size(); i++) {
				int value = list.get(temp).get(i);
				
				if(!visit[value]) {
					visit[value] = true;
					queue.offer(value);
				}
			}
		}
	}
}
