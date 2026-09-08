package jinwoo.m09.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 장기말포 {
	// 상 하 좌 우
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int N;
    static int[][] map;

    // 모든 경우의 수 중 한 번이라도 잡을 수 있었던 말
    static boolean[][] canCatch;

    static int startR;
    static int startC;

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(in.readLine().trim());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(in.readLine().trim());

            map = new int[N][N];
            canCatch = new boolean[N][N];

            for (int i = 0; i < N; i++) {

                StringTokenizer st = new StringTokenizer(in.readLine());

                for (int j = 0; j < N; j++) {

                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    }
                }
            }

            map[startR][startC] = 0;

            dfs(0, startR, startC);

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (canCatch[i][j]) {
                        answer++;
                    }
                }
            }

            sb.append("#").append(t+1).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int r, int c) {

        // 이미 3번 움직였으면 종료
        if (depth == 3) {
            return;
        }

        for (int d = 0; d < 4; d++) {

            int nr = r + dx[d];
            int nc = c + dy[d];

            boolean jumped = false;

            while (inRange(nr, nc)) {
                if (!jumped) {

                    if (map[nr][nc] == 1) {
                        jumped = true;
                    }

                } else {
                    if (map[nr][nc] == 0) {
                        dfs(depth + 1, nr, nc);
                    } else if (map[nr][nc] == 1) {
                        canCatch[nr][nc] = true;
                        map[nr][nc] = 0;

                        dfs(depth + 1, nr, nc);
                        
                        map[nr][nc] = 1;
                        break;
                    }
                }

                nr += dx[d];
                nc += dy[d];
            }
        }
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
