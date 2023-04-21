import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        if(truck_weights.length == 1) return 101;
        Queue<Truck> queue = new LinkedList<>();
        queue.add(new Truck(1, truck_weights[0]));

        int cnt = 1; // 다리 위 버스 수
        int check = 1; // 배열에서 값을 꺼내기 위한 변수
        int totalWeight = truck_weights[0]; // 다리 위 총무게
        while(!queue.isEmpty()) {
            answer++;
            Truck now = queue.peek();
            if((answer - now.time) >= bridge_length) {  
                queue.poll();
                cnt--;
                totalWeight -= now.heavy;
            }
            
            if(check < truck_weights.length) {
                if(totalWeight + truck_weights[check] > weight) {
                    continue;
                }
            
                if(cnt >= bridge_length) {
                    continue;
                }
                
                queue.add(new Truck(answer, truck_weights[check]));
                totalWeight += truck_weights[check];
                check++;
                cnt++;
            }
        }
        
        return answer;
    }
    
    static class Truck {
        int time;
        int heavy;
        
        public Truck(int time, int heavy) {
            this.time = time;
            this.heavy = heavy;
        }
    }
}