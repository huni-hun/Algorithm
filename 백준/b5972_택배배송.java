package algo230517;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b5972_택배배송 {
	static List<Node> list[];
	static boolean visit[];
	static int dist[];
	static final int infinity = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, infinity);
		dijkstra();
		System.out.println(dist[N]);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[1] = 0;
		
		pq.add(new Node(1, 0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visit[now.destination]) continue;
			visit[now.destination] = true;
			
			for (int i = 0; i < list[now.destination].size(); i++) {
				Node next = list[now.destination].get(i);
				if(dist[next.destination] > dist[now.destination] + next.cost) {
					dist[next.destination] = dist[now.destination] + next.cost;
					pq.add(new Node(next.destination, dist[next.destination]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node> {
		int destination;
		int cost;
		
		public Node(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
