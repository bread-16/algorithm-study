package davin.m08.programmers;
import java.util.*;

public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
//		int n = progresses.length;
//		int[] left = new int[n];
//		for (int i = 0; i < n; i++) {
//			left[i] = (int) (Math.ceil((100 - progresses[i]) / ((double) speeds[i])));
//		}
//
//		List<Integer> ans = new ArrayList<>();
//		int count = 1;
//		int cur = left[0];
//		for (int i = 1; i < n; i++) {
//			if (left[i] <= cur) {
//				count++;
//			} else {
//				ans.add(count);
//				count = 1;
//				cur = left[i];
//			}
//		}
//		ans.add(count);
//
//		return ans.stream().mapToInt(x -> x).toArray();
		
		int n= progresses.length; 
        Deque<Integer> q = new ArrayDeque<>();

        // 각 기능 완료까지 걸리는 날짜 계산     
        for(int i=0; i<n; i++){
            q.offer((int) Math.ceil((100-progresses[i]) / (double)speeds[i]));
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int current = q.poll(); // 기준 기능
            int count = 1;

            // 뒤 기능들이 같이 배포 가능한지 확인
            while (!q.isEmpty() && q.peek() <= current) {
                q.poll();
                count++;
            }
            ans.add(count);
        }       
        return ans.stream().mapToInt(x -> x).toArray();
	}
}
