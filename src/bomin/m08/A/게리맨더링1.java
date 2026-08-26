package bomin.m08.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링1 {

	// 각 구역의 인구수
	static int[] population;

	// 각 구역과 연결된 구역 정보를 저장하는 인접 리스트
	static List<Integer>[] graph;

	// 현재 DFS에서 선택된 구역인지 표시
	static boolean[] visited;

	// 전체 인구수
	static int populSum;

	static int N;

	// 현재 선택된 선거구의 인구수 합
	static int sum;

	// 두 선거구 인구 차이의 최솟값
	static int answer;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		visited = new boolean[N + 1];

		populSum = 0;
		answer = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1. 각 구역의 인구수 입력
		// 동시에 전체 인구수도 계산
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			populSum += population[i];
		}

		// 2. 인접 리스트 생성
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 3. 각 구역의 연결 정보 입력
		for (int i = 1; i <= N; i++) {

			st = new StringTokenizer(br.readLine());

			// 현재 구역과 연결된 구역의 개수
			int count = Integer.parseInt(st.nextToken());

			for (int j = 1; j <= count; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		// 4. 각 구역을 시작점으로 잡고 DFS 실행
		// DFS를 통해 하나의 선거구를 만들어 본다.
		for (int i = 1; i <= N; i++) {

			dfs(i);

			// 다음 시작점 탐색을 위해 상태 초기화
			sum = 0;
			Arrays.fill(visited, false);
		}

		// 가능한 선거구 분할이 하나도 없다면 -1 출력
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static void dfs(int cur) {

		// 5. 현재 구역을 첫 번째 선거구에 포함
		visited[cur] = true;
		sum += population[cur];

		// 6. visited == false인 나머지 구역들이
		// 하나의 선거구로 서로 연결되어 있는지 검사
		if (isConnected()) {

			// 첫 번째 선거구 인구 = sum
			// 두 번째 선거구 인구 = 전체 인구 - sum
			int diff = Math.abs(sum - (populSum - sum));

			answer = Math.min(answer, diff);
		}

		// 7. 현재 구역과 연결된 다음 구역들을 DFS로 탐색
		for (int next : graph[cur]) {

			// 이미 현재 선거구에 포함된 구역이면 넘어감
			if (visited[next])
				continue;

			// next 구역도 현재 선거구에 포함시키고 계속 탐색
			dfs(next);

			// 8. 백트래킹
			// next를 선택하기 전 상태로 되돌림
			sum -= population[next];
			visited[next] = false;
		}
	}

	static boolean isConnected() {

		int start = 0;
		// 9. 현재 DFS에서 선택되지 않은 구역 중
		// BFS 시작점 하나를 찾는다.
		for (int i = 1; i <= N; i++) {

			if (visited[i] == false) {
				start = i;
				break;
			}
		}
		// 모든 구역이 첫 번째 선거구에 들어가 버렸다면
		// 두 번째 선거구가 없으므로 잘못된 분할
		if (start == 0)
			return false;

		// 두 번째 선거구의 연결 여부 확인용 방문 배열
		boolean[] checkVisited = new boolean[N + 1];

		Queue<Integer> Q = new ArrayDeque<>();

		Q.offer(start);

		// 10. visited == false인 구역들만 BFS 탐색
		while (!Q.isEmpty()) {

			int temp = Q.poll();

			// 첫 번째 선거구에 포함된 구역이면 탐색하지 않음
			if (visited[temp])
				continue;

			checkVisited[temp] = true;

			for (int next : graph[temp]) {

				// 첫 번째 선거구에 포함된 노드는 제외
				if (visited[next])
					continue;

				// 이미 BFS로 방문한 노드는 제외
				if (checkVisited[next])
					continue;

				Q.offer(next);
			}
		}
		// 11. visited == false인 모든 노드가
		// BFS에서도 방문되었는지 확인
		for (int i = 1; i <= N; i++) {
			if (visited[i] == checkVisited[i]) {
				return false;
			}
		}

		return true;
	}
}