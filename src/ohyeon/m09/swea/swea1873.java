package ohyeon.m09.swea;

import java.util.*;
import java.io.*;

public class swea1873 {
	static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0, 0, -1, 1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] maps = new char[H][W];
            
            int r = 0, c = 0, dir = 0;
            
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                	maps[i][j] = line.charAt(j);
                    
                    if (maps[i][j] == '^') { r = i; c = j; dir = 0; maps[i][j] = '.'; }
                    else if (maps[i][j] == 'v') { r = i; c = j; dir = 1; maps[i][j] = '.'; }
                    else if (maps[i][j] == '<') { r = i; c = j; dir = 2; maps[i][j] = '.'; }
                    else if (maps[i][j] == '>') { r = i; c = j; dir = 3; maps[i][j] = '.'; }
                }
            }
            
            int N = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();
            
            for (char cmd : commands) {
                if (cmd == 'U') {
                    dir = 0;
                    int nr = r + dr[dir], nc = c + dc[dir];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && maps[nr][nc] == '.') {
                        r = nr; c = nc;
                    }
                } else if (cmd == 'D') {
                    dir = 1;
                    int nr = r + dr[dir], nc = c + dc[dir];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && maps[nr][nc] == '.') {
                        r = nr; c = nc;
                    }
                } else if (cmd == 'L') {
                    dir = 2;
                    int nr = r + dr[dir], nc = c + dc[dir];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && maps[nr][nc] == '.') {
                        r = nr; c = nc;
                    }
                } else if (cmd == 'R') {
                    dir = 3;
                    int nr = r + dr[dir], nc = c + dc[dir];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && maps[nr][nc] == '.') {
                        r = nr; c = nc;
                    }
                } else if (cmd == 'S') {
                    int currR = r, currC = c;
                    while (true) {
                        currR += dr[dir];
                        currC += dc[dir];
                        if (currR < 0 || currR >= H || currC < 0 || currC >= W) break;
                        if (maps[currR][currC] == '#') break; 
                        if (maps[currR][currC] == '*') { 
                            maps[currR][currC] = '.';
                            break;
                        }
                    }
                }
            }
            char[] tankChar = {'^', 'v', '<', '>'};
            maps[r][c] = tankChar[dir];
            
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < H; i++) {
                sb.append(new String(maps[i])).append("\n");
            }
        }
        System.out.print(sb);
	}
}
