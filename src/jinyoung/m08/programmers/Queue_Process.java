package jinyoung.m08.programmers;
//반례: [2,1,2,1,2] queue에 index를 넣는 방식으로 변경
import java.util.*;
class Queue_Process {
    public int solution(int[] priorities, int location) {
        int answer=0;
        Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			deque.addLast(i);
		}

		int cnt = 0;
		while (!deque.isEmpty()) {
			int idx = deque.pollFirst();
			int flag = 0;
			for (int nextIdx : deque) {
				if (priorities[nextIdx] > priorities[idx]) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 1) {
				deque.addLast(idx);
			} else {
				cnt++;
				if(idx==location) {
					answer=cnt;
					break;
				}
			}
		}
        return answer;
	}
}
/*
import java.util.*;

public class Queue_Process {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			deque.addLast(i);
		}
		
		int cnt = 0;
		while (!deque.isEmpty()) {
			int idx = deque.pollFirst();
			int flag = 0;
			for (int nextIdx : deque) {
				if (priorities[nextIdx] > priorities[idx]) {
					flag = 1;
					break;
				}
			}
			
			if (flag == 1) {
				deque.addLast(idx);
			} else {
				cnt++;
				if(idx==location) {
					System.out.println(cnt);
					break;
				}
			}
		}
	}
}
*/