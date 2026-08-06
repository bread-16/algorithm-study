package bomin.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {

	Set<Integer> set = new HashSet<>();
	boolean[] visited;

	// 소수 -> N 기준 -> 1~N의 제곱근까지 안나눠지면 소수.
	public int solution(String numbers) {
		int answer = 0;
		visited = new boolean[numbers.length()];

		// 숫자가 적힌 문자열로 만들 수 있는 모든 숫자 조합을 찾아야함

		// 어차피 문자열 길이 자리 수 구할 때 앞의 모든 문자 탐색 -> 셋에 넣으면 되지 않나? 해보기.
		dfs(0, "0", numbers);

		// 찾고 나서 그 숫자가 소수인지 판별.

		for (int num : set) {
			if (isPrime(num)) {
				answer++;
			}
		}
		return answer;
	}

	private void dfs(int depth, String current, String numbers) {
		set.add(Integer.parseInt(current));
		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, current + numbers.charAt(i), numbers);
				visited[i] = false;
			}
		}
	}

	private boolean isPrime(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
