package jaewon.m08.programmers;

public class 피로도 {

	private int[][] dungeons;
	private boolean[] visited;
	private int answer = 0;

	public int solution(int k, int[][] dungeons) {
		this.dungeons = dungeons;
		visited = new boolean[dungeons.length];

		dfs(0, k);

		return answer;
	}

	/**
	 * @param depth   = 지금까지 탐험한 던전 수
	 * @param fatigue = 남은 피로도
	 */

	void dfs(int depth, int fatigue) {
		// 다음 던전에 탐색할 때 최대값 갱신
		answer = Math.max(depth, answer);

		// 탐험한 던전수가 던전의 개수와 같으면 더 이상 진행X
		if (depth == dungeons.length)
			return;

		for (int i = 0; i < dungeons.length; i++) {
			if(visited[i]) continue; // 이미 방문한 던전이면 스킵
			if(fatigue < dungeons[i][0]) continue; // 최소 피로도 만족 못하면 스킵
			
			visited[i] = true;
			dfs(depth+1, fatigue-dungeons[i][1]);
			// i번째 던전 탐색이 끝나고 i+1번째에서 i번째의 던전을 탐색할 수 있도록 미방문 변경
			visited[i] = false;
		}

	}

}
