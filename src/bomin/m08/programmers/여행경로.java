package bomin.m08.programmers;

import java.util.ArrayList;

public class 여행경로 {
	// 방문 경우의 수 -> dfs, 출력 시 오름차순.
	// 모든 티켓 사용 -> depth = tickets.length;
	// 시작값 넣고 dfs -> 다음 값을 리스트에 넣음. 그리고 백트래킹 해야할듯.
	// depth== tickets.length일때 리스트를 배열로 변경 후 반환. 배열이 여러개 일 지는 어떻게 확인하지? 이차원배열?
	String[][] tickets;
	ArrayList<ArrayList<String[]>> pathList;
	boolean[] visited;
	ArrayList<String[]> path;

	public String[] solution(String[][] tickets) {
		this.tickets = tickets;
		// 경로를 담을 리스트
		pathList = new ArrayList<>();

		visited = new boolean[tickets.length];
		path = new ArrayList<>();
		dfs(0, null);
		// pathList에 경로가 2개 이상일 경우 오름차순으로 경로 리턴
		pathList.sort((p1, p2) -> {
			for (int i = 0; i < p1.size(); i++) {
				int compare = p1.get(0)[0].compareTo(p2.get(0)[0]);
				
				if(compare != 0) {
					return compare;
				}
				
				String airport1 = p1.get(i)[1];
				String airport2 = p2.get(i)[1];

				compare = airport1.compareTo(airport2);

				if (compare != 0) {
					return compare;
				}
			}
			return 0;
		});
		// 반환.
		ArrayList<String[]> resultPath = pathList.get(0);
		String[] answer = new String[tickets.length + 1];

		answer[0] = resultPath.get(0)[0];
		for (int i = 0; i < resultPath.size(); i++) {
			answer[i + 1] = resultPath.get(i)[1];
		}
		return answer;
	}

	void dfs(int depth, String currentAirport) {
		if (depth == tickets.length) {
			pathList.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			// 끝값과 시작값 같은지 확인해야함.
			// 리스트에 여행경로가 있다면 마지막 공항 찾아서 이어지는 곳 넣기.
			if (visited[i])
				continue;

			if (currentAirport != null && !currentAirport.equals(tickets[i][0])) {
				continue;
			}
			path.add(tickets[i]);
			visited[i] = true;
			dfs(depth + 1, tickets[i][1]);
			path.remove(path.size() - 1);
			visited[i] = false;
		}
	}
}
