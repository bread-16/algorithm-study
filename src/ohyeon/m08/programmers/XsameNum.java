package ohyeon.m08.programmers;

import java.util.*;

public class XsameNum {
	public int[] solution(int []arr) {
        Deque <Integer> deque = new ArrayDeque<>();
        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.offerLast(num);
            }
        }
        int[] answer = new int[deque.size()];
        for ( int idx = 0; idx<answer.length; idx++) {
            answer[idx] = deque.pollFirst();
        }
        
        return answer;
    }
}
