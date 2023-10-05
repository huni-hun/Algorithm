package algo231005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1238_파티 {
	static int N, M, X;
	static List<List<Road>> list;
	static List<List<Road>> reverseList;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new LinkedList<>();
		reverseList = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list.get(s).add(new Road(e, t));
			reverseList.get(e).add(new Road(s, t));
		}
		
		int[] dist = dijkstra(list);
		int[] revereDist = dijkstra(reverseList);
		
		int result = 0;
		for (int i = 0; i <= N; i++) {
			result = Math.max(result, dist[i] + revereDist[i]);
		}
		System.out.println(result);
	}
	
	public static int[] dijkstra(List<List<Road>> item) {
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(X, 0));
		
		boolean visit[] = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X] = 0;
		while(!pq.isEmpty()) {
			Road now = pq.poll();
			int town = now.e;
			
			if(!visit[town]) {
				visit[town] = true;
				
				for (Road next : item.get(town)) {
					if(dist[next.e] > dist[town] + next.t) {
						dist[next.e] = dist[town] + next.t;
						pq.add(new Road(next.e, dist[next.e]));
					}
				}
			}
			
		}
		
		return dist; 
	}
	
	public static class Road implements Comparable<Road>{
		int e, t;
		
		public Road(int e, int t) {
			this.e = e;
			this.t = t;
		}
		
		@Override
		public int compareTo(Road r) {
			
			return t - r.t;
		}
	}
}
