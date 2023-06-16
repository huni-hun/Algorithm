package algo230616;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b20437_문자열게임2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			String line = br.readLine();
			int K = Integer.parseInt(br.readLine());
			if(K == 1) {
				System.out.println(1 + " " + 1);
				continue;
			}
			
			int[] alpha = new int[26];
			for (int i = 0; i < line.length(); i++) {
				alpha[line.charAt(i) - 'a']++;
			}
			
			int min = Integer.MAX_VALUE;
			int max = -1;
			for (int i = 0; i < line.length()-1; i++) {
				if(alpha[line.charAt(i) - 'a'] < K) continue;
				int cnt = 1;
				
				for (int j = i+1; j < line.length(); j++) {
					if(line.charAt(i) == line.charAt(j)) {
						cnt++;
						if(cnt == K) {
							min = Math.min(min, j - i + 1);
							max = Math.max(max, j - i + 1);
							break;
						}
					}
				}
			} 
			
			if(min == Integer.MAX_VALUE || max == -1) {
				System.out.println(-1);
				continue;
			} else {
				System.out.println(min + " " + max);
			}
		} // end TC
	}
}
