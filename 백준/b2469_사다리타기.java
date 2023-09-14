package algo230914;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2469_사다리타기 {
	static int K, N;
	static int lineIdx;
	static char map[][];
	static char alphabet[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		
		alphabet = new char[N+2][K];
		for (int i = 0; i < K; i++) {
			alphabet[0][i] = (char) ('A' + i);
			alphabet[N+1][i] = line.charAt(i);
		}
		
		lineIdx = 0;
		map = new char[N][K-1];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			
			for (int j = 0; j < K-1; j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j] == '?') lineIdx = i;
			}
		}
				
		frontSearch();
		backSearch();
//		for (int i = 0; i <= N+1; i++) {
//			
//			for (int j = 0; j < K; j++) {
//				System.out.print(alphabet[i][j] + " ");
//			}
//			System.out.println();
//		}
		StringBuilder sb = new StringBuilder();
		System.out.println(compare(sb));
	}
	
	public static void frontSearch() {
		int idx = 1;
		while(idx <= lineIdx) {
			for (int i = 0; i < K; i++) {
				if(i-1 >= 0 && map[idx-1][i-1] == '-') {
					alphabet[idx][i-1] = alphabet[idx-1][i];
				} else if(i < K-1 && map[idx-1][i] == '-') { 
					alphabet[idx][i+1] = alphabet[idx-1][i];
				} else {
					alphabet[idx][i] = alphabet[idx-1][i];
				} 
			} 
			idx++;
		}
	}

	public static void backSearch() {
		int idx = N;
		while(idx > lineIdx+1) {
			for (int i = 0; i < K; i++) {
				if(i-1 >= 0 && map[idx-1][i-1] == '-') {
					alphabet[idx][i-1] = alphabet[idx+1][i];
				} else if(i < K-1 && map[idx-1][i] == '-') { 
					alphabet[idx][i+1] = alphabet[idx+1][i];
				} else {
					alphabet[idx][i] = alphabet[idx+1][i];
				} 
			} 
			idx--;
		}
	}
	
	public static String compare(StringBuilder sb) {
		for (int i = 0; i < K-1; i++) {
			if(alphabet[lineIdx][i] == alphabet[lineIdx+2][i]) {
				sb.append('*');
			} else {
				if(alphabet[lineIdx][i+1] == alphabet[lineIdx+2][i]) {
					sb.append('-');
					sb.append('*');
					i++;
				} else {
					sb = new StringBuilder();
					for (int j = 0; j < K-1; j++) {
						sb.append('x');
					}
					return sb.toString();
				}
			}
		}
		
		if(sb.charAt(K-2) == '-') sb.deleteCharAt(K-1);
		return sb.toString();
	}
}
