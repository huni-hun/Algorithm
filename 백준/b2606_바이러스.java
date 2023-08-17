package algo230817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2606_바이러스 {
	static int result = 0;
	static int map[][];
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		map = new int[cnt+1][cnt+1];
		visit = new boolean[cnt+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			map[n][m] = map[m][n] = 1;
		}
		
//		bfs(cnt);
		visit[1] = true;
		dfs(1, cnt);
		System.out.println(result);
	}
	
	public static void bfs(int cnt) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			int n = queue.poll();
			for (int i = 1; i < cnt; i++) {
				if(map[n][i] == 1 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
					result++;
				}
			}
		}
	}
	
	public static void dfs(int idx, int cnt) {
		
		for (int i = 1; i <= cnt; i++) {
			if(map[idx][i] == 1 && !visit[i]) {
				visit[i] = true;
				result++;
				dfs(i, cnt);
			}
		}
	}
}
