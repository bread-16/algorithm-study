package jaewon.m08.programmers;

import java.util.*;

public class Programmers12906 {

	public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int num : arr) {
            if (stack.isEmpty() || stack.peekLast() != num) {
                stack.addLast(num);
            }
        }

        int[] answer = new int[stack.size()];
        int idx = 0;
        for (int num : stack) { 
            answer[idx++] = num;
        }
        return answer;
    }
}
