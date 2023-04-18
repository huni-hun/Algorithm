import java.util.*;

class Solution {
    static int result = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        boolean visit[] = new boolean[dungeons.length];
        dfs(k, visit, dungeons, 0);
        
        answer = result;
        return answer;
    }
    
    static void dfs(int fatigue, boolean[] visit, int[][] dungeons, int cnt) {
        result = Math.max(result, cnt);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visit[i]) continue;
            if(fatigue < dungeons[i][0]) continue;
            
            visit[i] = true;
            dfs(fatigue - dungeons[i][1], visit, dungeons, cnt+1);
            visit[i] = false;
        }
    }
}