package algo230404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b5014_스타트링크 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int f = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		
		Queue<Floor> queue = new LinkedList<Floor>();
		boolean visit[] = new boolean[f+1];
		queue.add(new Floor(start, 0));
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			Floor now = queue.poll();
			
			System.out.println(now.floor + " / " + now.cnt);
			if(now.floor == goal) {
				System.out.println(now.cnt);
				return;
			}
			
			int u = now.floor;
			if(now.floor + up <= f) {
				u = now.floor + up;
			}

			int d = now.floor;
			if(now.floor - down >= 1) {
				d = now.floor - down;
			}
			
			if(!visit[u]) {
				visit[u] = true;
				queue.add(new Floor(u, now.cnt + 1));
			}
			if(!visit[d]) {
				visit[d] = true;
				queue.add(new Floor(d, now.cnt + 1));
			}
		}
		
		System.out.println("use the stairs");
	}
	
	static class Floor {
		int floor, cnt;
		
		public Floor(int f, int cnt) {
			this.floor = f;
			this.cnt = cnt;
		}
	}
}
