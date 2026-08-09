package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 다리를_지나는_트럭 {
	public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Integer> onBridgeTrucks = new ArrayDeque<>();
        Queue<Integer> entryTimes = new ArrayDeque<>();

        int time = 0; // 트럭 진입 시간
        int onBridge = 0; // 다리 위 트럭 무게 총합
        int idx = 0; // 대기 트럭 인덱스

        // 대기 트럭이 남아있을 때
        while (idx < truckWeights.length) {
            time++;

            // 하차: 진입 시각 + bridgeLength 가 지난 트럭 제거
            while (!entryTimes.isEmpty() && entryTimes.peek() + bridgeLength <= time) {
                entryTimes.poll();
                onBridge -= onBridgeTrucks.poll();
            }

            // 트럭 진입 : 다리위 트럭과 대기 트럭이 하중보다 낮으면 대기 트럭 진입
            int next = truckWeights[idx];
            if (onBridge + next <= weight) {
                onBridge += next;
                onBridgeTrucks.offer(next);
                entryTimes.offer(time);
                idx++;
            }
        }
        // 마지막 트럭이 진입하면 while문 종료. 마지막 트럭 지나간 시간 포함
        return time + bridgeLength;
    }
}