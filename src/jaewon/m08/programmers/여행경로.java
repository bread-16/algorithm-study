package jaewon.m08.programmers;

import java.util.Arrays;

public class 여행경로 {

	public String[][] tickets;
	public String[] answer;
	public boolean[] visited;
	public boolean found;

	public String[] solution(String[][] tickets) {
		Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

		this.tickets = tickets;
		visited = new boolean[tickets.length];
		answer = new String[tickets.length + 1];
		answer[0] = "ICN";

		for (int i = 0; i < tickets.length; i++) {
			if (!tickets[i][0].equals("ICN"))
				continue;

			visited[i] = true;
			answer[1] = tickets[i][1];

			dfs(i, 1);
			if (found)
				break;

			visited[i] = false;
		}

		return answer;
	}

	// curIdx: 방금 사용한 티켓의 인덱스 / length: 지금까지 사용한 티켓 수
	void dfs(int curIdx, int length) {
		if (length == tickets.length) {
			found = true;
			return;
		}

		String nextAirport = tickets[curIdx][1];

		for (int i = 0; i < tickets.length; i++) {
			if (visited[i] || !tickets[i][0].equals(nextAirport))
				continue;

			visited[i] = true;
			answer[length + 1] = tickets[i][1];

			dfs(i, length + 1);
			if (found)
				return;

			visited[i] = false;
		}
	}
}