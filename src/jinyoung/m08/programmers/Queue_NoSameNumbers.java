package jinyoung.m08.programmers;
import java.util.*;
public class Queue_NoSameNumbers {
    public int[] solution(int []arr) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++) {
            if(!deque.isEmpty()) {
                if(deque.peekLast()==arr[i]) {
                    continue;
                }
            }
            deque.addLast(arr[i]);
        }
        int[] answer = new int[deque.size()];
        int idx=0;
        while(!deque.isEmpty()) {
            answer[idx++]=deque.pollFirst();
        }
        return answer;
    }
}