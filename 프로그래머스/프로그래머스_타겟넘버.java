package algo230315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프로그래머스_타겟넘버 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[st.countTokens()];
		int cnt = 0;
		while(st.hasMoreTokens()) {
			nums[cnt] = Integer.parseInt(st.nextToken());
			cnt++;
		}
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(solution(nums, target));
	}
	
    static int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Count> queue = new LinkedList<Count>();
        queue.add(new Count(numbers[0], 0));
        queue.add(new Count(-numbers[0], 0));
        
        int lv = 1;
        while(!queue.isEmpty()) {
        	Count now = queue.poll();
        	if(now.cnt == lv) lv++;
        	if(now.cnt == numbers.length -1) {
        		if(now.num == target) answer++;
        		
        		continue;
        	}
        	
        	if(lv < numbers.length) {
        		queue.add(new Count(now.num + numbers[lv], now.cnt+1));
        		queue.add(new Count(now.num - numbers[lv], now.cnt+1));
        	}
        }
        
        return answer;
    }
    
    static class Count {
    	int num;
    	int cnt;
    	
    	public Count(int num, int cnt) {
    		this.num = num;
    		this.cnt = cnt;
		}
    }
    
}
