package ohyeon.m08.programmers;

public class VowelDictionary {
	int count = 0;
	char[] vowels = { 'A', 'E', 'I', 'O', 'U' };
	int answer = 0;
	String word;

	public int solution(String word) {
		this.word = word;
		dfs(0, "");
		return answer;
	}

	public void dfs(int depth, String current) {
		if (current.equals(word)) {
			answer = count;
			return;
		}

		if (current.length() == 5) {
			return;
		}
		
		for (char c : vowels) {
			count++;
			dfs(depth + 1, current + c);
		}
	}
}
