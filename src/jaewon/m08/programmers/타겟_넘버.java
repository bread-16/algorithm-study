package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 타겟_넘버 {

	public int[] numbers;
	public int target;
	public int answer;

	public int solution(int[] numbers, int target) {
		this.numbers = numbers;
		this.target = target;
		this.answer = 0;

//		dfs(0,0);
		answer = bfs();

		return answer;
	}

	// 5.24ms / 86.9MB
	void dfs(int cur, int idx) {
		if (idx == numbers.length) {
			if (cur == target) {
				answer++;
			}
			return;
		}

		dfs(cur + numbers[idx], idx + 1);
		dfs(cur - numbers[idx], idx + 1);

	}
	// 47.41ms, 110MB
	int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);                       // 시작 누적합

        for (int idx = 0; idx < numbers.length; idx++) {
            int size = queue.size();          // 이번 레벨의 노드 수를 고정
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                queue.offer(cur + numbers[idx]);
                queue.offer(cur - numbers[idx]);
            }
        }

        int count = 0;
        for (int sum : queue) {               // 마지막 레벨 = 완성된 조합들
            if (sum == target) count++;
        }
        return count;
    }

}
