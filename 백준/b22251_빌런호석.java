package algo230425;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b22251_빌런호석 {
	static int N, K, P, X;
	static int result = 0;
	static int display[][] = {{1, 1, 1, 0, 1, 1, 1},
							{0, 0, 1, 0, 1, 0, 0},
							{0, 1, 1, 1, 0, 1, 1},
							{0, 1, 1, 1, 1, 1, 0},
							{1, 0, 1, 1, 1, 0, 0},
							{1, 1, 0, 1, 1, 1, 0},
							{1, 1, 0, 1, 1, 1, 1},
							{0, 1, 1, 0, 1, 0, 0},
							{1, 1, 1, 1, 1, 1, 1},
							{1, 1, 1, 1, 1, 1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 층 수
		K = Integer.parseInt(st.nextToken()); // 디스플레이 자리 수
		P = Integer.parseInt(st.nextToken()); // 반전 시킬 수
		X = Integer.parseInt(st.nextToken()); // 멈춘 층 수

		int[] xParse = numParse(X);
		check(xParse);
		System.out.println(result);
	}
	
	public static void check(int[] xParse) {
		for(int i = 1; i <= N; i++) {
			if(i == X) continue;
			if(canReverse(i, xParse)) result++; 
		}
	}
	
	public static boolean canReverse(int num, int[] xParse) {
		int[] target = numParse(num);
		
		int cnt = 0;
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < 7; j++) {
				if(display[xParse[i]][j] != display[target[i]][j]) cnt++;
				if(cnt > P) return false;
			}
		}
		return true;
	}
	
	public static int[] numParse(int num) {
		int[] result = new int[K];
		for(int i = K-1; i >= 0; i--) {
			result[i] = num % 10;
			num /= 10;
		}
		
		return result;
	}
}
