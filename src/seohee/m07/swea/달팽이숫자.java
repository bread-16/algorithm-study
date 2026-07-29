package seohee.m07.swea;

import java.io.*;

public class 달팽이숫자 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= testcase; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];

            // 시작
            int cx = 0, cy = 0, d = 0;
            int num = 1;
            arr[cx][cy] = num;

            for (int i = n - 1; i >= 1; i--) {
                int cnt = (i == n - 1) ? 3 : 2;

                while (cnt-- > 0) {
                    for (int j = 0; j < i; j++) {
                        cx += dx[d];
                        cy += dy[d];
                        arr[cx][cy] = ++num;
                    }
                    d = (d + 1) % 4;
                }
            }

            // 결과 StringBuilder에 추가
            sb.append("#").append(t).append("\n");
            for (int[] ar : arr) {
                for (int a : ar) {
                    sb.append(a).append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}
