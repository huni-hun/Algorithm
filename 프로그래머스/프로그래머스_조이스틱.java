import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int len = name.length();
        int move = len - 1;
        for(int i = 0; i < len; i++) {
            int num = Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            answer += num;
            
            if(i + 1 < len-1 && name.charAt(i+1) == 'A') {
                int idx = i + 1;
                
                while(idx < len && name.charAt(idx) == 'A') idx++;
                
                move = Math.min(move, i * 2 + len - idx);
                move = Math.min(move, i + (len - idx) * 2);
            }
        }
        
        answer += move;
        return answer;
    }
   
}