package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b11403_경로찾기 {
	static int map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(N);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int N) {
		
		for (int i = 0; i < N; i++) {
			boolean[] visit = new boolean[N];
			Queue<Integer> queue = new LinkedList<Integer>();
			
			queue.add(i);
			while(!queue.isEmpty()) {
				int num = queue.poll();
				
				for (int j = 0; j < N; j++) {
					if(!visit[j] && map[num][j] == 1) {
						visit[j] = true;
						map[i][j] = 1;
						queue.add(j);
					}
				}
			}
		}
		
	}

}
