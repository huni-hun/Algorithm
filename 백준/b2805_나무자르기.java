package algo230306;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2805_나무자르기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int tree[] = new int[N];
		long max = 0;
		long min = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		long mid = 0;
		while(max > min) {
			mid = (max + min) / 2;
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if(tree[i] > mid)
				sum += (tree[i] - mid);
			}
			
			if(M > sum) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
	}
}
