package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        
	        Deque<Character> parentheses = new ArrayDeque<>();
	        
	        for(int i=0; i<s.length(); i++) {
	        	if(s.charAt(i) == '(') {
	        		parentheses.addLast(s.charAt(i));
	        	} else {
	        		if(parentheses.isEmpty()) {
	        			answer = false;
	        			break;
	        		} else {
	        			parentheses.removeLast();
	        		}
	        		
	        	}
	        }
	        
	        if(!parentheses.isEmpty()) answer = false; 
	        

	        return answer;
	    }
	}
	
}
