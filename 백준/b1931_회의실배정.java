package algo230323;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b1931_회의실배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] != o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
			}
		});
		
		int result = 1;
		int end = arr[0][1];
		for (int i = 1; i < N; i++) {
			if(arr[i][0] >= end) {
				result++;
				end = arr[i][1];
			}
		}
		
		System.out.println(result);
	}
}
