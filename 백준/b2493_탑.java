package algo230117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class b2493_탑 {
	static Stack<Tower> stack;
	static List<Integer> result;
	static int zeroCnt = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		stack = new Stack<Tower>();
		result = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		result.add(0);
		stack.add(new Tower(Integer.parseInt(st.nextToken()), 1));
		
		for (int i = 2; i < N+1; i++) {
			int num = Integer.parseInt(st.nextToken());
						
			stackCal(num, i);
		}
		
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
	}
	
	static void stackCal(int num, int i) {
		if(stack.peek().height >= num) {
			result.add(stack.peek().order);
			stack.add(new Tower(num, i));
		}else {
			stack.pop();	
			if(stack.size() == 0) {
				result.add(0);
				stack.add(new Tower(num, i));
			}else {
				stackCal(num, i);
			}
		}

		
	}
	
	static class Tower {
		int height;
		int order;
		
		public Tower(int height, int order) {
			this.height = height;
			this.order = order;
		}
	}
}
