package algo230313;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11728_배열합치기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N + M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = N; i < N+M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < arr.length; i++) {
			bw.append(arr[i] + " ");
		}
		bw.flush();

//		int arrA[] = new int[N];
//		int arrB[] = new int[M];
//		
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < N; i++) {
//			arrA[i] = Integer.parseInt(st.nextToken());
//		}
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < M; i++) {
//			arrB[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Arrays.sort(arrA);
//		Arrays.sort(arrB);
//		
//		int A = 0;
//		int B = 0;
//		int k = 0;
//		int result[] = new int[N+M];
//		while(A < N && B < M) {
//			if(arrA[A] > arrB[B]) {
//				result[k++] = arrB[B++];
//			}else {
//				result[k++] = arrA[A++];
//			}
//		}
//		
//		while(N > A) {
//			result[k++] = arrA[A++];
//		}
//
//		while(M > B) {
//			result[k++] = arrB[B++];
//		}
//		
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		for (int i = 0; i < result.length; i++) {
//			bw.append(result[i] + " ");
//		}
//		bw.flush();
	}
}
