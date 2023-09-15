import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        if(topping.length == 1) return answer;
        
        HashSet<Integer> s = new HashSet<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            m.put(topping[i], m.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            s.add(topping[i]);
            m.put(topping[i], m.get(topping[i]) - 1);
            if(m.get(topping[i]) == 0) m.remove(topping[i]);
            
            if(s.size() == m.size()) answer++;
        }
        
        return answer;
    }
}