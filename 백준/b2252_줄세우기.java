package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			arr[front]++;
			
			list.get(back).add(front);
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < N+1; i++) {
			if(arr[i] == 0) queue.add(i);
		}
		
		List<Integer> result = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			int next = queue.poll();
			result.add(next);
			
			List<Integer> temp = list.get(next);
			for(int num : temp) {
				arr[num]--;
				
				if(arr[num] == 0) {
					queue.add(num);
				}
			}
		}
		
		for (int i = N; i > 0; i--) {
			System.out.print(result.get(i) + " ");
		}
		
	}
	
}
