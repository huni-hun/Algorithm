import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] maps) {
        char map[][] = new char[maps.length][maps[0].length()];
        boolean visit[][][] = new boolean[maps.length][maps[0].length()][2];
        int start_x = 0;
        int start_y = 0;
        
        for(int i = 0; i < maps.length; i++) {
            String line = maps[i];
            
            for(int j = 0; j < maps[i].length(); j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if(c == 'S') {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        
        return bfs(map, visit, start_x, start_y);
    }
    
    public static int bfs(char[][] map, boolean[][][] visit, int x, int y) {
        Queue<Pos> queue = new LinkedList<Pos>();
        queue.add(new Pos(x, y, 0, false));
        
        visit[x][y][0] = true;
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            
            if(now.lever && map[now.x][now.y] == 'E') {
                return now.cnt;
            }
            
            //lever on
            if(now.lever) {
                for(int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visit[nx][ny][1]) {
                        if(map[nx][ny] != 'X') {
                            visit[nx][ny][1] = true;

                            if(!now.lever) {
                                if(map[nx][ny] == 'L') {
                                    queue.add(new Pos(nx, ny, now.cnt+1, true));
                                    continue;
                                    }    
                                }
                            queue.add(new Pos(nx, ny, now.cnt+1, now.lever));                            
                        }
                    }
                }
            //lever off
            } else {
                for(int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visit[nx][ny][0]) {
                        if(map[nx][ny] != 'X') {
                            visit[nx][ny][0] = true;
                
                            if(map[nx][ny] == 'L') {
                                queue.add(new Pos(nx, ny, now.cnt+1, true));
                                continue;
                            }    
                            
                            queue.add(new Pos(nx, ny, now.cnt+1, now.lever));                            
                        }
                    }
                }
            }
            
            
        }
        
        return -1;
    }
    
    public static class Pos {
        int x, y;
        int cnt;
        boolean lever;
        
        public Pos(int x, int y, int cnt, boolean lever) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.lever = lever;
        }
    }
}
