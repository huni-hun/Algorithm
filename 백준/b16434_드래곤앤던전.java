package algo230503;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16434_드래곤앤던전 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long atk = Long.parseLong(st.nextToken());
		
		long result = 0;
		long curHP = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(check == 1) {
				long attackCnt = h / atk;
				long damege = 0;
				if(h % atk == 0) {
					damege = a * (attackCnt - 1);
				}else {
					damege = (a * attackCnt);
				}
				curHP += damege;
				result = Math.max(curHP, result);
			}else {
				atk += a;
				curHP = Math.max(curHP - h, 0);
			}
		} // end for
		result++;
		
		System.out.println(result);
	}
}
