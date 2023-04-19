import java.util.*;

class Solution {
    static int result = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean flag = false;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(target)) flag = true;
        }
        if(!flag) return 0;
        
        bfs(begin, target, words);
        
        answer = result;
        return answer;
    }
    
    static void bfs(String start, String target, String[] words) {
        Queue<Word> queue = new LinkedList<>();
        queue.add(new Word(start, 0));
        
        while(!queue.isEmpty()) {
            Word now = queue.poll();
            if(now.word.equals(target)) {
                result = Math.min(result, now.cnt);
                return;
            }
            
            for(int i = 0; i < words.length; i++) {
                int cnt = 0;
                int temp = 0;
                char change = ' ';
                for(int j = 0; j < target.length(); j++){
                    if(now.word.charAt(j) == words[i].charAt(j)){
                        cnt++;
                    }else{
                        temp = j;
                        change = words[i].charAt(j);
                    }
                    if(cnt == target.length() - 1) {
                        StringBuilder sb = new StringBuilder(now.word);
                        sb.setCharAt(temp, change);
                        queue.add(new Word(sb.toString(), now.cnt+1));
                    }
                }
            }
        } //end while
    } 
                                  
    
    static class Word{
        String word;
        int cnt;
        
        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}