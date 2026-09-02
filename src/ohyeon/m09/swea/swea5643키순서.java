package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea5643키순서 {
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
             
            boolean[][] student = new boolean [N+1][N+1];
             
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                student[a][b] = true;
            }
             
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for(int k = 1; k <= N; k++) {
                        if (student[i][j] && student[j][k]) {
                            student[i][k] = true;
                        }
                    }
                }
            }
             
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    if ( student[i][j] || student[j][i]) {
                        count++;
                    }
                }
                if (count == N - 1) {
                    answer++;
                }
            }
             
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb.toString());
    }
}
