package jaewon.m08.programmers;

import java.util.*;

public class Programmers12906 {

	public int[] solution(int[] arr) {
        Deque<Integer> dq = new ArrayDeque<>();

        for (int num : arr) {
            if (dq.isEmpty() || dq.peekLast() != num) {
                dq.addLast(num);
            }
        }

        int[] answer = new int[dq.size()];
        int idx = 0;
        for (int num : dq) { 
            answer[idx++] = num;
        }
        return answer;
    }
}
