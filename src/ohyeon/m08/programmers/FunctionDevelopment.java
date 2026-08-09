package ohyeon.m08.programmers;

import java.util.*;

public class FunctionDevelopment {
	public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int current = 0;
        
        while(current < progresses.length) {
            for(int idx = current; idx < progresses.length; idx++) {
                progresses[idx] += speeds[idx];
            }
            
            if (progresses[current] >= 100) {
                int count = 0;
                while(current < progresses.length && progresses[current] >= 100) {
                    count++;
                    current++;
                }
                answer.add(count);
            }
        }
        int[] result = new int[answer.size()];
        for (int i = 0 ; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
