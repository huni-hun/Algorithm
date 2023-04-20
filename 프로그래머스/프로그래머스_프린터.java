import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Paper> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Paper(i, priorities[i]));
        }
        
        boolean visit[] = new boolean[priorities.length];
        int cnt = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            Paper now = queue.peek();
            
            flag = false;
            for(int i = 0; i < priorities.length; i++) {
                if(visit[i]) continue;
                if(now.importance < priorities[i]) {
                    queue.add(now);
                    queue.poll();
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            
            if(now.idx == location) {
                return ++cnt;
            }
            
            for(int i = 0; i < priorities.length; i++) {
                if(visit[i]) continue;
                if(priorities[i] == now.importance){
                    visit[i] = true;
                    break;
                }
            }
            queue.poll();
            cnt++;
        }
        
        return answer;
    }
    
    static class Paper {
        int idx;
        int importance;
        
        public Paper(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
}