package algo231129;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16928_뱀과사다리게임 {
	static int result = 0;
	static int[][] ladders;
	static int[][] snakes;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ladders = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			ladders[i][0] = Integer.parseInt(st.nextToken());
			ladders[i][1] = Integer.parseInt(st.nextToken());
		}
		
		snakes = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			snakes[i][0] = Integer.parseInt(st.nextToken());
			snakes[i][1] = Integer.parseInt(st.nextToken());
		}
		
		visit = new boolean[101];
		bfs();
		System.out.println(result);
	}
	
	static public void bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(1, 0));
		
		visit[1] = true;
		while(!queue.isEmpty()) {
			Pos now = queue.poll();
			
			if(now.num == 100) {
				result = now.cnt;
				break;
			}
			
			for (int i = 1; i <= 6; i++) {
				int next = now.num + i;
				
				if(next <= 100 && !visit[next]) {
					int shortCut = 0;
					boolean flag = false;
					
					for (int j = 0; j < ladders.length; j++) {
						if(ladders[j][0] == next) {
							shortCut = ladders[j][1];
							
							visit[next]	= true;
							visit[shortCut] = true;
							queue.add(new Pos(shortCut, now.cnt + 1));
							flag = true;
							break;
						}
					}
					
					for (int j = 0; j < snakes.length; j++) {
						if(snakes[j][0] == next) {
							shortCut = snakes[j][1];
							
							visit[next]	= true;
							visit[shortCut] = true;
							queue.add(new Pos(shortCut, now.cnt + 1));
							flag = true;
							break;
						}
					}
					
					if(flag) continue;
					
					queue.add(new Pos(next, now.cnt + 1));
					visit[next] = true;
				} 
			}
		}
		
	}
	
	static public class Pos {
		int num;
		int cnt;
		
		public Pos(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}
