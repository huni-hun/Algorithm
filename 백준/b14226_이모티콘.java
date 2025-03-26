package codingStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b14226_이모티콘 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(bfs(target));
	}
	
	public static int bfs(int target) {
		int result = 0;
		
		Queue<Emoji> queue = new LinkedList<Emoji>();
		queue.add(new Emoji(1, 0, 0));
		
		boolean[][] visit = new boolean[1001][1001];
		visit[0][0] = true;
		while(!queue.isEmpty()) {
			Emoji now = queue.poll();
			
			if(now.cnt == target) {
				result = now.sec;
				break;
			}
			
			
			// 클립보드 저장
			if(!visit[now.cnt][now.clipboard]) {
				queue.add(new Emoji(now.cnt, now.sec + 1, now.cnt));
				visit[now.cnt][now.cnt] = true;
			}

			// 클립보드에 이모티콘 화면에 붙여넣기
			if(now.clipboard > 0 && now.cnt + now.clipboard < 1001 && !visit[now.cnt + now.clipboard][now.clipboard]) {
				queue.add(new Emoji(now.cnt + now.clipboard, now.sec + 1, now.clipboard));
				visit[now.cnt + now.clipboard][now.cnt] = true;
			}
			
			// 화면에 있는 이모티콘 중 하나를 삭제
			if(now.cnt > 0 && !visit[now.cnt - 1][now.clipboard]) {
				queue.add(new Emoji(now.cnt - 1, now.sec + 1, now.clipboard));
				visit[now.cnt - 1][now.cnt] = true;
			}
			
		}
		
		
		return result;
	}
	
	public static class Emoji {
		int cnt;
		int sec;
		int clipboard;
		
		public Emoji(int cnt, int sec, int clipboard) {
			this.cnt = cnt;
			this.sec = sec;
			this.clipboard = clipboard;
		}
	}
}
