package giseon.m08.programmers;

import java.util.*;

// 0.02ms, 82.3MB
class 올바른괄호 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        // stack이 비어있으면 넣으셈
        // 비어있지 않다면 짝 비교
        // peek()가 '(' 일때 ')'를 만나면 pop
        // 스택이 비어있다면 true, 비어있지 않다면 false

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
