package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 프로세서_연결하기 {

	static int N;
	static int[][] board; // 0=빈칸, 1=코어, 2=전선(탐색 중 임시로 칠하는 값)
	static List<int[]> cores; // 가장자리가 아닌 코어 좌표만 담는 리스트
	static int maxCore; // 지금까지 찾은 최대 연결 코어 수
	static int minLen; // maxCore 중 최소 전선 길이

	// 상 하 좌 우
	static final int[] dr = { -1, 1, 0, 0 };
	static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(in.readLine().trim());

			board = new int[N][N];
			cores = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());

					// 코어이면서 가장자리가 아닌 경우 탐색 대상에 추가
					// 가장자리 코어는 이미 전원이 연결된 것으로 간주
					if (board[i][j] == 1 && i != 0 && i != N - 1 && j != 0 && j != N - 1) {
						cores.add(new int[] { i, j });
					}

				}
			}

			// maxCore를 -1로 두는 이유: 탐색 대상 코어가 0개여서 cnt=0으로 끝나는 경우도 "0 > -1"이 성립해 정상적으로 갱신되어야
			// minLen이 MAX_VALUE로 남지 않음
			maxCore = -1;
			minLen = Integer.MAX_VALUE;

			// 0번 코어부터 탐색 시작 (연결 수 0개, 전선 길이 0에서 탐색)
			dfs(0, 0, 0);

			sb.append("#").append(testCase).append(" ").append(minLen).append("\n");

		}
		System.out.println(sb);
	}

	/**
	 * idx번째 코어의 처리 방법을 결정하는 백트래킹 함수.
	 *
	 * @param idx 지금 결정할 코어의 인덱스
	 * @param cnt 지금까지 전원에 연결한 코어 수
	 * @param len 지금까지 설치한 전선 길이의 합
	 */
	static void dfs(int idx, int cnt, int len) {
		int remain = cores.size() - idx; // 아직 결정하지 않은 코어 수

		/*
		 * 남은 코어(cnt+remain) 전부 연결해도 현재 기록(maxCore)에 못미치면 정답X. 리턴
		 */
		if (cnt + remain < maxCore)
			return;

		/*
		 * 코어 전선 길이가 최소 길이를 넘으면 정답X. 리턴
		 */
		if (cnt + remain <= maxCore && len >= minLen)
			return;

		// 종료 조건
		if (idx == cores.size()) {
			// 1순위로 개수 비교, 개수가 같으면 2순위 길이 비교
			if (cnt > maxCore || (cnt == maxCore && len < minLen)) {
				maxCore = cnt;
				minLen = len;
			}
			return;
		}

		// 현재 코어의 위치값
		int r = cores.get(idx)[0];
		int c = cores.get(idx)[1];

		// 선택지 1. 상하좌우로 전선 뻗기
		for (int d = 0; d < 4; d++) {
			// 경계까지 경로가 비어있는지 확인. 안비어 있으면 스킵
			if (!canLay(r, c, d))
				continue;

			// 경로를 2로 칠하고, 칠한 전선 길이 받음
			int wire = layWire(r, c, d, 2);

			// 다음 코어 결정. len에는 방금 깐 전선 길이 더함
			dfs(idx + 1, cnt + 1, len + wire);

			// 백트래킹. 기존 전선 0으로 돌림
			layWire(r, c, d, 0);
		}

		// 선택지 2. 코어 포기
		// 그냥 코어를 사용하지 않고 다음 코어로 넘어감
		dfs(idx + 1, cnt, len);

	}

	/**
	 * (r, c)에서 d 방향으로 보드 경계까지 가는 길이 전부 빈 칸인지 검사. 설치와 분리한 이유: 중간에 막힌 것을 뒤늦게 발견해 이미
	 * 칠한 칸을 되돌리는 예외 처리를 피하기 위함.
	 */
	static boolean canLay(int r, int c, int d) {
		int nr = r + dr[d];
		int nc = c + dc[d];

		// 보드 안에 있는 동안 전진
		while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			// 0이 아니면 코어(1) or 이미 깔린 전선(2) => 교차이므로 실패
			if (board[nr][nc] != 0)
				return false;
			nr += dr[d];
			nc += dc[d];
		}

		// 경계 밖으로 나갈때 까지 막힘X. 연결 가능
		return true;
	}

	static int layWire(int r, int c, int d, int v) {
		int len = 0;
		int nr = r + dr[d];
		int nc = c + dc[d];

		while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
			board[nr][nc] = v; // 설치(2) or 회수(0)
			len++; // 전선 길이 누적
			nr += dr[d];
			nc += dc[d];
		}
		return len;
	}

}
