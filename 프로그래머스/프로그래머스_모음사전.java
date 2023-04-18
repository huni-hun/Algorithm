class Solution {
    static String[] alpha = {"A", "E", "I", "O", "U"};
    static int result = -1;
    static int answer;
    public int solution(String word) {
        answer = 0;
        
        purmutation("", word);
        return answer;
    }
    
    static void purmutation(String line, String word) {
        if(line.length() > 5) return;

        result++;
        if(line.equals(word)) {
            answer = result;
        }
        
        for(int i = 0; i < 5; i++) {
            purmutation(line + alpha[i], word);
        }
    }
}