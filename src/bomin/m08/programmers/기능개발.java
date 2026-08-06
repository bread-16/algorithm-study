package bomin.m08.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int dayCnt = 0;
		int taskCnt = 0;
		List<Integer> list = new ArrayList<>();
		// 큐에 배열을 넣고 -> 맨 위에 큐 꺼냄
		// 스피드 더해서 100이 될 때 count 기록
		// count * speed 더했을때 100 넘는 곳 까지 전부 개수 따로 세서 반환.
		// 반복

		Queue<int[]> dev = new ArrayDeque<>();

		// 큐에 작업, 속도 짝 맞춰서 배열형태로 집어넣기
		for (int i = 0; i < progresses.length; i++) {
			int[] task = { progresses[i], speeds[i] };
			dev.add(task);
		}
		// 큐가 비지 않으면 첫 큐에 있는 진행 과정이 100넘을 때 까지 카운트 ++
		while(!dev.isEmpty()) {
			while(dev.peek()[0]+ dev.peek()[1] * dayCnt< 100) {
				dayCnt++;
			}
			//다음 배포 불가한 작업까지 뽑아냄
			while(!dev.isEmpty() && dev.peek()[0] + dev.peek()[1] * dayCnt>=100) {
				dev.poll();
				taskCnt++;
			}
			list.add(taskCnt);
			taskCnt = 0;			
			//리스트를 배열로 변경
			answer = new int[list.size()];
			for(int i=0;i <list.size();i++) {
				answer[i] = list.get(i);
			}
		}
		
		

		return answer;
	}
}
