import java.util.*;
import java.io.*;

class Solution {
    static int[] arr;
    static boolean[] visit;
    static int answer;
    static boolean[] prime;
    
    public int solution(String numbers) {
        answer = 0;
        
        int len = numbers.length();
        arr = new int[len];
        visit = new boolean[len];
        for(int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        
        prime = new boolean[10000000];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2; i < 10000000; i++){
            if(prime[i]) continue;
            
            for(int j = i * 2; j < 10000000; j += i) {
                if(prime[j]) continue;
                prime[j] = true;
            }
        }

        purmutation("");
        return answer;
    }
    
    static void purmutation(String num) {
        if(num.length() != 0) {

            int n = Integer.parseInt(num);
            
            if(num.charAt(0) == '0') return;
            if(!prime[n]){
                prime[n] = true;
                answer++;   
            }
        }
        
        if(num.length() == arr.length) return;
        
        for(int i = 0; i < arr.length; i++) {
            if(visit[i]) continue;
            
            visit[i] = true;
            purmutation(num + arr[i]);
            visit[i] = false;
        }
    }
}