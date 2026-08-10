package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Process {
	
	public int solution(int[] priorities, int location) {
		
		// 우선순위와 idx 담기
		Deque<int[]> processes = new ArrayDeque<>();
		
		// 우선순위 담기(내림차순으로 해야 높은순 -> 낮은순으로 정렬
		PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder());
		
		// 담기
		for(int i=0; i<priorities.length; i++) {
			int[] pr = {priorities[i], i};
			processes.offerLast(pr);
			priority.offer(priorities[i]);
		}
		
		int answer = 0;
		
		// processes가 빌때까지 반복
		while(!processes.isEmpty()) {
			// 처음꺼 꺼내오기
			int[] pr = processes.pollFirst();
			
			// 우선순위 1순위와 비교해서 우선순위가 작으면 뒤로 다시 저장
			if(pr[0] < priority.peek()) {
				processes.offerLast(pr);
			// 우선순위가 같다면 실행 +1, 제거, 만약 location과 같다면 종료
			}else {
				answer++;
				
				priority.poll();
				
				if(pr[1] == location) {
					return answer;
				}
			}
		}
		
		return answer;
    }
}
