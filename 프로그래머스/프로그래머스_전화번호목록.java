package algo230403;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_전화번호목록 {
	
	public static void main(String[] args) throws Exception {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		System.out.println(solution(phone_book));
	}
	
    public static boolean solution(String[] phone_book) {
//    	Arrays.sort(phone_book);
//
//    	for (int i = 1; i < phone_book.length; i++) {
//			if(phone_book[i].startsWith(phone_book[i-1])) {
//				return false;
//			}
//		}
    	
    	Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) 
            map.put(phone_book[i], i);
        
        for (int i = 0; i < phone_book.length; i++) {
        	for (int j = 0; j < phone_book[i].length(); j++) {
        		if (map.containsKey(phone_book[i].substring(0, j)))
        			return false;
        	}
        }

        return true;
        
    }
}
