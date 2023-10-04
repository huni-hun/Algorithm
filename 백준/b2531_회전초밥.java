package algo231004;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class b2531_회전초밥 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
		
		int cnt = 0;
		int[] eat = new int[d+1];
		for (int i = 0; i < k; i++) {
			if(eat[arr[i]] == 0) cnt++;
			
			eat[arr[i]]++;
		}
		if(eat[c] == 0) {
			cnt++;
			eat[c]++;
		}
		
		int len = cnt;
		for (int i = 1; i < N; i++) {
			
			int idx = (i + k - 1) % N;
			if(eat[arr[idx]] == 0) cnt++;
			eat[arr[idx]]++;
			
			if(eat[arr[i-1]] == 1) cnt--;
			eat[arr[i-1]]--;
			
			if(eat[c] == 0) {
				cnt++;
				eat[c]++;
			}
			len = Math.max(len, cnt);
		}
		
		System.out.println(len);
		
//		int result = 0;
//		for (int i = 0; i < N; i++) {
//			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//			
//			for (int j = 0; j < k; j++) {
//				int idx = i+j;
//				if(idx >= N) idx -= N; 
//				map.put(arr[idx], 0);
//			}
//			
//			int cnt = map.size();
//			if(!map.containsKey(c)) cnt++;
//			result = Math.max(result, cnt);
//		}
//		
//		System.out.println(result);
	}
}
