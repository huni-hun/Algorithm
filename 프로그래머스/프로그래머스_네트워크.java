package algo230320;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_네트워크 {
	static ArrayList<ArrayList<Integer>> list;
	static boolean visit[];
	
	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0,1}};
		
		System.out.println(solution(3, computers));
	}
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList<>();
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	list.add(new ArrayList<>());
		}
        
        for (int i = 0; i < n; i++) {
			
        	for (int j = 0; j < n; j++) {
				list.get(i).add(computers[i][j]);
			}
		}
        
        for (int i = 0; i < n; i++) {
			if(visit[i] == false) {
				answer++;
				visit[i] = true;
				
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(i);
				while(!queue.isEmpty()) {
					int now = queue.poll();
					
					for (int j = 0; j < list.get(now).size(); j++) {
						if(list.get(now).get(j) == 1 && visit[j] == false) {
							visit[j] = true;
							queue.add(j);
						}
						
					}
					
				} // end while
				
			}
		}
        
        return answer;
    }
}
