package giseon.m09.SWEA;

import java.io.*;
import java.util.*;

public class 상호의배틀필드 {

	static char[][] map;
	static int H;
	static int W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			int x = 0; 
			int y = 0;

			for (int i = 0; i < H; i++) {
				String line = br.readLine().trim();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					// 전차 위치 확인(탐색 시작점)
					if (map[i][j] == '^' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v') {
						x = i;
						y = j;
					}
				} // for j end
			} // for i end

			int N = Integer.parseInt(br.readLine());
			String command = br.readLine();

			// 탐색은 command 길이만큼 하면 됨, map을 직접 수정해서 전부 출력해야 됨
			// dr, dc 이용하여 탐색
			// S면 해당 방향 전부 확인해서 벽돌 벽은 부수고 강철은 변화x
			// U D L R 이면 해당 방향으로 전차 변경하고 위치 이동 '.' 인지 체크하고 이동
			for (int i = 0; i < N; i++) {
				if (command.charAt(i) == 'S') { // s면 shoot
					shoot(x, y, map[x][y]);
				} else { // 이동
					switch (command.charAt(i)) {
					case 'U': // 위로 가야된다면
						map[x][y] = '^'; // 방향 변경
						if (x - 1 >= 0) { // inRange(x - 1, y)
							if (map[x - 1][y] == '.') {// 평지여야 이동 가능
								map[x][y] = '.';
								map[--x][y] = '^';
							}
						}
						break;
					case 'D': // 현재 전차 방향 체크
						map[x][y] = 'v'; // 방향 변경
						if (x + 1 < H) { // inRange(x + 1, y)
							if (map[x + 1][y] == '.') {// 평지여야 이동 가능
								map[x][y] = '.';
								map[++x][y] = 'v';
							}
						}
						break;
					case 'L': // 현재 전차 방향 체크
						map[x][y] = '<'; // 방향 변경
						if (y - 1 >= 0) { // inRange(x, y - 1)
							if (map[x][y - 1] == '.') {// 평지여야 이동 가능
								map[x][y] = '.';
								map[x][--y] = '<';
							}
						}
						break;
					case 'R': // 현재 전차 방향 체크
						map[x][y] = '>'; // 방향 변경
						if (y + 1 < W) { // inRange(x, y + 1)
							if (map[x][y + 1] == '.') {// 평지여야 이동 가능
								map[x][y] = '.';
								map[x][++y] = '>';
							}
						}
						break;
					} // switch end
				} // else end

			} // for i end

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		} // tc end
		System.out.print(sb);
	} // main end

	// 커맨드 S를 만나면
	// 방향에 따라 전차 다음 위치부터 맵 끝까지 포탄 날아감
	// 벽돌을 만나면 벽을 평지로 바꿈
	static void shoot(int x, int y, char direction) {
		switch (direction) {
		case '^': // 위쪽방향이면
			if (x - 1 >= 0) {
				for (int i = x - 1; i >= 0; i--) {
					if (map[i][y] == '*') {
						map[i][y] = '.';
						break;
					} else if (map[i][y] == '#') {
						break;
					}
				}
			}
			break;
		case 'v': // 아래쪽 방향이면
			if (x + 1 < H) {
				for (int i = x + 1; i < H; i++) {
					if (map[i][y] == '*') {
						map[i][y] = '.';
						break;
					} else if (map[i][y] == '#') {
						break;
					}
				}
			}
			break;
		case '<':
			if (y - 1 >= 0) {
				for (int i = y - 1; i >= 0; i--) {
					if (map[x][i] == '*') {
						map[x][i] = '.';
						break;
					} else if (map[x][i] == '#') {
						break;
					}
				}
			}
			break;
		case '>':
			if (y + 1 < W) {
				for (int i = y + 1; i < W; i++) {
					if (map[x][i] == '*') {
						map[x][i] = '.';
						break;
					} else if (map[x][i] == '#') {
						break;
					}
				}
			}
			break;
		}
	} // shoot end

} // class end
