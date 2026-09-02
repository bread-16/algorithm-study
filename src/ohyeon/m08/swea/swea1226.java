package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class swea1226 {
	static int[][] maze;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int t = 1; t <= 10; t++) {
            int tc = Integer.parseInt(br.readLine());
            maze = new int[16][16];
            visited = new boolean[16][16];
            
            int startR = -1;
            int startC = -1;
            
            for (int i = 0; i < 16; i++) {
                String line = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = line.charAt(j) - '0';
                    if (maze[i][j] == 2) {
                    	startR = i;
                   	 	startC = j;
                    }
                }
            }
            
            int result = bfs(startR, startC) ? 1 : 0;
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static boolean bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            if (maze[r][c] == 3) {
                return true;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c +dc[i];
                
                if (nr < 16 && nr >= 0 && nc < 16 && nc >= 0) {
                    if (!visited[nr][nc] && maze[nr][nc] != 1) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }       
        return false;
    }
}
