package algo231124;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1092_배 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer crains[] = new Integer[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crains[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		st= new StringTokenizer(br.readLine());
		List<Integer> boxes = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(boxes, Collections.reverseOrder());
		Arrays.sort(crains, Collections.reverseOrder());
		if(crains[0] < boxes.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int result = 0;
		while(!boxes.isEmpty()) {
			
			int idx = 0;
			for (int i = 0; i < crains.length; i++) {
				if(idx == boxes.size()) break;
				if(crains[i] >= boxes.get(idx)) {
					boxes.remove(idx);
				} else {
					i--;
					idx++;
				}
			}
			result++;
		}
		
		System.out.println(result);
	}
}
