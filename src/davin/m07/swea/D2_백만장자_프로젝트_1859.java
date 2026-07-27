package davin.m07.swea;

import java.io.*;
import java.util.*;

public class D2_백만장자_프로젝트_1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long T = Integer.parseInt(br.readLine());

        for (long i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] price = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            long profit = 0;
            long max = price[N - 1];
            for (int k = N - 1; k >= 0; k--) {
                if (price[k] < max) profit += max - price[k];
                max = Math.max(max, price[k]);
            }

            sb.append("#").append(i + 1).append(" ").append(profit).append("\n");
        }
        System.out.println(sb);
    }
}