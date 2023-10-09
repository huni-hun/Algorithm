package algo231009;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1916_최소비용구하기 {
	static List<ArrayList<Bus>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Bus(end, cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = dijkstra(N, start, end);
		System.out.println(dist[end]);
	}
	
	public static int[] dijkstra(int N, int s, int e) {
		int[] dist = new int[N+1];
		boolean[] visit = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(s, 0));
		dist[s] = 0;
		while(!pq.isEmpty()) {
			Bus now = pq.poll();
			
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(Bus bus : list.get(now.end)) {
					if(dist[bus.end] > dist[now.end] + bus.cost) {
						dist[bus.end] = dist[now.end] + bus.cost;
						pq.add(new Bus(bus.end, dist[bus.end]));
					}
				}
			}
		}
		
		return dist;
	}
	
	public static class Bus implements Comparable<Bus> {
		int end, cost;
		
		public Bus(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		public int compareTo(Bus b) {
			return this.cost - b.cost;
		}
	}
}
