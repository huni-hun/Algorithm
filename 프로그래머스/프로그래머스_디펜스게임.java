import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);
            
            if(k < pq.size()) {
                n -= pq.poll();
            }
            
            if(n < 0) {
                answer = i;  
                break;
            } 
        }
        
        return answer;
    }
}

// class Solution {
//     public int len;
//     public int K;
//     public int[] Enemy;
//     public int answer = 0;

//     public int solution(int n, int k, int[] enemy) {
//         len = enemy.length;
//         Enemy = enemy;
//         K = k;

//         if(len <= k){
//             return enemy.length;
//         }

//         dfs(n, 0, 0, "");

//         return answer;
//     }

//     public void dfs(int n, int depth, int idx, String str){
//         // 종료 조건
//         if(n <= 0 || depth == K){
//             if(n <= 0){
//                 idx--;
//             } 
//             answer = Math.max(answer, idx);
//             return;
//         }

//         if(idx >= len){
//             return;
//         }

//         // 선택했을 때
//         dfs(n, depth + 1, idx+1,str+String.valueOf(idx));

//         // 선택하지 않았을 때
//         dfs(n - Enemy[idx], depth, idx + 1, str);
//     }
// }