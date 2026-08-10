package ohyeon.m08.programmers;
import java.util.*;
public class ValidParentheses {
	boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deque = new ArrayDeque<>();
        for(char parentheses:s.toCharArray()) {
            if(parentheses == '(') {
                deque.offerLast(parentheses);
            } else {
                if(deque.isEmpty()) {
                    answer = false;
                } else {
                    deque.pollLast();
                }
            }
        }
        if(!deque.isEmpty()) {
                answer = false;
            }
        return answer;
    }
}
