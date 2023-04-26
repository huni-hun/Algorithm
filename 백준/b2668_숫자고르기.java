package algo230426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class b2668_숫자고르기 {
	static int N, result = 0;
	static int map[];
	static List<Integer> answer;
	static boolean visit[];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
//		answer = new ArrayList<Integer>();
//		for(int i = 1; i <= N; i++) {
//			visit[i] = true;
//			dfs(i, i);
//			visit[i] = false;
//		}
		
		for(int i = 1; i <= N; i++) {
			pq = new PriorityQueue<>();
			if(!visit[i]) {
				if(!dfs(i, i, 1)) {
					for(int k : pq) {
						visit[k] = false;
					}
				}
			}
		}
		
		System.out.println(result);
		for(int i = 0; i < N; i++) {
			if(visit[i]) System.out.println(i);
		}
//		Collections.sort(answer);
//		System.out.println(answer.size());
//		for(int i : answer) {
//			System.out.println(i);
//		}
	} // main

	public static boolean dfs(int start, int idx, int cnt) {
		pq.offer(idx);
		visit[idx] = true;
		
		int nextIdx = map[idx];
		if(start == nextIdx) {
			result += cnt;
			return true;
		}
		
		if(!visit[nextIdx]) {
			return dfs(start, nextIdx, cnt+1);
		}
		
		return false;
	}
	
//	public static void dfs(int start, int end) {
//		if(!visit[map[start]]) {
//			visit[map[start]] = true;
//			dfs(map[start], end);
//			visit[map[start]] = false;
//		}
//		
//		if(map[start] == end) {
//			answer.add(end);
//		}
//	}
}
