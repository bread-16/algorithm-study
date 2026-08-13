package ohyeon.m08.programmers;

import java.util.*;

public class WordChange {
	String begin;
    String target;
    String[] words;
    boolean[] visited;
    int answer;
    public int solution(String begin, String target, String[] words) {
        this.begin = begin;
        this.target = target;
        this.words = words;
        visited = new boolean[words.length];
        boolean isExist = false;
        for(int i = 0; i < words.length; i++) {
            if (target.equals(words[i])){
                isExist = true;
                break;
            }
        }
        if (!isExist) return 0;
        
        Deque<String>dq = new ArrayDeque<>();
        dq.offer(begin);
        answer = 0;
        
        while (!dq.isEmpty()){
            int size = dq.size();
            
            for(int i = 0; i < size; i++){
                String current = dq.poll();
                
                if(current.equals(target)){
                    return answer;
                }
                
                for (int j = 0; j < words.length; j++){
                    if(!visited[j] && isCheckChange(current, words[j])) {
                        visited[j] = true;
                        dq.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    boolean isCheckChange(String nowWord, String nextWord){
        int cnt = 0;
        for(int i = 0; i < nowWord.length(); i++) {
            if (nowWord.charAt(i)==nextWord.charAt(i)) {
                cnt++;
            }
        }
        if (cnt==nowWord.length()-1) {
            return true;
        } else {
            return false;
        }
    }
}
