package davin.m08.programmers;
import java.util.*;

public class 타겟넘버 {
	int count = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return count;
	}

	void dfs(int[] numbers, int target, int idx, int sum) {
		if (idx == numbers.length) {
			if (sum == target) {
				count++;
			}
			return;
		}
		dfs(numbers, target, idx + 1, sum + numbers[idx]);
		dfs(numbers, target, idx + 1, sum - numbers[idx]);
	}

}
