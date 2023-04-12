import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int cnt = 1;
        Loop : for(int i = 0; i < citations.length; i++) {
            int check = 0;
            
            for(int j = 0; j < citations.length; j++){
                if(citations[j] >= cnt){
                    check++;
                }
                if(cnt == check) {
                    answer = Math.max(answer, cnt);
                    cnt++;
                    continue Loop;
                }
            }
            
            break;
        }
        
        return answer;
    }
}