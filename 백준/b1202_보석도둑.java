package algo231120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1202_보석도둑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int jewels[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i][0] = Integer.parseInt(st.nextToken());
			jewels[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(jewels, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else {
					return o2[1] - o1[1]; 
				}
			}
		});
		
		Integer bags[] = new Integer[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long result = 0;
		for (int i = 0, j = 0; i < K; i++) {
			
			while(j < N && bags[i] >= jewels[j][0]) {
				pq.add(jewels[j][1]);
				j++;
			}
			
			if(!pq.isEmpty()) {
				result += pq.poll();
			}
		}
		
		System.out.println(result);
	}
}
