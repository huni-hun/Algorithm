import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
            
        answer++;
        int end = targets[0][1];
        for(int[] target : targets) {
            if(target[0] >= end) {
                answer++;
                end = target[1];
            }
            // System.out.println(target[0] + " " + target[1]);
        }
        return answer;
    }
}