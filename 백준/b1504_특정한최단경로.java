package algo231010;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1504_특정한최단경로 {
	static List<ArrayList<Pos>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());	
		
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Pos(end, cost));
			list.get(end).add(new Pos(start, cost));
		}
		
		st = new StringTokenizer(br.readLine());  
		int via1 = Integer.parseInt(st.nextToken());
		int via2 = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(N, 1, via1) + dijkstra(N, via1, via2) + dijkstra(N, via2, N); 
		int result2 = dijkstra(N, 1, via2) + dijkstra(N, via2, via1) + dijkstra(N, via1, N);

		int answer = Math.min(result, result2);
		if(answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(result, result2));
		}
	}
	
	public static int dijkstra(int N, int start, int end) {
		int[] dist = new int[N+1];
		boolean visit[] = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(start, 0));
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(Pos pos : list.get(now.end)) {
					if(!visit[pos.end] && dist[pos.end] > dist[now.end] + pos.cost) {
						dist[pos.end] = dist[now.end] + pos.cost;
						pq.add(new Pos(pos.end, dist[pos.end]));
					}
				}
			}
		}
		
		return dist[end];
	}
	
	public static class Pos implements Comparable<Pos>{
		int end, cost; 
		
		public Pos(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Pos p) {
			return this.cost - p.cost;
		}
 	}
}
