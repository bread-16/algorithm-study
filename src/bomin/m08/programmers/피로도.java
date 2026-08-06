package bomin.m08.programmers;

public class 피로도 {
	boolean[] visited;
	int max = Integer.MIN_VALUE;

	public int solution(int k, int[][] dungeons) {

		visited = new boolean[dungeons.length];
		// dfs -> 남은 피로도 -> 던전 돌 수 있는지 체크 -> 돌기
		dfs(0, k, dungeons);

		return max;
	}

	public void dfs(int count, int k, int[][] dungeons) {
		max = Math.max(count, max);

		for (int i = 0; i < dungeons.length; i++) {
			// 던전 돌 수 있는지 체크
			if (!visited[i] && k >= dungeons[i][0]) {
				// 방문 표시
				visited[i] = true;
				// 방문 -> 소모 피로도 감소
				k = k - dungeons[i][1];
				// 다음 던전 체크
				dfs(count + 1, k, dungeons);
				// 방문 취소, 피로도 원상복구
				visited[i] = false;
				k = k + dungeons[i][1];
			}
		}
	}
}
