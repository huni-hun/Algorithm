import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        Queue<Work> pq = new PriorityQueue<>();

        int idx = 0;
        int t = 0;
        while(idx < jobs.length || !pq.isEmpty()) {
            while(idx < jobs.length && jobs[idx][0] <= t) {
                pq.add(new Work(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()){
                t++;
                continue;
            }
            
            Work now = pq.poll();
            t += now.time;
            answer += t - now.order;
        }
        
        answer /= jobs.length;
        return answer;
    }
    
    public static class Work implements Comparable<Work> {
        int order;
        int time;
            
        public Work(int order, int time) {
            this.order = order;
            this.time = time;
        }
        
        @Override
        public int compareTo(Work work) {
            
            if(work.time == this.time) return this.order - work.order;
            return this.time - work.time;
        }
    }
}