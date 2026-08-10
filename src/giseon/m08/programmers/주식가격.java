package giseon.m08.programmers;

// 0.04ms, 82.9MB
import java.util.*;

class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> q = new ArrayDeque<>();

        for (int p : prices) {
            q.offer(p);
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int count = 0;
            int p = q.poll();
            for (int price : q) {
                if (p <= price) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[idx++] = count;
        }
        return answer;
    }
}
