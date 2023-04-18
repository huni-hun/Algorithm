class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int num = brown + yellow;
        for(int i = 1; i <= num / 2; i++) {
            if(num % i != 0) continue;
            int fir = i;
            int sec = num / i;
            
            if(sec > fir) continue;
            if(fir < 3 || sec < 3) continue;
            
            int temp = (fir - 2) * (sec - 2);
            if(temp == yellow) {
                answer[0] = fir;
                answer[1] = sec;
                break;
            }
        }
        
        return answer;
    }
}