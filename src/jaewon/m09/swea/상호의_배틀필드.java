package jaewon.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의_배틀필드 {

	// 전차 방향. 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[] tanks = { '^', 'v', '<', '>' };

	static char[][] map;

	static int H;
	static int W;

	static int tankR;
	static int tankC;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			// 게임 맵 높이, 너비
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			// 맵 입력받음
			for (int i = 0; i < H; i++) {
				String stream = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = stream.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						tankR = i;
						tankC = j;
					}
				}
			}

			// 명령어 입력 N
			int N = Integer.parseInt(in.readLine());

			String orderStream = in.readLine();
			for (int i = 0; i < N; i++) {
				char order = orderStream.charAt(i);

				switch (order) {
				case 'S':
					shoot();
					break;
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;

				}

			}
			sb.append("#").append(testCase).append(" ");
			
			for(int i=0 ; i<H ; i++) {
				for(int j=0 ; j<W ; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);
	}

	// 전차 움직이는 메서드
	static void move(int dir) {
		// 전차 방향 변경
		map[tankR][tankC] = tanks[dir];

		// 전차 이동 위치. 1칸 옮기니 dr, dc 그대로 사용
		int nextR = tankR + dr[dir];
		int nextC = tankC + dc[dir];

		// 범위 검사. 범위 밖이면 움직이지 않음. return
		if (nextR < 0 || nextR >= H || nextC < 0 || nextC >= W) {
			return;
		}

		// 평지 검사. 평지가 아니면 움직이지 않음. return
		if (map[nextR][nextC] != '.') {
			return;
		}

		// 기존 위치 평지 변환
		map[tankR][tankC] = '.';

		// 전차 위치 갱신
		map[nextR][nextC] = tanks[dir];
		tankR = nextR;
		tankC = nextC;

	}

	// 포탄 발사
	static void shoot() {
		// 현재 전차 방향 idx
		int dir = 0;
		// 현재 전차 방향 찾기
		for (int d = 0; d < 4; d++) {
			if (map[tankR][tankC] == tanks[d]) {
				dir = d;
				break;
			}
		}

		// 포탄 위치
		int nextR = tankR + dr[dir];
		int nextC = tankC + dc[dir];

		while (nextR >= 0 && nextR < H && nextC >= 0 && nextC < W) {
			// 벽돌 벽 만남. 파괴
			if (map[nextR][nextC] == '*') {
				map[nextR][nextC] = '.';
				break;
			}

			// 강철 벽 만남. 포탄 소멸
			if (map[nextR][nextC] == '#') {
				break;
			}
			
			nextR += dr[dir];
			nextC += dc[dir];
		}
	}

}
