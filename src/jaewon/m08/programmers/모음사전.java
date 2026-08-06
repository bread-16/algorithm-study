package jaewon.m08.programmers;

public class 모음사전 {

	private char[] words = { 'A', 'E', 'I', 'O', 'U' };
	private int answer = 0;
	private boolean flag = false;

	public int solution(String word) {
		dfs(0, "", word);

		return answer;
	}

	void dfs(int depth, String cur, String word) {
		// 원하는 단어를 이미 찾음. 
		if (flag)
			return;
		
		if (!cur.isEmpty()) {
			// 단어가 있을때 사전순 증가
			answer++;
			if (cur.equals(word)) {
				// 원하는 단어 찾음. flag을 true로 바꿔 이후 dfs 연산 스킵
				flag = true;
				return;
			}
		}
		// 기본 종료조건: 깊이가 5면 더 이상 dfs 진행 불가
		if (depth == words.length)
			return;
		
		for (char x : words) {
			dfs(depth + 1, cur + x, word);
		}

	}

}
