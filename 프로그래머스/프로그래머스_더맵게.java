import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(pq.peek() < K) {
            if(pq.size() == 1) {
                if(pq.peek() < K) return -1;
                else return answer;
            }
            int newScoville = 0;
            int n = pq.poll();
            if(n == 0) {
                if(pq.peek() == 0) {
                    answer = -1;
                    break;
                }else {
                    newScoville += pq.poll() * 2;
                }
            }else {
                newScoville = n + pq.poll() * 2;   
            }
            pq.add(newScoville);
            answer++;
        }
        
        return answer;
    }
}