import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for(int i = 0; i <numbers.length; i++){
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
			    return (o2+o1).compareTo(o1+o2);                   
			}	
		});
        
        if(nums[0].equals("0")) return "0";
        
        for(int i = 0; i < numbers.length; i++){
            answer += nums[i];
        }
        
        return answer;
    }
}