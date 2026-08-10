package dana.m08.programmers;

import java.util.*; 

public class Programmers42587 {
	
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 1. 큐에 우선순위 값이 아니라 "인덱스(0, 1, 2...)"를 넣는다 
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i); 
        }
        
        int answer = 0; 
        
        while (!queue.isEmpty()) {
            // 2. 큐에서 현재 문서의 "인덱스"를 꺼낸다
            int currentIndex = queue.poll();
            
            boolean hasHigherPriority = false;
            
            // 3. 큐에 남아있는 다른 인덱스들과 우선순위를 비교한다 
            for (int otherIndex : queue) {
                if (priorities[otherIndex] > priorities[currentIndex]) {
                    hasHigherPriority = true; 
                    break; 
                }
            }
            
            if (hasHigherPriority) {
                // 우선순위 높은 게 있으면 뒤로 보냄
                queue.offer(currentIndex);
            } else {
                // 현재 문서가 가장 높은 우선순위면 인쇄
                answer++; 
                
                // 방금 인쇄한 문서의 원래 위치가 내가 찾던 location인지 확인
                if (currentIndex == location) {
                    return answer; 
                }
            }
        }
        
        return answer; 
    }

}
