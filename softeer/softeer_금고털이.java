package algo230216;

import java.util.*;
import java.io.*;

public class soft_금고털이 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int price[][] = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){    
                price[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(price, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        int temp = 0;
        int result = 0;
        for(int i = 0; i < N; i++){
            temp = W - price[i][0];
            if(temp <= 0) {
                result += (W * price[i][1]);
                break;
            }
            W = temp;
            result += (price[i][0] * price[i][1]); 
        }

        System.out.println(result);
	}
}
