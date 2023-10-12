package algo231012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b11779_최소비용구하기2 {
	static List<List<Pos>> list;
	static int[] prePos; 
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new Pos(end, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		prePos = new int[N+1];
		int[] dist = dijkstra(N, start, end);
		
		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		stack.add(end);
		while(prePos[end] != 0) {
			stack.add(prePos[end]);
			end = prePos[end];
		}
		sb.append(stack.size()).append("\n");
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.pop()).append(" ");
			i--;
		}
		System.out.println(sb);
		
	}
	
	public static int[] dijkstra(int N, int s, int e) {
		int dist[] = new int[N+1];
		boolean visit[] = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.add(new Pos(s, 0));
		while(!pq.isEmpty()) {
			Pos now = pq.poll();
			
			if(!visit[now.end]) {
				visit[now.end] = true;
				
				for (Pos pos : list.get(now.end)) {
					if(!visit[pos.end] && dist[pos.end] > dist[now.end] + pos.cost) {
						dist[pos.end] = dist[now.end] + pos.cost;
						prePos[pos.end] = now.end;
						pq.add(new Pos(pos.end, dist[pos.end]));
					}
				}
			}
		}
		
		return dist;
	}
	
	public static class Pos implements Comparable<Pos>{
		int end;
		int cost;
		
		public Pos(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Pos p) {
			return this.cost - p.cost;
		}
	}
}
