package ohyeon.m09.pdf;

import java.io.*;
import java.util.*;

public class 사과먹기게임 {
	static int dir;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] map = new int[N][N];

            int maxApple = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0) {
                        maxApple = Math.max(maxApple, map[i][j]);
                    }
                }
            }

            int curR = 0;
            int curC = 0;
            dir = 1;
            int totalRotations = 0;

            for (int target = 1; target <= maxApple; target++) {
                int targetR = -1, targetC = -1;
                outer:
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == target) {
                            targetR = i;
                            targetC = j;
                            break outer;
                        }
                    }
                }

                totalRotations += getRotations(curR, curC, targetR, targetC);

                map[targetR][targetC] = 0;

                curR = targetR;
                curC = targetC;
            }

            sb.append("#").append(tc).append(" ").append(totalRotations).append("\n");
        }

        System.out.print(sb);
    }

    public static int getRotations(int r, int c, int tr, int tc) {
        int rot = 0;

        switch (dir) {
            case 1: // 우측을 보고 있을 때
                if (tr == r) {
                    if (tc < c) { // 뒤쪽에 있음
                        rot = 2;
                        dir = 3;
                    }
                } else if (tr > r) { // 아래쪽에 있음
                    if (tc >= c) { // 오른쪽 혹은 같은 열
                        rot = 1;
                        dir = 2;
                    } else { // 왼쪽 아래
                        rot = 2;
                        dir = 3;
                    }
                } else { // 위쪽에 있음
                    if (tc >= c) { // 오른쪽 위
                        rot = 3;
                        dir = 4;
                    } else { // 왼쪽 위
                        rot = 2;
                        dir = 4;
                    }
                }
                break;

            case 2: // 아래쪽을 보고 있을 때
                if (tc == c) {
                    if (tr < r) { // 위쪽
                        rot = 2;
                        dir = 4;
                    }
                } else if (tc < c) { // 왼쪽
                    if (tr >= r) { // 아래 또는 같은 행
                        rot = 1;
                        dir = 3;
                    } else { // 왼쪽 위
                        rot = 2;
                        dir = 4;
                    }
                } else { // 오른쪽
                    if (tr >= r) { // 오른쪽 아래
                        rot = 3;
                        dir = 1;
                    } else { // 오른쪽 위
                        rot = 2;
                        dir = 1;
                    }
                }
                break;

            case 3: // 왼쪽을 보고 있을 때
                if (tr == r) {
                    if (tc > c) { // 앞뒤 반대
                        rot = 2;
                        dir = 1;
                    }
                } else if (tr < r) { // 위쪽
                    if (tc <= c) { // 왼쪽 또는 같은 열
                        rot = 1;
                        dir = 4;
                    } else { // 오른쪽 위
                        rot = 2;
                        dir = 1;
                    }
                } else { // 아래쪽
                    if (tc <= c) { // 왼쪽 아래
                        rot = 3;
                        dir = 2;
                    } else { // 오른쪽 아래
                        rot = 2;
                        dir = 2;
                    }
                }
                break;

            case 4: // 위쪽을 보고 있을 때
                if (tc == c) {
                    if (tr > r) { // 아래쪽
                        rot = 2;
                        dir = 2;
                    }
                } else if (tc > c) { // 오른쪽
                    if (tr <= r) { // 위 또는 같은 행
                        rot = 1;
                        dir = 1;
                    } else { // 오른쪽 아래
                        rot = 2;
                        dir = 2;
                    }
                } else { // 왼쪽
                    if (tr <= r) { // 왼쪽 위
                        rot = 3;
                        dir = 3;
                    } else { // 왼쪽 아래
                        rot = 2;
                        dir = 3;
                    }
                }
                break;
        }

        return rot;
    }
}
