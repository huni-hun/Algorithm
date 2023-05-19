package algo230518;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1863_스카이라인쉬운거 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = y;
		}
		
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= N; i++) {
			while(!stack.isEmpty() && stack.peek() > arr[i]) {
				result++;
				stack.pop();
			}
			
			if(!stack.isEmpty() && stack.peek() == arr[i]) continue;
			
			stack.add(arr[i]);
		}
		
		System.out.println(result);
	}
}
