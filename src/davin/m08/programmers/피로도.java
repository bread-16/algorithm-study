package davin.m08.programmers;

import java.util.*;

public class 피로도 {
	boolean[] visited;
	int answer = 0;

	public int solution(int k, int[][] dungeons) {
		int n = dungeons.length;
		visited = new boolean[n];

		dfs(k, dungeons, 0);

		return answer;
	}

	void dfs(int k, int[][] dungeons, int count) {
		for (int i = 0; i < dungeons.length; i++) {
			int min = dungeons[i][0];
			int use = dungeons[i][1];

			if (!visited[i] && k >= min) {
				visited[i] = true;
				dfs(k - use, dungeons, count + 1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, count);

	}
}
