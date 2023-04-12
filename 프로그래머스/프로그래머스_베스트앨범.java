import java.util.*;
import java.io.*;

class Solution {
    static List<Integer> result = new ArrayList<>();
    static List<Music> musicList = new ArrayList<>();
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(genres[i], plays[i], i));
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list , Collections.reverseOrder());
        Collections.sort(musicList, new Comparator<Music>() {
            
            @Override
            public int compare(Music o1, Music o2) {
                
                if(o2.play - o1.play == 0){
                    return o1.num - o2.num;
                }
                return o2.play - o1.play;
            }
        });
        
        for(int i = 0; i < list.size(); i++){
            for(String key : map.keySet()){
                if(map.get(key) == list.get(i)){
                    solve(key);
                }
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    static void solve(String key){
        int cnt = 0;
        for(int i = 0; i < musicList.size(); i++){
            if(cnt == 2) return;
            if(musicList.get(i).genre.equals(key)){
                result.add(musicList.get(i).num);
                cnt++;
            }else{
                continue;
            }
        }
    }
    
    static class Music {
        String genre;
        int play;
        int num;
        
        public Music(String genre, int play, int num){
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
    }
}