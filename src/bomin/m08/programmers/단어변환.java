package bomin.m08.programmers;

public class 단어변환 {
	int answer;
	String[] words;
	String target;
	int targetCnt;
	boolean[] visited;

	public int solution(String begin, String target, String[] words) {
		this.target = target;
		this.words = words;
		
		
		visited = new boolean[words.length];
		//타겟으로 가는데 최소 count
		targetCnt = Integer.MAX_VALUE;
		int depth = 0;
		dfs(begin, depth);
		
		//타겟으로 간 적이 없으면 0 반환.
		if(targetCnt >= 200000000) {
			return 0;
		}
		
		return targetCnt;
	}

	void dfs(String begin, int depth) {
		if (begin.equals(target)) {
			targetCnt = Math.min(targetCnt, depth);
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if (visited[i])
				continue;
			int count = 0;
			
			//시작 단어와 글자수가 하나만 다른거 체킹.
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) {
					count++;
				}
			}
			if (count == begin.length() - 1) {
				count = 0;
				visited[i] = true;
				dfs(words[i], depth + 1);
				visited[i] = false;
			}
			else {
				count = 0;
			}
		}
		return;
	}

}
