package algo230613;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2343_기타레슨 {
	static int N, M;
	static int[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new int[N];
		
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			right += list[i];
			left = Math.max(left, list[i]);
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = calc(mid);
			
			if(count > M) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.println(left);
	}
	
	public static int calc(int mid) {
		int sum = 0;
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			if(sum + list[i] > mid) {
				sum = 0;
				count++;
			} 
			sum += list[i];
		}
		
		if(sum != 0) count++;
		return count;
	}
	
}
