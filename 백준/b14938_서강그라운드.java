package algo231013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b14938_서강그라운드 {
	static List<List<Road>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 지역개수
		int M = Integer.parseInt(st.nextToken()); // 수색범위
		int R = Integer.parseInt(st.nextToken()); // 간선개수
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		int item[] = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Road(end, cost));
			list.get(end).add(new Road(start, cost));
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int[] dist = dijkstra(N, i);
			int total = item[i];
			
			for (int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(dist[j] <= M) total += item[j];
			}
			
			result = Math.max(result, total);
		}
		
		System.out.println(result);
	}
	
	public static int[] dijkstra(int N, int start) {
		int[] dist = new int[N+1];
		boolean[] visit = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(start, 0));
		while(!pq.isEmpty()) {
			Road now = pq.poll();

			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for(Road road : list.get(now.end)) {
					if(!visit[road.end] && dist[road.end] > dist[now.end] + road.cost) {
						dist[road.end] = dist[now.end] + road.cost;
						pq.add(new Road(road.end, dist[road.end]));
					}
				}
			}
		}
		
		return dist;
	}
	
	public static class Road implements Comparable<Road> {
		int end, cost;
		
		public Road(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road r) {
			
			return this.cost - r.cost;
		}
	}
}
