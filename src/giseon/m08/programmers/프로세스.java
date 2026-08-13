package giseon.m08.programmers;

import java.util.*;

// 0.47ms, 90.4MB
class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int prior = 0;

        // queue에 우선순위와 위치를 함께 넣어준다.
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[] { priorities[i], i });
        }

        // queue에서 프로세스 할당 규칙에 따라 꺼내면서 확인한다.
        while (true) {
            // 1. 맨 앞 프로세스 꺼내기
            int[] proc = q.poll();
            boolean hasHigher = false;
            // 2. 현재 큐에 더 높은 우선순위가 존재하는 지 확인
            for (int[] p : q) {
                if (proc[0] < p[0]) {
                    hasHigher = true;
                    break;
                }
            }
            // 3-1 존재한다면 꺼내서 뒤로 보냄
            if (hasHigher) {
                q.offer(proc);
            } else {
                // 3-2 존재하지 않는다면 실행(answer++)
                answer++;
                // 4. 실행한 프로세스의 원래 위치 == location이면 루프 종료
                if (proc[1] == location) {
                    break;
                }
            }
        }

        return answer;
    }
}
