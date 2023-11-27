package algo231127;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1461_도서관 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > 0) positive.add(num);
			else negative.add(Math.abs(num));
		}
		
		int dist = 0;
		if(positive.isEmpty()) {
			dist = negative.peek();
		} else if(negative.isEmpty()) {
			dist = positive.peek();
		} else {
			dist = Math.max(positive.peek(), negative.peek());
		}
		
		int result = 0;
		while(!positive.isEmpty()) {
			int temp = positive.poll();
			
			for (int i = 0; i < M - 1; i++) {
				positive.poll();
				
				if(positive.isEmpty()) break;
			}
			
			result += temp * 2;
		}
		
		while(!negative.isEmpty()) {
			int temp = negative.poll();
			
			for (int i = 0; i < M - 1; i++) {
				negative.poll();
				
				if(negative.isEmpty()) break;
			}
			
			result += temp * 2;
		}
		
		result -= dist;
		System.out.println(result);
	}
}
