package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1956_운동 {
	static final int INF = 987654321;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] arr = new int[V+1][V+1];
		for (int i = 0; i <= V; i++) {
			
			for (int j = 0; j <= V; j++) {
				if(i == j) continue;
				arr[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			arr[start][end] = cost;
		}
		
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if(i == j) continue;
					
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		int answer = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if(i == j) continue;
				
				System.out.println("I : " + i + " " + "J : " + j + " " + "/" + answer);
				if(arr[i][j] != INF && arr[j][i] != INF) answer = Math.min(answer, arr[i][j] + arr[j][i]);
			}
		}
		
		if(answer != INF) System.out.println(answer);
		else System.out.println(-1);
		
	}
	
}
