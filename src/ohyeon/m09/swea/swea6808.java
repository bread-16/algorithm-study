package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea6808 {
	static int[] gyu = new int[9];
    static int[] inyoung = new int[9];
    static boolean[] visited = new boolean[19];
    static boolean[] permVisited = new boolean[9];
    static int[] currentPerm = new int[9];
    static int winCount, loseCount;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
           
            
            for (int i = 1; i < 19; i++) {
                visited[i] = false;
            }
            
            for (int i = 0; i < 9; i++) {
                gyu[i] = Integer.parseInt(st.nextToken());
                visited[gyu[i]] = true;
            }
            
            int idx = 0;
            for (int i = 1; i < 19; i++) {
                if (!visited[i]) {
                    inyoung[idx++] = i;
                }
            }
            
            winCount = 0;
            loseCount= 0;
            
            dfs(0);
            
            sb.append("#").append(tc).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.print(sb.toString());
	}
    
    static void dfs(int depth) {
        if (depth == 9) {
            compare();
            return;
        }
        for (int i = 0 ; i < 9; i++) {
            if (!permVisited[i]) {
                permVisited[i] = true;
                currentPerm[depth] = inyoung[i];
                dfs(depth + 1);
                permVisited[i] = false;
            }
        }
    }
    
    static void compare() {
        int gyuScore = 0;
        int inyoungScore = 0;
        
        for (int i = 0; i < 9; i++) {
            if (gyu[i] > currentPerm[i]) {
                gyuScore += (gyu[i] + currentPerm[i]);
            } else if (gyu[i] < currentPerm[i]) {
                inyoungScore += (gyu[i] + currentPerm[i]);
            }
        }
        
        if (gyuScore > inyoungScore) {
            winCount++;
        } else if (gyuScore < inyoungScore) {
            loseCount++;
        }
    }
}
