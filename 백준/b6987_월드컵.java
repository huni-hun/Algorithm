package algo230919;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b6987_월드컵 {
	static int home[] = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
	static int away[] = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
	static int point[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = 4;
		StringBuilder sb = new StringBuilder();
		while(TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			point = new int[6][3];
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				int row = 0;
				
				for (int j = 0; j < 3; j++) {
					point[i][j] = Integer.parseInt(st.nextToken());
					sum += point[i][j];
				}
			}
			
			if(sum != 30) {
				sb.append(0).append(" ");
				continue;
			}
			
			if(play(0)) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
	public static boolean play(int cnt) {
		if(cnt == 15) {
			return true;
		}
		
		// 홈 승
		if(point[home[cnt]][0] > 0 && point[away[cnt]][2] > 0) {
			point[home[cnt]][0]--;
			point[away[cnt]][2]--;
			if(play(cnt+1)) return true;
			point[home[cnt]][0]++;
			point[away[cnt]][2]++;
		}
			
		// 무
		if(point[home[cnt]][1] > 0 && point[away[cnt]][1] > 0) {
			point[home[cnt]][1]--;
			point[away[cnt]][1]--;
			if(play(cnt+1)) return true;
			point[home[cnt]][1]++;
			point[away[cnt]][1]++;
		}
		
		// 홈 패
		if(point[home[cnt]][2] > 0 && point[away[cnt]][0] > 0) {
			point[home[cnt]][2]--;
			point[away[cnt]][0]--;
			if(play(cnt+1)) return true;
			point[home[cnt]][2]++;
			point[away[cnt]][0]++;
		}
			
		return false;
	}
}
