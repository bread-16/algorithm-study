package ohyeon.m08.programmers;

import java.util.*;

public class TruckBridge {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            deque.offer(0);
        }
        
        int current_weight = 0;
        int time = 0;
        int idx = 0;
        
        while(idx < truck_weights.length) {
            time++;
            
            current_weight -= deque.poll();
            
            if(current_weight + truck_weights[idx] <= weight) {
                current_weight += truck_weights[idx];
                deque.offer(truck_weights[idx]);
                idx++;
            } else {
                deque.offer(0);
            }
        }
            
        return time+bridge_length;
    }
}
