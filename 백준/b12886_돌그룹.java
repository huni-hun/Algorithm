package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b12886_돌그룹 {
	static boolean result;
	static boolean visit[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		visit = new boolean[1501][1501];
		System.out.println(bfs(new Group(A, B, C)) ? 1 : 0);
		
	}
	
	public static boolean bfs(Group group) {
		if((group.A + group.B + group.C) % 3 != 0) return false;
		
		Queue<Group> queue = new LinkedList<>();
		queue.add(group);
		while(!queue.isEmpty()) {
			Group now = queue.poll();
			
			if(now.A == now.B && now.A == now.C) {
				return true;
			}
			
			if(now.A != now.B) {
				int na = now.A > now.B ? now.A - now.B : now.A + now.A;
				int nb = now.A > now.B ? now.B + now.B : now.B - now.A;
				if(!visit[na][nb]) {
					visit[na][nb] = true;
					queue.add(new Group(na, nb, now.C));
				}
			}

			if(now.A != now.C) {
				int na = now.A > now.C ? now.A - now.C : now.A + now.A;
				int nc = now.A > now.C ? now.C + now.C : now.C - now.A;
				if(!visit[na][nc]) {
					visit[na][nc] = true;
					queue.add(new Group(na, now.B, nc));
				}
			}
			
			if(now.B != now.C) {
				int nb = now.B > now.C ? now.B - now.C : now.B + now.B;
				int nc = now.B > now.C ? now.C + now.C : now.C - now.B;
				if(!visit[nb][nc]) {
					visit[nb][nc] = true;
					queue.add(new Group(now.A, nb, nc));
				}
			}
		}
		
		return false;
	}
	
	public static class Group {
		int A, B, C;
		
		public Group(int A, int B, int C) {
			this.A = A;
			this.B = B;
			this.C = C;
		}
	}
}
