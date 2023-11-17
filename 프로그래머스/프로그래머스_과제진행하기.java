import java.util.*;
import java.io.*;

class Solution {
    public List<String> solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        
        Arrays.sort(plans, new Comparator<String[]>() {
            
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        
        Queue<Task> queue = new LinkedList<>();
        for(String[] o : plans) {
            String t[] = o[1].split(":");
            int temp = (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
            queue.add(new Task(o[0], temp, Integer.parseInt(o[2])));
        }
        
        Stack<Task> stack = new Stack<>();
        while(!queue.isEmpty()) {
            Task now = queue.poll();
            
            int curTime = now.time;
            int runTime = now.runTime;
            if(!queue.isEmpty()){
                Task next = queue.peek();
                
                if(curTime + runTime < next.time) {
                    answer.add(now.name);
                    curTime += runTime;
                    
                    while(!stack.isEmpty()) {
                        
                        Task remain = stack.pop();
                        if(curTime + remain.runTime <= next.time) {
                            curTime += remain.runTime;
                            answer.add(remain.name);
                            continue;
                        } else {
                            int t = remain.runTime - (next.time - curTime);
                            
                            stack.add(new Task(remain.name, remain.time, t));
                            break;
                        }
                    }
                } else if(curTime + runTime == queue.peek().time) {
                    answer.add(now.name);
                    continue;
                } else {
                    stack.add(new Task(now.name, curTime, runTime - (next.time - curTime)));
                }    
            } else {
                answer.add(now.name);
                    
                while(!stack.isEmpty()) answer.add(stack.pop().name);   
            }   
        }
        
        return answer;
    }
    
    static public class Task {
        String name;
        int time;
        int runTime;
        
        public Task(String name, int time, int runTime) {
            this.name = name;
            this.time = time;
            this.runTime = runTime;
        }
    }
}