import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> temp = new PriorityQueue<>();
        
        for(int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String oper = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(oper.equals("I")) {
                pq.add(num);
                temp.add(num);
            } else {
                int size = pq.size();
                if(size == 0) continue;
                
                if(num == 1) {
                    temp.remove(pq.poll());
                } else {
                    pq.remove(temp.poll());
                }
            }
        } // end for
        
        if(pq.size() != 0) {
            int first = pq.poll();
            answer[0] = first;
            
            int size = pq.size();
            if(size == 0) answer[1] = first;
            else {
                for(int i = 0; i < size - 1; i++) pq.poll();
            }
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}