package algo230615;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b1911_흙길보수하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		List<Pool> list = new ArrayList<b1911_흙길보수하기.Pool>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Pool(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		int result = 0;
		int range = 0;
		for (int i = 0; i < list.size(); i++) {
			int s = list.get(i).start;
			int e = list.get(i).end;
			
			if(s > range) range = s;
			
			if(e > range) {
				while(e > range) {
					range += L;
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
	
	public static class Pool implements Comparable<Pool> {
		int start;
		int end;
		
		public Pool(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Pool o) {
			if(this.start == o.start) {
				return o.end - this.end;
			} else {
				return this.start - o.start;
			}
		}
	}
}
