package jinyoung.m08.programmers;

import java.util.*;

class Queue_FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> result = new ArrayDeque<>();
		//남은 일수 계산
		for (int i = 0; i < progresses.length; i++) {
			int tmp = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
			deque.addLast(tmp);
		}
		System.out.println(deque);
		
		while (!deque.isEmpty()) {
			//기준 day
			int max = deque.pollFirst();
			int cnt=1;
			//기준 day 보다 작으면 함께 배포
			while(!deque.isEmpty() && deque.peekFirst() <= max) {
				deque.pollFirst();
				cnt++;
			}
			result.add(cnt);
		}
		
		int k=result.size();
		answer = new int[k];
		for (int i = 0; i < k; i++) {
			answer[i] = result.pollFirst();
		}
        return answer;
	}
}


/*
public class Queue_FunctionDevelopment {
	public static int[] progresses = {95, 90, 99, 99, 80, 99};
	public static int[] speeds = {1, 1, 1, 1, 1, 1};
	public static int[] answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> result = new ArrayDeque<>();

		for (int i = 0; i < progresses.length; i++) {
			int tmp = (int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]);
			deque.addLast(tmp);
		}
		System.out.println(deque);
		
		while (!deque.isEmpty()) {
			//기준 day
			int max = deque.pollFirst();
			int cnt=1;
			//기준 day 보다 작으면 함께 배포
			while(!deque.isEmpty() && deque.peekFirst() <= max) {
				deque.pollFirst();
				cnt++;
			}
			result.add(cnt);
		}
		
		int k=result.size();
		answer = new int[k];
		for (int i = 0; i < k; i++) {
			answer[i] = result.pollFirst();
		}
		System.out.println(Arrays.toString(answer));
	}

}
*/