package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class swea2001 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M =Integer.parseInt(st.nextToken());
            int[][] matrix = new int [N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int maxKill = 0;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int currentKill = 0;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            currentKill += matrix[i+k][j+l];
                        }
                    }
                    maxKill = Math.max(maxKill, currentKill);
                }
            }
            sb.append("#").append(tc).append(" ").append(maxKill).append("\n");
        }
        System.out.print(sb.toString());
	}
}
