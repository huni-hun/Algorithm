package algo230509;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17822_원판돌리기 {
	static int N, M, T;
	static int round[][];
	static boolean remove[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		round = new int[N+1][M];
		remove = new boolean[N+1][M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				round[i][j]	= Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			turn(d, x, k);
			if(check()) {
				double num = calRound();
				calc(num);
			}
		}
		
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				sum += round[i][j];
			}
		}
		
		System.out.println(sum);
	}  // end main
	
	public static void turn(int dir, int x, int k) {
		if(dir == 0) {
			while(k > 0) {
				for (int i = x; i <= N; i+=x) {
					int temp = round[i][0];
					for (int j = 0; j < M-1; j++) {
						int t = round[i][j+1];
						round[i][j+1] = temp;
						temp = t;
					}
					round[i][0] = temp;
				}
				
				k--;
			}
			
		} else {
			while(k > 0) {
				for (int i = x; i <= N; i+=x) {
					int temp = round[i][0];
					for (int j = M-1; j >= 0; j--) {
						int t = round[i][j];
						round[i][j] = temp;
						temp = t;
					}
					round[i][M-1] = temp;
				}
				
				k--;
			}
		}
	} // end turn
	
	public static boolean check() {
		boolean flag = true;
		// 같은 원판안에 인접수 체크
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M-1; j++) {
				if(round[i][j] == 0) continue;
				if(round[i][j] == round[i][j+1]) {
					remove[i][j] = true;
					remove[i][j+1] = true;
					flag = false;
				}
			}
			if(round[i][0] == 0) continue;
			if(round[i][0] == round[i][M-1]) {
				remove[i][0] = true;
				remove[i][M-1] = true;
				flag = false;
			}
		}
		
		// 다른 원판과 인접수 체크
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(round[i][j] == 0) continue;
				if(round[i][j] == round[i+1][j]) {
					remove[i][j] = true;
					remove[i+1][j] = true;
					flag = false;
				}
			}
		}
		
		if(flag == false) {
			removing();
			remove = new boolean[N+1][M];
		}
		return flag;
	} // end check
	
	public static void removing() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(remove[i][j]) round[i][j] = 0;
			}
		}
	}
	
	public static double calRound() {
		double sum = 0;
		double cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(round[i][j] != 0) {
					sum += round[i][j];
					cnt++;
				}
			}
		}
		
		return sum/cnt;
	}
	
	public static void calc(double num) {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				if(round[i][j] != 0) {
					if(round[i][j] > num) round[i][j]--;
					else if(round[i][j] < num) round[i][j]++;
				}
			}
		}
	}
	
}
