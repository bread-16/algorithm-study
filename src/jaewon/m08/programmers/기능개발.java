package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> days = new ArrayDeque<>();
		// 배포까지 남은 일수를 계산해서 q 삽입
		// 남은 일수 = (100 - progresses + speeds -1)/speeds
		for (int i = 0; i < progresses.length; i++) {
			int day = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
			days.offer(day);
		}

		List<Integer> tmp = new ArrayList<>();

		// 큐가 비어있지 않으면 남은 기능이 있음
		while (!days.isEmpty()) {
			int front = days.poll();
			int count = 1;
			// 큐에 남아있는 것 중에서 front보다 작으면 front와 같이 배포. 빼내고 count++
			while (!days.isEmpty() && days.peek() <= front) {
				days.poll();
				count++;
			}
			tmp.add(count);
		}

		int[] answer = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			answer[i] = tmp.get(i);
		}

		return answer;
	}

}
