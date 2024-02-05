package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11404_플로이드 {
	static List<List<Pos>> list;
	static int dist[];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(from).add(new Pos(to, cost));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			dist = new int[N+1];
			visit = new boolean[N+1];
			dijkstra(i);
			
			for(int k = 1; k < dist.length; k++) {
				if(dist[k] == Integer.MAX_VALUE) dist[k] = 0; 
				sb.append(dist[k]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Queue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(start, 0));
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(visit[now.end]) continue;
			visit[now.end] = true;
			
			for (Pos next : list.get(now.end)) {
				
				if(dist[next.end] > dist[now.end] + next.dist) {
					dist[next.end] = dist[now.end] + next.dist;
					pq.add(new Pos(next.end, dist[next.end]));
				}
			}		
			
		}
		
	}
	
	public static class Pos implements Comparable<Pos>{
		int end;
		int dist;
		
		public Pos(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Pos o) {
			return this.dist - o.dist;
		}
	}
}
