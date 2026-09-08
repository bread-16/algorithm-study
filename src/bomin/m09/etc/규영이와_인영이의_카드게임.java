package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 규영이와_인영이의_카드게임 {
	static int[] gyCards;
	static int[] eyCards;
	static boolean[] visited;
	static boolean[] isGyCards;
	static int gySum;
	static int eySum;
	static int gyWin;
	static int eyWin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			gyCards = new int[9];
			eyCards = new int[9];
			isGyCards = new boolean[19];
			visited = new boolean[9];
			gySum = 0;
			eySum = 0;
			gyWin = 0;
			eyWin = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyCards[i] = Integer.parseInt(st.nextToken());
				isGyCards[gyCards[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!isGyCards[i]) {
					eyCards[idx++] = i;
				}
			}
			dfs(0);
			sb.append("#").append(tc).append(" ").append(gyWin).append(" ").append(eyWin).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == 9) {
			if (gySum > eySum) {
				gyWin++;
			} else if (gySum < eySum) {
				eyWin++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			if (gyCards[depth] > eyCards[i]) {
				gySum += (gyCards[depth] + eyCards[i]);
				dfs(depth + 1);
				gySum -= (gyCards[depth] + eyCards[i]);
			} else {
				eySum += (gyCards[depth] + eyCards[i]);
				dfs(depth + 1);
				eySum -= (gyCards[depth] + eyCards[i]);
			}
			visited[i] = false;

		}
	}

}
