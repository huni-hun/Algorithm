import java.util.*;

class Solution {
    static List<String> list;
    static boolean visit[];
    static boolean flag = false;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        Arrays.sort(tickets, new Comparator<String[]>() {
            
            @Override
            public int compare(String[] o1, String[] o2) {
                
                if(o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);   
                }else{
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        
        for(int i = 0; i < tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                list = new ArrayList<>();
                list.add("ICN");
                visit = new boolean[tickets.length];
                dfs(tickets, tickets[i][0], 0);
                break;
            }
        }
        
        return answer;
    }
    
    static void dfs(String[][] tickets, String port, int cnt) {
        if(flag) return;
        
        if(cnt == tickets.length) {
            answer = new String[list.size()];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            flag = true;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(visit[i]) continue;
            
            if(port.equals(tickets[i][0])) {
                visit[i] = true;
                list.add(tickets[i][1]);
                dfs(tickets, tickets[i][1], cnt + 1);
                visit[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}