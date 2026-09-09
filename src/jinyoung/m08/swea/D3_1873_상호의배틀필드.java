package jinyoung.m08.swea;

import java.io.*;
import java.util.*;

public class D3_1873_상호의배틀필드 {

	public static int H, W;
	public static char[][] map;
	public static int tankX, tankY;
	public static int dir;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static char[] tankShape = { '^', 'v', '<', '>' };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];

			// 맵 입력 + 전차 위치 찾기
			for (int i = 0; i < H; i++) {
				String line = br.readLine();

				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);

					if (map[i][j] == '^') {
						tankX = i;
						tankY = j;
						dir = 0;
					} else if (map[i][j] == 'v') {
						tankX = i;
						tankY = j;
						dir = 1;
					} else if (map[i][j] == '<') {
						tankX = i;
						tankY = j;
						dir = 2;
					} else if (map[i][j] == '>') {
						tankX = i;
						tankY = j;
						dir = 3;
					}
				}
			}

			int N = Integer.parseInt(br.readLine());
			String commands = br.readLine();

			for (int i = 0; i < N; i++) {

				char command = commands.charAt(i);

				switch (command) {
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

				case 'S':
					shoot();
					break;
				}
			}

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < H; i++) {
				sb.append(map[i]).append("\n");
			}
		}

		System.out.print(sb);
	}

	// 전차 이동
	static void move(int newDir) {

		// 1. 방향은 무조건 변경
		dir = newDir;
		map[tankX][tankY] = tankShape[dir];

		int nx = tankX + dx[dir];
		int ny = tankY + dy[dir];

		// 2. 맵 안이고 평지라면 이동
		if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {

			// 기존 전차 위치는 평지
			map[tankX][tankY] = '.';

			// 전차 위치 갱신
			tankX = nx;
			tankY = ny;

			// 새로운 위치에 전차 표시
			map[tankX][tankY] = tankShape[dir];
		}
	}

	// 포탄 발사
	static void shoot() {

		int nx = tankX + dx[dir];
		int ny = tankY + dy[dir];

		while (nx >= 0 && nx < H && ny >= 0 && ny < W) {

			// 벽돌 벽
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			}

			// 강철 벽
			if (map[nx][ny] == '#') {
				return;
			}

			// 그 외는 계속 진행
			nx += dx[dir];
			ny += dy[dir];
		}
	}
}