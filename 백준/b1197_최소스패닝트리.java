package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1197_최소스패닝트리 {
	static List<List<Pos>> list; 
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Pos(end, dist));
			list.get(end).add(new Pos(start, dist));
		}
		
		result = 0; 
		dijkstra(V);

		System.out.println(result);
	}
	
	public static void dijkstra(int N) {
		boolean[] visit = new boolean[N+1];
		Queue<Pos> pq = new PriorityQueue<>();
		
		pq.add(new Pos(1, 0));
		while(!pq.isEmpty()) {
			Pos pos = pq.poll();
			
			if(visit[pos.end]) continue;
			
			visit[pos.end] = true;
			result += pos.dist;
			
			for(Pos next : list.get(pos.end)) {
				if(visit[next.end]) continue;
				
				pq.add(next);
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
