package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b2310_어드벤처게임 {
    static Room[] rooms;
    static boolean[][] visited;
    static boolean reachable;
    static int N;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		while((N = Integer.parseInt(br.readLine())) != 0) {
            rooms = new Room[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Room room = new Room();
                room.type = st.nextToken().charAt(0);
                room.value = Integer.parseInt(st.nextToken());

                while (true) {
                    int door = Integer.parseInt(st.nextToken());
                    if (door == 0) break;
                    room.doors.add(door);
                }
                rooms[i] = room;
            }

            visited = new boolean[N + 1][1001];  
            reachable = false;

            dfs(1, 0);

            System.out.println(reachable ? "Yes" : "No");
        }
		
	}
	
    static void dfs(int curRoom, int money) {
        if (reachable) return; 

        Room room = rooms[curRoom];

        if (room.type == 'L') {
            money = Math.max(money, room.value);  
        } else if (room.type == 'T') {
            if (money < room.value) return;  
            money -= room.value;
        }

        if (visited[curRoom][money]) return;
        visited[curRoom][money] = true;

        if (curRoom == N) {
            reachable = true;
            return;
        }

        for (int next : room.doors) {
            dfs(next, money);
        }
    }
	
    static class Room {
        char type;
        int value;
        List<Integer> doors = new ArrayList<>();
    }
}
