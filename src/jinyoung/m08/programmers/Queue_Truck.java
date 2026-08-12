package jinyoung.m08.programmers;

import java.util.*;

public class Queue_Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();
		Deque<Integer> bridge = new ArrayDeque<>();
		Deque<Integer> enterTime = new ArrayDeque<>();
		
		for(int i : truck_weights) {
			deque.addLast(i);
		}
		int cnt=0;
		//다리에 트럭이 있거나, 대기 중 트럭이 있다면 계속 반복
		while(!deque.isEmpty() || !bridge.isEmpty()) {
			//1초 경과
			cnt++;
			
			//다리 맨 앞에 트럭이 내릴 시간인지
			if(!bridge.isEmpty() && cnt-enterTime.peekFirst() == bridge_length) {
				bridge.pollFirst();
				enterTime.pollFirst();
			}
			
			//새 트럭이 다리에 올라갈 수 있는지
			if(!deque.isEmpty()) {
				int sum=0;
				for(int b : bridge) {
					sum+=b;
				}
				//현재 무게+들어올 트럭 무게 <= 견딜 수 있는 무게
				if(sum+deque.peekFirst()<=weight) {
					bridge.addLast(deque.pollFirst());
					enterTime.addLast(cnt);
				}
			}
		}
        return cnt;
	}
}
		
		
		/*망해서 다시
		int cnt=0;
		while(!deque.isEmpty()) {
			int current = deque.pollFirst();
			cnt++;
			System.out.println("건너는중: "+current+"  시간: "+cnt);
			//비었으면 다리 길이 더하고 종료
			if(deque.isEmpty()) {
				cnt+=bridge_length;
				break;
			} 
			//합칠 수 있으면 합치고 1초 증가
			while(!deque.isEmpty() && weight-current-deque.peekFirst()>=0) {
				current+=deque.pollFirst();
				cnt++;
			}
			cnt+=bridge_length;
			System.out.println("다건넘: "+current+"  시간: "+cnt);
		}
		System.out.println(cnt);
	}
}

	*/
