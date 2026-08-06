package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
    	// queue에 {인덱스 번호, 우선순위}를 넣음
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }

        int count = 0;
        while (!q.isEmpty()) {
        	// queue에 맨 앞 프로세스를 꺼냄
            int[] cur = q.poll();
            int index = cur[0]; // 맨 앞 프로세스의 인덱스
            int priority = cur[1]; // 맨 앞 프로세스의 우선순위

            boolean higher = false;
            for (int[] x : q) {
            	// 남아있는 프로세스 중 현재 프로세스의 우선순위 보다 높으면 현재 프로세스를 다시 queue에 넣어야함
                if (x[1] > priority) {
                    higher = true;      
                    break;              
                }
            }
            // 현재 프로세스를 다시 queue에 넣음
            if (higher) {               
                q.offer(cur);           
                continue;               
            }
            // 현재 프로세스를 실행. count++
            count++;
            if (index == location) {
                return count;
            }
        }
        return 0;
    }
}