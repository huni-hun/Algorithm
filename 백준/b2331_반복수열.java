package algo230223;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b2331_반복수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(A);
		int temp = A;
		while(true) {
			temp = cal(temp, P);
			if(list.contains(temp)) break;
			list.add(temp);
		}
		
		System.out.println(list.indexOf(temp));
		
	}
	
	static int cal(int x, int p) {
		int result = 0;
		String X = x + "";
		
		for (int i = 0; i < X.length(); i++) {
			int temp = X.charAt(i) - '0';
			result += (int)Math.pow(temp, p);
		}
		
		return result;
	}
}
