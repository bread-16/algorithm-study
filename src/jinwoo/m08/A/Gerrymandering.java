package jinwoo.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Gerrymandering {
	static boolean[] visited;
	static int areaNum;
	static int[] population;
	static int answer;
	static int[][] nodes;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		areaNum = Integer.parseInt(in.readLine());

		String count = in.readLine();

		StringTokenizer st = new StringTokenizer(count);

		population = new int[areaNum];

		for (int i = 0; i < areaNum; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		nodes = new int[areaNum][];

		for (int i = 0; i < nodes.length; i++) {
			StringTokenizer stNode = new StringTokenizer(in.readLine());

			nodes[i] = new int[Integer.parseInt(stNode.nextToken())];

			for (int j = 0; j < nodes[i].length; j++) {
				nodes[i][j] = Integer.parseInt(stNode.nextToken()) - 1;
			}
		}

		visited = new boolean[areaNum];
		answer = Integer.MAX_VALUE;
		
		dfs(0);
		
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}

	static public void dfs(int depth) {
		
		// dfs로 2개의 그룹으로 나누는 모든 경우의 수를 뽑고, bfs로 연결되어있는지 검사 그 후 인구수를 구해 인구수 차를 구함
		if (depth == areaNum) {
			List<Integer> selected = new ArrayList<>();
			List<Integer> unSelected = new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				if (visited[i]) {
					selected.add(i);
				} else {
					unSelected.add(i);
				}
			}

			if (selected.isEmpty() || unSelected.isEmpty())
				return;

			if (!bfs(selected) || !bfs(unSelected))
				return;

			int selectedP = 0;
			int unSelectedP = 0;

			for (int i = 0; i < selected.size(); i++) {
				selectedP += population[selected.get(i)];
			}
			for (int i = 0; i < unSelected.size(); i++) {
				unSelectedP += population[unSelected.get(i)];
			}

			if (answer > Math.abs(selectedP - unSelectedP)) {
				answer = Math.abs(selectedP - unSelectedP);
			}

			return;
		}
		// 이게 중요
		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
		dfs(depth + 1);
	}

	// 각 그룹이 연결되어있는지 확인
	static public boolean bfs(List<Integer> list) {

		boolean[] check = new boolean[areaNum];
		Deque<Integer> dq = new ArrayDeque<>();

		int start = list.get(0);

		dq.offer(start);
		check[start] = true;

		int count = 1;

		while (!dq.isEmpty()) {
			int n = dq.poll();

			for (int next : nodes[n]) {
				if (!list.contains(next))
					continue;
				if (check[next])
					continue;

				check[next] = true;
				dq.offer(next);
				count++;
			}
		}

		return count == list.size();
	}
}
