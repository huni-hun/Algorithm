package algo230627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1446_지름길 {
	static int N, D;
	static List<Road> list;
	static int dist[];	
	static Road temp[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		list = new ArrayList<Road>();
		temp = new Road[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(e > D) continue;
			if(e - s <= c) continue;
			
			list.add(new Road(s, e, c));
		
//			dijkstra2
//			temp[i] = new Road(s, e, c);
		}
		
//		선형구조 다익스트라
		Collections.sort(list);
		dist = new int[10001];
		Arrays.fill(dist, 10001);
		
		dist[0] = 0;
		dijkstra();
		
		// PQ 다익스트라
//		dist = new int[10001];
//		Arrays.fill(dist, 10001);
//		
//		dist[0] = 0;
//		dijkstra2();
	}
	
//	public static void dijkstra2() {
//		PriorityQueue<Road> pq = new PriorityQueue<>();
//		pq.add(new Road(0, 0, 0));
//		
//		while(!pq.isEmpty()) {
//			Road r = pq.poll();
//			
//			int destination = r.end;
//			for(Road road : temp) {
//				
//				if(road.start >= destination) {
//					if(road.end > D) continue;
//					int tmp = road.start - destination;
//					
//					if(dist[road.end] > dist[destination] + road.cost + tmp) {
//						dist[road.end] = dist[destination] + road.cost + tmp;
//						pq.offer(new Road(destination, road.end, dist[road.end]));
//					}
//				}
//			}
//			
//			dist[D] = Math.min(dist[destination] + D - destination, dist[D]);
//		}
//		
//		System.out.println(dist[D]);
//	}
	
	public static void dijkstra() {
		int idx = 0; 
		int move = 0;
		
		while(move < D) {
			if(idx < list.size()) {
				Road r = list.get(idx);
				if(move == r.start) {
					dist[r.end] = Math.min(dist[r.end], dist[move] + r.cost);
					idx++;
				} else {
					dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
					move++;
				}
			} else {
				dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
				move++;
			}
		}
		
		System.out.println(dist[D]);
	}
	
	public static class Road implements Comparable<Road>{
		int start;
		int end;
		int cost;
		
		public Road(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Road road) {
			if(this.start == road.start) {
				return this.end - road.end;
			} else {
				return this.start - road.start;
			}
		}
	}
}
