import java.util.*;

class Solution {
    static int di[] = {-1, 0, 1, 0};
    static int dj[] = {0, 1, 0, -1};
    static int N;
    static int M;
    static char[][] island;
    static boolean[][] visit;
    static List<Integer> list = new LinkedList<>();
    
    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        island = new char[N][M];
        visit = new boolean[N][M];
            
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                island[i][j] = maps[i].charAt(j);    
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(island[i][j] != 'X' && !visit[i][j]) {
                    visit[i][j] = true;
                    list.add(dfs(i, j, island[i][j] - '0'));
                }
            }
        }
        
        if(list.size() != 0) {
            int[] answer = new int[list.size()];
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        } else {
            return new int[] {-1};
        }
        
    }
    
    public static int dfs (int x, int y, int sum) {
        for(int k = 0; k < 4; k++) {
            int nx = x + di[k];
            int ny = y + dj[k];
            
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && island[nx][ny] != 'X' && !visit[nx][ny]) {
                visit[nx][ny] = true;
                sum += dfs(nx, ny, island[nx][ny] - '0');
            }
        }
        
        return sum;
    }
}