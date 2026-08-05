package jaewon.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers42839 {

	private char[] pieces;
	private boolean[] used;
	private final Set<Integer> candidates = new HashSet<>(); // 숫자가 중복을 방지하기 위해 set으로 받음

public int solution(String numbers) {
		candidates.clear();
		pieces = numbers.toCharArray();
		used = new boolean[pieces.length];
		dfs(0, "");

		int answer = 0;
		for (int candidate : candidates) {
			if (isPrime(candidate)) {
				answer++;
			}
		}

		return answer;
	}

	/**
	 * @param depth 지금까지 사용한 조각의 개수
	 * @param cur   지금까지 이어 붙인 숫자 문자열
	 */
	void dfs(int depth, String cur) {
		// 현재 숫자가 있다면 set에 추가
		if (!cur.isEmpty()) {
			candidates.add(Integer.parseInt(cur));
		}

		// 종료 조건: 깊이가 pieces.length와 같아지면 최대 자릿수로 숫자 생성. 더 이상 생성 불가
		if (depth == pieces.length)
			return;

		for (int i = 0; i < pieces.length; i++) {
			if (used[i])
				continue;

			used[i] = true;
			dfs(depth + 1, cur + pieces[i]);
			used[i] = false;
		}

	}

	boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n < 4)
			return true;
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}