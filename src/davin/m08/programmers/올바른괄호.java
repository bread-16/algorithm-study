package davin.m08.programmers;
import java.util.*;

public class 올바른괄호 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        //int n = s.length();
        for(char c : s.toCharArray()){
            if (c=='(') stack.push(c);
            else if (c==')' && stack.isEmpty()) return false;
            else if (c==')' && stack.peek() =='(') stack.pop();
        }
        
        if(stack.isEmpty()) return true;

        return false;
    }
}
