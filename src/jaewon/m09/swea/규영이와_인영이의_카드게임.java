package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와_인영이의_카드게임 {
	static int[] gyuYoung;
	static int[] inYoung;
	static boolean[] visited;

	static int win;
	static int lose;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			gyuYoung = new int[9];
			inYoung = new int[9];

			StringTokenizer st = new StringTokenizer(in.readLine());

			// 카드 선택한지 확인하는 배열
			boolean[] selected = new boolean[19];

			// 규영이 카드 입력
			for (int i = 0; i < 9; i++) {
				gyuYoung[i] = Integer.parseInt(st.nextToken());
				selected[gyuYoung[i]] = true;
			}

			int idx = 0;
			// 인영이 카드 입력
			for (int i = 1; i <= 18; i++) {
				if (!selected[i]) {
					inYoung[idx++] = i;
				}
			}

			// 인영이의 카드 사용 여부 확인하는 배열
			visited = new boolean[9];

			win = 0;
			lose = 0;

			dfs(0, 0, 0);

			sb.append("#").append(testCase).append(" ").append(win).append(" ").append(lose).append("\n");

		}
		System.out.println(sb);
	}

	static void dfs(int gyuScore, int inScore, int depth) {
		// 9라운드 모두 진행하면 결과 갱신
		if (depth == 9) {
			// 규영이가 이김 -> win++
			if (gyuScore > inScore) {
				win++;
			}
			// 인영이가 이김 -> lose++
			else {
				lose++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				continue;
			}

			visited[i] = true;

			int gyuCard = gyuYoung[depth];
			int inCard = inYoung[i];

			if (gyuCard > inCard) {
				dfs(gyuScore + gyuCard + inCard, inScore, depth+1);
			} else {
				dfs(gyuScore, inScore + gyuCard + inCard, depth+1);
			}

			visited[i] = false;
		}

	}
}
