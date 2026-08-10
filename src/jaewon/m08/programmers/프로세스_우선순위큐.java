package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class 프로세스_우선순위큐 {
    public int solution(int[] priorities, int location) {
        Deque<Integer> q = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.offer(i);              // 대기 큐에는 인덱스만
            maxHeap.offer(priorities[i]); // 힙에는 우선순위 값만
        }

        int count = 0;
        while (!q.isEmpty()) {
            int idx = q.poll();

            // 남은 프로세스 중 최댓값보다 낮으면 실행 자격이 없으므로 뒤로
            if (priorities[idx] < maxHeap.peek()) {
                q.offer(idx);
                continue;
            }

            maxHeap.poll(); // 실행 확정 → 후보 집합에서 제거
            count++;
            if (idx == location) {
                return count;
            }
        }
        return 0;
    }
}
