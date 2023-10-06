package algo231006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1753_최단경로 {
	static List<List<Pos>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		list = new ArrayList<List<Pos>>();
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(new Pos(v, w));
		}
		
		int[] dist = dijkstra(K, V);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
			else sb.append(dist[i]);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int[] dijkstra(int start, int V) {
		boolean visit[] = new boolean[V+1];
		int dist[] = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Pos(start, 0));
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(!visit[now.v]) {
				visit[now.v] = true;
				
				for(Pos p : list.get(now.v)) {
					if(dist[p.v] > dist[now.v] + p.w) {
						dist[p.v] = dist[now.v] + p.w;
						pq.add(new Pos(p.v, dist[p.v]));
					}
				}
			}
			
		}
		
		return dist;
	}
	
	public static class Pos implements Comparable<Pos> {
		int v, w;
		
		public Pos(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		@Override
		public int compareTo(Pos p) {
			
			return this.w - p.w; 
		}
	}
}
