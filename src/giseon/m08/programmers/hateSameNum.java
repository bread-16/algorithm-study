import java.util.*;

public class hateSameNum {
    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> stack = new ArrayList<>();
        
        for (int num : arr) {
            if (stack.size() == 0 || stack.get(stack.size()-1) != num) {
                stack.add(num);
            } else {
                continue;
            }
        }
        
        answer = new int[stack.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}