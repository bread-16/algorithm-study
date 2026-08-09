package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격 {
	public int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];
		Deque<Integer> st = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			// 현재 가격이 이전 가격보다 낮으면 스택에서 이전 가격을 빼내고 답을 결정
			while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
				int idx = st.pop();
				// 정답 = 종료 시각 - 들어간 시각
				answer[idx] = i - idx;
			}
			st.push(i);
		}

		// 아직 스택에 남아있다면 빼면서 정답 결정
		while (!st.isEmpty()) {
			int idx = st.pop();
			// 정답 = 종료 시각 - 들어간 시각
			answer[idx] = n - 1 - idx;
		}

		return answer;
	}
}
