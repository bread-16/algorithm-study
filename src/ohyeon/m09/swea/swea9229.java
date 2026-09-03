package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea9229 {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
       
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] ai = new int [N];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ai[i] = Integer.parseInt(st.nextToken());
            }
            int max = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        int current = 0;
                        current = ai[i] + ai[j];
                        if (current <= M) {
                        max = Math.max(max, current);
                        }
                        else {
                            continue;
                        }
                    } 
                    else {
                        continue;
                    }
                }
            }
            
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb.toString());
	}
}
