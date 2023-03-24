package algo230324;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1107_리모컨 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean error[] = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) { 
			error[Integer.parseInt(st.nextToken())] = true;
		}
		
		int result = Math.abs(N - 100);
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			for (int j = 0; j < len; j++) {
				if(error[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				int min = Math.abs(N - i) + len;
				result = Math.min(result, min);
			}
		}
		
		System.out.println(result);
	}
}
