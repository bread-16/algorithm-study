package dana.m08.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Programmers12909 {
	
    // hashmap dictionary 
    Map<Character, Character> dictionary = new HashMap<>();
    
    // stack 
    Stack<Character> stack = new Stack<>(); 

    boolean solution(String s) {
        
        dictionary.put('(', ')');
        
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i); 
            
            // stack 아무것도 없으면 추가 
            if (stack.isEmpty()) {
                stack.push(currChar); 
            // 키이고 현재 캐릭터와 짝이면 stack에서 빼기  
            } else if (dictionary.containsKey(stack.peek()) 
                    && dictionary.get(stack.peek()) == currChar) {
                    stack.pop(); 
            }
            // 키도 아니고 짝도 아니면 추가 
            else {
                stack.push(currChar); 
            }
        }
        
        // 마지막에 스텍이 아무것도 없으면 true. 있으면 false. 
        if (stack.isEmpty()) {
            return true; 
        } else {
            return false; 
        }
    }

}
