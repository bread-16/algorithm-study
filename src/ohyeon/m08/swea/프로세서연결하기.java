package ohyeon.m08.swea;

import java.util.*;
import java.io.*;

public class 프로세서연결하기 {
	static class Core implements Comparable<Core> {
        int r, c, distToBorder;
        
        Core(int r, int c, int N) {
            this.r = r;
            this.c = c;
            
            int minR = r;
            if (N - 1 - r < minR) {
                minR = N - 1 - r;
            }
            
            int minC = c;
            if (N- 1 - c < minC) {
                minC = N - 1 - c;
            }
            
            if (minR < minC) {
                this.distToBorder = minR;
            } else {
                this.distToBorder = minC;
            }
        }
        
        @Override
        public int compareTo(Core o) {
            return Integer.compare(this.distToBorder, o.distToBorder);
        }
    }
    static int N;
    static int [][] map;
    static ArrayList<Core> coreList;
    static int maxCoreCount;
    static int minWireLength;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            coreList = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i != 0 && i != N - 1 && j != 0 && j != N - 1) {
                            coreList.add(new Core(i, j, N));
                        }
                    }
                }
            }
            Collections.sort(coreList);
            
            maxCoreCount = 0;
            minWireLength = Integer.MAX_VALUE;
            
            dfs(0, 0, 0);
            
            sb.append("#").append(tc).append(" ").append(minWireLength).append("\n");
        }
        System.out.print(sb.toString());
    }
    
    static void dfs (int index, int coreCount, int wireLen) {
        if (coreCount + (coreList.size() - index) < maxCoreCount) {
            return;
        }
        
        if (index == coreList.size()) {
            if (coreCount > maxCoreCount) {
                maxCoreCount = coreCount;
                minWireLength = wireLen;
            } else if (coreCount == maxCoreCount) {
                if (wireLen < minWireLength) {
                    minWireLength = wireLen;
                }
            }
            return;
        }
        
        Core current = coreList.get(index);
        
        for (int d = 0; d < 4; d++) {
            if (canConnect (current, d)) {
                int len = setWire(current, d, 2);
                dfs(index + 1, coreCount + 1, wireLen + len);
                setWire(current, d, 0);
            }
        }
        
        dfs(index + 1, coreCount, wireLen);
    }
    
    static boolean canConnect (Core core, int dir) {
        int nr = core.r + dr[dir];
        int nc = core.c + dc[dir];
        
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (map[nr][nc] != 0) {
                return false;
            }
            nr += dr[dir];
            nc += dc[dir];
        }
        return true;
    }
    
    static int setWire(Core core, int dir, int type) {
        int length = 0;
        int nr =core.r +dr[dir];
        int nc = core.c +dc[dir];
        
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            map[nr][nc] = type;
            length++;
            nr += dr[dir];
            nc += dc[dir];
        }
        return length;
    }
}
