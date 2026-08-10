package giseon.m08.programmers;

// 1.68ms, 88.4MB
import java.util.*;

class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Deque<Integer> waiting = new ArrayDeque<>(); // 대기열
        Deque<int[]> bridge = new ArrayDeque<>(); // 다리 {무게, 시간}
        
        // 대기열에 트럭들을 넣는다.
        for (int truck : truck_weights) {
            waiting.offer(truck);
        }
        // 다리 위에 있는 총 무게
        int weightOnBridge = 0;
        // 대기열에 트럭이 비어있지 않거나 다리 위가 비어있지 않을 때(둘다 빌 때까지 반복)
        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            answer++; // 시간 증가
            // 1. 현재 시간이 되어서 다리를 빠져나가는 트럭 제거
            // 다리가 비어있지 않으면 다음 트럭 무게과 현재 다리에 있는 트럭의 무게 계산해서 다리에 올릴지 결정한다.
            if (!bridge.isEmpty()) {
                int[] truck = bridge.peek();
                
                // 현재까지 지난 시간 - 다리 위에 트럭이 올라간 시간 => 다리에서 빠져나가기까지의 시간
                // 다리에서 빠져나가기까지의 시간은 다리 길이만큼 걸리므로 같으면 다리에서 뺀다.
                if (answer - truck[1] == bridge_length) {
                    weightOnBridge -= truck[0]; // 다리에서 빼낼 거니까 하중 감소
                    bridge.poll(); // 다리에서 빼냄
                }
            }
            
            // 대기열에 트럭 있으면 올라갈 수 있는지 확인
            if (!waiting.isEmpty()) {
                // 다음 트럭의 무게
                int next = waiting.peek();
                // 다리 위 무게 + 다음 대기 트럭 무게가 최대하중 이하면 넣고 시간 증가시키기
                if (weightOnBridge + next <= weight) {
                    // 대기열에서 빼낸 후
                    waiting.poll();
                    // 트럭을 다리에 진입시킴
                    bridge.offer(new int[]{next, answer});
                    weightOnBridge += next; // 다리 위 하중 증가
                }
            }
        }
        
        return answer;
    }
}
