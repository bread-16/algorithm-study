package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

class 올바른_괄호 {
	boolean solution(String s) {
		boolean answer = true;

		Deque<Character> st = new ArrayDeque<>();

		for (int i = 0; i < s.length(); i++) {
			if (st.isEmpty() && s.charAt(i) == ')')
				return false;
			if (s.charAt(i) == '(')
				st.push(s.charAt(i));
			if (!(st.isEmpty()) && s.charAt(i) == ')') {
				st.pop();
			}
		}
		return st.isEmpty();
	}
}
