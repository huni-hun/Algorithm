package algo231016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b10282_해킹 {
	static List<List<Route>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		while(TC -- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<List<Route>>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list.get(end).add(new Route(start, cost));
			}
			
			int[] dist = dijkstra(N, C);
			int cnt = 0;
			int time = 0;
			for (int d : dist) {
				if(d == Integer.MAX_VALUE) continue;
				
				cnt++;
				time = Math.max(time, d);
			}
			
			System.out.println(cnt + " " + time);
		}
	}
	
	public static int[] dijkstra(int N, int S) {
		int[] dist = new int[N+1];
		boolean[] visit = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S] = 0;
		PriorityQueue<Route> pq = new PriorityQueue<>();
		pq.add(new Route(S, 0));
		while(!pq.isEmpty()) {
			Route now = pq.poll();
			
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(Route route : list.get(now.end)) {
					
					if(!visit[route.end] && dist[route.end] > dist[now.end] + route.second) {
						dist[route.end] = dist[now.end] + route.second;
						pq.add(new Route(route.end, dist[route.end]));
					}
				}
			}
		}
		
		return dist;
	}
	
	public static class Route implements Comparable<Route> {
		int end;
		int second;
		
		public Route(int end, int second) {
			this.end = end;
			this.second = second;
		}
		
		@Override
		public int compareTo(Route r) {
			return this.second - r.second;
		}
	}
}
