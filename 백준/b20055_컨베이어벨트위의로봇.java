package algo231027;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class b20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N*2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N*2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] robot = new boolean[N];
		int cnt=0;
		int result = 0;
		while(K > cnt) {
			arr = firstStep(N, arr);
			for (int i = N-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = robot[N-1] = false;
			
			for (int i = N-1; i > 0; i--) {
				if(robot[i-1] && !robot[i] && arr[i] > 0) {
					robot[i] = true;
					robot[i-1] = false;
					arr[i]--;
				}
			}
			
			if(arr[0] > 0) {
				robot[0] = true;
				arr[0]--;
			}
			
			cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0) cnt++;
			}
			
			result++;
		}
		
		System.out.println(result);
	}
	
	public static int[] firstStep(int N, int[] arr) {
		int temp = arr[N*2-1];
		
		for (int i = N*2-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		
		return arr;
	}
}
