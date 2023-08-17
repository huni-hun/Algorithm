package algo230817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class b6198_옥상정원꾸미기 {
	static int N;
	static long result;
	static int building[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		building = new int[N];
		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N - 1; i++) {
			view(i);
		}
		System.out.println(result);
	}
	
	public static void view(int idx) {
		int num = building[idx];
		for (int i = idx+1; i < building.length; i++) {
			if(num > building[i]) {
				result++;
				continue;
			} 
			break;
		}
	}
}
