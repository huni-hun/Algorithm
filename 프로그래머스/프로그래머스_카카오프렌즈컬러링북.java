import java.util.*;

class Solution {
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};
    static boolean visit[][];
    static int max;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visit = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    visit[i][j] = true;
                    numberOfArea++;
                    max = 1;
                    dfs(m, n, i, j, picture, picture[i][j]);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
                }
            }
        }    
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static void dfs(int m, int n, int x, int y, int[][] map, int color) {     
        for(int k = 0; k < 4; k++) {
            int dx = x + di[k];
            int dy = y + dj[k];
            
            if(dx >= 0 && dy >= 0 && dx < m 
               && dy < n && visit[dx][dy] == false && map[dx][dy] == color) {
                visit[dx][dy] = true;
                max++;
                dfs(m, n, dx, dy, map, color);
            }
        }
    }
}