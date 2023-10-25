package algo231025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b16118_달빛여우 {
	static List<List<Pos>> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		} 
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.get(start).add(new Pos(end, cost*2));
			list.get(end).add(new Pos(start, cost*2));
		}
		
		int[] fox = dijkstra(N);
		int[][] wolf = wolfDijkstra(N);
		int result = 0;
		for(int i = 0; i < N+1; i++) {
			if(fox[i] < Math.min(wolf[0][i], wolf[1][i])) result++;
		}
		
		System.out.println(result);
	}
	
	public static int[] dijkstra(int N) {
		int[] dist = new int[N+1];
		boolean visit[] = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(1, 0));
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
		
		return dist;
	}
	
	public static int[][] wolfDijkstra(int N) {
		int[][] dist = new int[2][N+1];
		boolean[][] visit = new boolean[2][N+1];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N+1; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][1] = 0;
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(1, 0, 0));
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			int nextFlag = (now.flag + 1) % 2;
			if(!visit[now.flag][now.end]) {
				visit[now.flag][now.end] = true;
				
				for(Pos pos : list.get(now.end)) {
					int value = pos.cost;
					if(now.flag == 0) {
						value /= 2;
					} else {
						value *= 2;
					}

					if(dist[nextFlag][pos.end] > dist[now.flag][now.end] + value) {
						dist[nextFlag][pos.end] = dist[now.flag][now.end] + value;
						pq.add(new Pos(pos.end, dist[nextFlag][pos.end], nextFlag));
					}
				} // end for each
			} // end if
		}
		
		return dist;
	}
	
	public static class Pos implements Comparable<Pos>{
		int end;
		int cost;
		int flag;
		
		public Pos(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		public Pos(int end, int cost, int flag) {
			this.end = end;
			this.cost = cost;
			this.flag = flag;
		}
		
		@Override
		public int compareTo(Pos p) {
			return this.cost - p.cost;
		}
	}
}
