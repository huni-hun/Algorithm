package algo230324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1476_날짜계산 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int startE = 1;
		int startS = 1;
		int startM = 1;
		
		int cnt = 1;
		while(true) {
			if(startE == E && startS == S && startM == M) {
				break;
			}
			
			startE++;
			startS++;
			startM++;
			cnt++;
			
			if(startE == 16) startE = 1;
			if(startS == 29) startS = 1;
			if(startM == 20) startM = 1;
			
		}
		
		System.out.println(cnt);
		
	}
}
