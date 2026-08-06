import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Integer> nums = new ArrayList<>(); // 약수 담을 리스트
        int s = brown + yellow;
        double range = Math.sqrt(s);
        
        for (int i = 1; i <= range; i++) { // 완전제곱수기 때문에 이하로 설정...
            if (s % i == 0) { // 약수면 배열에 넣는다.
                nums.add(s / i);
                nums.add(i);
            }
        }
        int p1 = 0;
        int p2 = 1;
        // 배열을 투포인터로 순회하며 이면 answer에 넣고 종료
        while((p1 < nums.size()) && (p2 < nums.size())) {
            if (2 * (nums.get(p1) + nums.get(p2)) - 4 == brown) {
                answer[0] = nums.get(p1);
                answer[1] = nums.get(p2);
                break;
            } else {
                p1 += 2;
                p2 += 2;
            }
        }
        
        return answer;
    }
}