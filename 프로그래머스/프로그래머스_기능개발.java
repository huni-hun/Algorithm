import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Func> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.add(new Func(progresses[i], i));
        }
        
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        int result = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            Func now = queue.peek();
            if(now.percent + (speeds[now.cnt] * cnt) >= 100){
                queue.poll();
                if(queue.size() == 0){
                    list.add(result + 1);
                    break;
                }
                result++;
                flag = true;
                continue;
            }else{
                cnt++;
                if(flag) {
                    list.add(result);
                    result = 0;
                    flag = false;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    
    static class Func {
        int percent;
        int cnt;
        
        public Func (int percent, int cnt) {
            this.percent = percent;
            this.cnt = cnt;
        }
    }
}