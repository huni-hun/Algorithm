package algo230605;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1976_여행가자 {
	static int parent[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				int k = Integer.parseInt(st.nextToken());
		
				if(k == 0) continue;
				union(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			if(start != find(now)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	
}
