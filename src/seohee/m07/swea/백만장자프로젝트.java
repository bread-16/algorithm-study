package seohee.m07.swea;

import java.io.*;
import java.util.*;

public class 백만장자프로젝트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = arr[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (arr[i] < max) {
                    answer += max - arr[i];
                } else {
                    max = arr[i];
                }
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
