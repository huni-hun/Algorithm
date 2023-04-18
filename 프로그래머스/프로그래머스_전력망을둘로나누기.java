import java.util.*;

class Solution {
    static List<ArrayList<Integer>> list;
    static int num1, num2;
    static boolean visit[];
    static boolean flag;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        for(int i = 1; i <= wires.length; i++) {
            list = new ArrayList<>();   
            visit = new boolean[n+1];
            int result = 0;
            
            for(int j = 0; j < n+1; j++) {
                list.add(new ArrayList<>());
            }
            
            for(int j = 0; j < wires.length; j++) {
                if(i-1 == j) continue;
                list.get(wires[j][0]).add(wires[j][1]); 
                list.get(wires[j][1]).add(wires[j][0]);   
            }
            
            num1 = 0;
            num2 = 0;
            flag = false;
            for(int j = 1; j <= n; j++) {
                if(visit[j]) continue;
                dfs(j);
                flag = true;
            }
            
            result = Math.abs(num1-num2);
            answer = Math.min(result, answer);
        } // end for i 
        
        return answer;
    }
    
    static void dfs(int value) {
        if(visit[value]) return;
        if(flag){
            num1++;
        }else{
            num2++;
        }
        
        visit[value] = true;
        for(int i = 0; i < list.get(value).size(); i++) {
            int num = list.get(value).get(i);
            if(visit[num]) continue;
            dfs(num);
        }
    }
}