import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();    
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            answer[stack.peek()] = len - stack.peek() - 1;  
            stack.pop();
        }
        
        // for(int i = 0; i < len; i++) {
        //     int day = 0;
        //     for(int j = i+1; j < len; j++) {
        //         if(i+1 == len) {
        //             break;
        //         }
        //         if(prices[i] <= prices[j]) {
        //             day++;
        //         }else{
        //             day++;
        //             break;
        //         }
        //     }
        //     answer[i] = day;
        // }
        
        return answer;
    }
}