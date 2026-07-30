package jaewon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(in.readLine());
            int[][] snail = new int[N][N];
            // 우, 하, 좌, 상
            int[] dy = { 0, 1, 0, -1 };
            int[] dx = { 1, 0, -1, 0 };
            int dir = 0;
            int y = 0;
            int x = 0;
            snail[0][0] = 1;
            int current = 1;
            while (current < N * N) {
                int nextY = y + dy[dir];
                int nextX = x + dx[dir];
                if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < N && snail[nextY][nextX] == 0) {
                    y = nextY;
                    x = nextX;
                    snail[y][x] = ++current;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}