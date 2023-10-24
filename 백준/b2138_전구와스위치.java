package algo231024;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2138_전구와스위치 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String firstForm = br.readLine();
		String goalForm = br.readLine();
		
		StringBuilder sb1 = new StringBuilder(firstForm);
		StringBuilder sb2 = new StringBuilder(firstForm);
		
		if(sb2.charAt(0) == '0') sb2.setCharAt(0, '1');
		else sb2.setCharAt(0, '0');
		if(sb2.charAt(1) == '0') sb2.setCharAt(1, '1');
		else sb2.setCharAt(1, '0');
		
		int cnt1 = search(sb1, goalForm, N, true);
		int cnt2 = search(sb2, goalForm, N, false);
		
		if(cnt1 != -1 && cnt2 != -1) System.out.println(Math.min(cnt1, cnt2));
		else System.out.println(Math.max(cnt1, cnt2));
	}
	
	public static int search(StringBuilder sb, String target, int N, boolean flag) {
		int cnt;
		if(flag) cnt = 0; 
		else cnt = 1;
		
		for (int i = 0; i < N-1; i++) {
			if(sb.charAt(i) != target.charAt(i)) {
				cnt++;
				sb.setCharAt(i, check(sb.charAt(i)));
				sb.setCharAt(i+1, check(sb.charAt(i+1)));
				if(i+2 >= N) break;
				sb.setCharAt(i+2, check(sb.charAt(i+2)));
			}
		}
		
		if(sb.toString().equals(target)) return cnt;
		
		return -1;
	}
	
	public static char check(char c) {
		char ans = '?';
		
		if(c == '0') ans = '1';
		else if(c =='1') ans = '0';
		
		return ans;
	}
}
