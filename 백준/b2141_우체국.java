package algo230602;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b2141_우체국 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		
		StringTokenizer st;
		long total = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			list.add(new Node(x, a));
			total += a;
		}
		
		Collections.sort(list);
		long sum = 0;
		for (Node node : list) {
			sum += node.a;
			if(sum >= (total+1)/2) {
				System.out.println(node.x);
				break;
			}
		}
	}
	
	public static class Node implements Comparable<Node> {
		long x;
		long a;
		
		public Node(long x, long a) {
			this.x = x;
			this.a = a;
		}

		@Override
		public int compareTo(Node o) {
			if(this.x == o.x) return (int) (this.a - o.a);
			return (int) (this.x - o.x);
		}
	}
}
