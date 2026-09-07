package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄스터 {
	static int N;
	static int X;
	static int M;
	static int[][] constraints;
	static int[] cages;
	static int answer;
	static int[] answerArray;
	// 제약조건에 걸리지 않으면 최대값으로 넣을 boolean배열
	static boolean[] isConstraints;
	static boolean found;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			found = false;
			constraints = new int[M][3];
			cages = new int[N + 1];
			isConstraints = new boolean[N + 1];
			answerArray = new int[N + 1];
			answer = Integer.MIN_VALUE;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 왼쪽 인덱스
				constraints[i][0] = Integer.parseInt(st.nextToken());
				// 오른쪽
				constraints[i][1] = Integer.parseInt(st.nextToken());
				// 합
				constraints[i][2] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < M; i++) {
				int left = constraints[i][0];
				int right = constraints[i][1];
				for (int j = left; j <= right; j++) {
					isConstraints[j] = true;
				}
			}
			// 제약조건에 걸리지 않은 우리에는 X넣기
			for (int i = 0; i < cages.length; i++) {
				if (!isConstraints[i])
					cages[i] = X;
			}
			dfs(1);
			sb.append("#").append(tc).append(" ");
			if (!found) {
				sb.append(-1);
			} else {
				for (int i = 1; i <= N; i++) {
					sb.append(answerArray[i]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	// 조합으로 각 우리의 햄스터 마리수 구하기
	static void dfs(int cageNum) {

		if (cageNum == N + 1) {
			// 제약조건 전부 통과하는지 테스트
			if (checkConstraints()) {
				// 답 찾았는지 체크
				found = true;
				// 햄스터 최댓값 구하기
				int sum = 0;
				for (int i = 1; i <= N; i++) {
					sum += cages[i];
				}
				if (answer < sum) {
					answer = sum;
					for (int i = 1; i <= N; i++) {
						// 답 저장
						answerArray[i] = cages[i];
					}
				}
			}
			return;
		}

		// 제약조건에 없는 우리에는 이미 X를 넣었기 때문에 다음으로
		if (!isConstraints[cageNum]) {
			dfs(cageNum + 1);
			return;
		}

		for (int i = 0; i <= X; i++) {
			cages[cageNum] = i;
			dfs(cageNum + 1);
		}

	}

	static boolean checkConstraints() {
		for (int i = 0; i < M; i++) {
			int left = constraints[i][0];
			int right = constraints[i][1];
			int combi = constraints[i][2];

			int sum = 0;
			for (int j = left; j <= right; j++) {
				sum += cages[j];
			}

			if (sum != combi) {
				return false;
			}
		}
		return true;
	}

}
