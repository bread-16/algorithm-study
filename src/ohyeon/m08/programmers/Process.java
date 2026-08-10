package ohyeon.m08.programmers;

import java.util.*;

public class Process {
	public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        Arrays.sort(priorities);
        int maxIdx = priorities.length - 1;

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[1] == priorities[maxIdx]) {
                answer++;
                maxIdx--;
                
                if (current[0] == location) {
                    return answer;
                }
            } else {
                queue.offer(current);
            }
        }

        return answer;
    }
}
