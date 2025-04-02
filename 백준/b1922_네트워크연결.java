package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1922_네트워크연결 {
	static List<List<Computer>> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new LinkedList<Computer>());
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Computer(b, c));
			list.get(b).add(new Computer(a, c));
		}
		
		int result = prim(N);
		
		System.out.println(result);
	}
	
	public static int prim(int N) {
		PriorityQueue<Computer> pq = new PriorityQueue<>();
		pq.add(new Computer(1, 0));
		
		boolean[] visit = new boolean[N+1];

		int totalCost = 0;
		int count = 0;
		while(!pq.isEmpty()) {
			Computer now = pq.poll();
			
			if(visit[now.idx]) continue;
			visit[now.idx] = true;
			
			if(count == N) break;
			
			totalCost += now.cost;
			for (Computer c : list.get(now.idx)) {
				if(!visit[c.idx]) pq.add(new Computer(c.idx, c.cost));
			}
			
		}
		
		return totalCost;
	}
	
	public static class Computer implements Comparable<Computer> {
		int idx;
		int cost;
		
		public Computer(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Computer o) {
			return this.cost - o.cost;
		}
	}
}
