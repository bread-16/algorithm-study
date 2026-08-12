package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

// 0.03ms, 75.6MB O(N!)
public class 단어_변환 {
	
	public String begin;
	public String target;
	public String[] words;
	public int answer;
	public boolean[] visited;
	
	public boolean canChange(String curWord, String nextWord) {
		int diff =0;
		for(int i=0 ; i<curWord.length() ; i++) {
			if(curWord.charAt(i) != nextWord.charAt(i)) {
				diff++;
				if(diff > 1) return false;
			}
		}
		return diff==1;
	}
	
	public int solution(String begin, String target, String[] words) {
		this.begin = begin;
		this.target = target;
		this.words = words;
        this.answer = Integer.MAX_VALUE;
        this.visited = new boolean[words.length];
        
        dfs(begin,0);
        
        return (answer==Integer.MAX_VALUE) ? 0 : answer;
    }
	
	public void dfs(String word, int depth) {
		// 만약 원하는 단어가 나오면 반환
		if(word.equals(target)) {
			answer = Math.min(answer, depth);
			return;
		}
		
		if(depth >= answer) return;
		
		for(int i=0 ; i< words.length ; i++) {
			if(visited[i] || !canChange(word, words[i])) continue;
			
			visited[i] = true;
			dfs(words[i], depth+1);
			visited[i] = false;
		}
		
	}
	
}
