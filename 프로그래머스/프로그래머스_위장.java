package algo230404;

import java.util.HashMap;
import java.util.Map;

public class 프로그래머스_위장 {
	
	public static void main(String[] args) throws Exception {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++){
        	if(map.containsKey(clothes[i][1])) {
        		map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        	}else {
        		map.put(clothes[i][1], 1);
        	}
        }
        
        answer = 1;
        for (String str : map.keySet()) {
			answer *= (map.get(str) + 1);
		}
        
        return answer - 1;
    }
}
