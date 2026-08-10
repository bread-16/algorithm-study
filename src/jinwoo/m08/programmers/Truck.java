package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class Truck {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리와 트럭종류
        Deque<Integer> trucks = new ArrayDeque<>();
        Deque<Integer> bridge = new ArrayDeque<>();
        
        for(int i=0; i<truck_weights.length; i++) {
        	trucks.offerLast(truck_weights[i]);
        }
        
        for(int i=0; i<bridge_length; i++) {
        	bridge.offerLast(0);
        }
        
        int nowWeight = 0;
        
        // 트럭이 없을때까지 반복
        while(!trucks.isEmpty()) {
        	// 반복할때마다 1초
        	answer++;
        	// 빠져나가는 트럭 무게 만틈 weight를 빼줌
        	int b = bridge.poll();
        	nowWeight -= b;
        	
        	// 다음 트럭이 들어올때 트럭들의 무게가 다리가 버틸 수 있는 무게보다 적다면 트럭을 다리 위에 올리기
        	// 무게가 넘는다면 0으로 채워주기
        	if(nowWeight + trucks.peekFirst() <= weight) {
        		int t = trucks.pollFirst();
        		bridge.offerLast(t);
        		nowWeight += t;
        	} else {
        		bridge.offerLast(0);
        	}
        	
        }
        // 모든 트럭이 올라간 후, 마지막 트럭이 빠져나가는 시간(다리길이)만큼 답에 더해주기
        return answer + bridge_length;
    }
}
