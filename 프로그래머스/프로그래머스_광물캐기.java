import java.util.*;
import java.io.*;

class Solution {
    static int answer;
    static boolean dia[];
    static boolean iron[];
    static boolean stone[];
    
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        
        dia = new boolean[picks[0]];
        iron = new boolean[picks[1]];
        stone = new boolean[picks[2]];
        
        int sum = picks[0] + picks[1] + picks[2];
        dfs(minerals, sum, 0, 0, 0);
        
        return answer;
    }
    
    public static void dfs(String[] minerals, int N, int fatigue, int idx, int cnt) {
        if(fatigue >= answer) return;
        if(idx >= minerals.length || cnt == N) {
            answer = Math.min(answer, fatigue);
        }
        
        for(int i = 0; i < dia.length; i++) {
            if(dia[i]) continue;
            
            int temp = 5;
            if(idx + 5 >=  minerals.length) temp = minerals.length - idx;
            dia[i] = true;
            dfs(minerals, N, fatigue + temp, idx + temp, cnt + 1);
            dia[i] = false;
        }
        
        for(int i = 0; i < iron.length; i++) {
            if(iron[i]) continue;
            
            int tempFatigue = 0;
            int tempIdx = 5;
            
            for(int j = idx; j < idx + 5; j++) {
                if(j ==  minerals.length) {
                    tempIdx = minerals.length - idx;
                    break;
                }
                
                if(minerals[j].equals("diamond")) {
                    tempFatigue += 5;
                } else {
                    tempFatigue += 1;
                }    
            }
            iron[i] = true;
            dfs(minerals, N, fatigue + tempFatigue, idx + tempIdx, cnt + 1);               
            iron[i] = false;
        }
        
        for(int i = 0; i < stone.length; i++) {
            if(stone[i]) continue;
            
            int tempFatigue = 0;
            int tempIdx = 5;
            for(int j = idx; j < idx + 5; j++) {
                if(j ==  minerals.length) {
                    tempIdx = minerals.length - idx;
                    break;
                }
                
                if(minerals[j].equals("diamond")) {
                    tempFatigue += 25;
                } else if(minerals[j].equals("iron")) {
                    tempFatigue += 5;
                } else {
                    tempFatigue += 1;
                }   
            }
            
            stone[i] = true;
            dfs(minerals, N, fatigue + tempFatigue, idx + tempIdx, cnt + 1);   
            stone[i] = false;
        }
        
    }
}