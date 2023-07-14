import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
         Arrays.sort(book_time, new Comparator<String[]>() {
            
            @Override
            public int compare(String[] o1, String[] o2) {                
                if(o1[0].compareTo(o2[0]) == 0) {
                    return o1[1].compareTo(o2[1]);   
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        
        int[][] arr = new int[book_time.length][2];
        for(int i = 0; i < book_time.length; i++) {
            int n1 = Integer.parseInt(book_time[i][0].replace(":", ""));
            int n2 = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            arr[i][0] = n1;
            n2 += 10;
            if(n2 % 100 >= 60) {
                n2 += 100;
                n2 -= (n2 % 100);
                
                           
            }                    
            arr[i][1] = n2;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < book_time.length; i++) {
            if(pq.size() == 0) {
                pq.add(arr[0][1]);
                continue;
            }
            
            if(pq.peek() > arr[i][0]) {
                pq.add(arr[i][1]);
            } else {
                pq.poll();
                pq.add(arr[i][1]);
            }
        }
        
        return pq.size();
    }
}