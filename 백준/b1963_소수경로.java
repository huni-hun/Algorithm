package algo230329;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1963_소수경로 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] prime = new boolean[10000];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i < 10000; i++) {
			if(!prime[i]) {
				for (int j = i * 2; j < 10000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			int end = Integer.parseInt(st.nextToken());
			
			boolean visit[] = new boolean[10000];
			int count[] = new int[10000];
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(Integer.parseInt(start));
			visit[Integer.parseInt(start)] = true;
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				int now = queue.poll();
				if(now == end) {
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 10; j++) {
						if(i == 0 && j == 0) continue;
						
						StringBuilder sb = new StringBuilder(String.valueOf(now));
						sb.setCharAt(i, (char)(j + '0'));
						int num = Integer.parseInt(sb.toString());
						if(!prime[num] && !visit[num]) {
							visit[num] = true;
							count[num] = count[now] + 1;
							queue.add(num);
						}
					}
				}
				
			} // end while
			
			System.out.println(count[end]);
		}
		
	}
}
