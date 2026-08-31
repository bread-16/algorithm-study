package bomin.m08.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 미로1 {
	static int[][] map;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	static int answer;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			//테스트케이스 번호 버림
			br.readLine();
			answer = 0;
			map = new int[16][16];
			int[] start = new int[2];
			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					if(map[i][j] == 2) {
						start[0] = i;
						start[1] = j;
					}
				}
			}
			Queue<int[]> Q = new ArrayDeque<>();
			Q.offer(start);
			while(!Q.isEmpty()) {
				int[] temp =  Q.poll();
				for(int i=0;i<4;i++) {
					int nx = temp[0]+dr[i];
					int ny = temp[1]+dc[i];
					if(nx<0 || nx>= 16 || ny<0 || ny>=16)
						continue;
					if(map[nx][ny] == 1)
						continue;
					if(map[nx][ny] == 0) {
						map[nx][ny] = 1;
						Q.offer(new int[] {nx,ny});
					}
					if(map[nx][ny] == 3) {
						answer = 1;
						break;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
