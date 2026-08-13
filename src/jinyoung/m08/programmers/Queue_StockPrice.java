package jinyoung.m08.programmers;
import java.util.*;

public class Queue_StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> result = new ArrayDeque<>();
        for(int i : prices) {
            deque.add(i);
        }
        while(!deque.isEmpty()) {
            int cnt=0;
            int current=deque.pollFirst();
            for(int i : deque) {
                cnt++;
                if(current<=i) {
                    continue;
                } else {
                    break;
                }
            }
            result.addLast(cnt);
        }
        int n=result.size();
        answer = new int[n];
        for(int i=0;i<n;i++) {
            answer[i]=result.pollFirst();
        }
        return answer;
    }
}