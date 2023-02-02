package algo230202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b19637_이분탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String title[] = new String[N];
		int power[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			title[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int tc = 0; tc < M; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			int start = 0;
			int end = N-1;
			int mid = 0;
			while(start <= end) {
				mid = (start + end) / 2;
				if(power[mid] < num) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
			bw.write(title[start] + "\n");
		}
		bw.flush();
		
	}
}
