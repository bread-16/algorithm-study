package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea3421 {
	static int N;
    static int M;
    static int ans;
    static boolean[] selected;
    static boolean[][] comx;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 재료 수
            M = Integer.parseInt(st.nextToken()); // 안 좋은 궁합 수
            comx = new boolean[N+1][N+1];
            selected = new boolean[N+1];
            
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                comx[u][v] = true;
                comx[v][u] = true;
            }
            
            ans = 0;
            dfs(1);
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        
        System.out.print(sb.toString());
    }
	
    static void dfs(int idx) {
        if (idx == N+1) {
            ans++;
            return;
        }
        // 안넣는 경우
        dfs(idx+1);
        // 넣는 경우
        if (isvalid(idx)) {
            selected[idx] = true;
            dfs(idx+1);
            selected[idx] = false;
        }
    }
    
    static boolean isvalid (int target) {
        for (int i = 1; i < target; i++) {
        	if (selected[i] && comx[i][target]) {
            	return false;
            }
        }
        return true;
    }
}
