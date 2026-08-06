package jinwoo.m08.programmers;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {
	
	char[] vowels = {'A', 'E', 'I', 'O', 'U'};
	
	int count = 0;
    int answer = 0;
    String target;
	
	public int solution(String word) {
		
		target = word;
		
		dfs("");
	
		return answer;
		
	}
	
	void dfs (String current) {
		
		if(current.equals(target)) {
			answer = count;
			return;
		}
		
		if(current.length() == 5) {
			return;
		}
		
		for(char v : vowels) {
			
			count++;
			
			dfs(current + v);
			
			if(answer != 0) {
				return;
			}
			
		}
		
	}
}
