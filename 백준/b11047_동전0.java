package algo230321;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11047_동전0 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Integer coin[] = new Integer[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin, (o1, o2) -> o2 - o1);
		int cnt = 0;
		for (int i = 0; i < coin.length; i++) {
			if(K >= coin[i]) {
				K -= coin[i];
				i--;
				cnt++;
			}
			if(K == 0) break;
		}
		
		System.out.println(cnt);
	}
}
