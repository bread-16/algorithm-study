package bomin.m08.programmers;

import java.util.Stack;

public class 올바른괄호 {
	    boolean solution(String s) {
	        boolean answer = true;
	        Stack<Character> stack = new Stack<>();
	        
	        for(char x : s.toCharArray()){
	            if(x == '('){
	                stack.push(x);
	            }
	            else{
	                if(stack.isEmpty()){
	                    answer = false;
	                    return answer;
	                }
	                stack.pop();
	            }
	        }
	        if(!stack.isEmpty())
	            answer = false;
	        
	        
	        return answer;
	    }
	
}
