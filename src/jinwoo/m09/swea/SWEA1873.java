package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
	
	static char[][] map;
	static char[] command;
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int mapR;
	static int mapC;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			
			mapR = Integer.parseInt(st.nextToken());
			mapC = Integer.parseInt(st.nextToken());
			
			map = new char[mapR][mapC];
			
			int startR = 0;
			int startC = 0;
			
			for(int i=0; i<mapR; i++) {
				String line = in.readLine().trim();
				for(int j=0; j<mapC; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						startR = i; 
						startC = j;
					}
				}
			}
			
			int dir = 0;
			
			if(map[startR][startC] == '^') {
				dir = 0;
			} else if(map[startR][startC] == 'v') {
				dir = 1;
			} else if(map[startR][startC] == '<') {
				dir = 2;
			} else if(map[startR][startC] == '>') {
				dir = 3;
			}
			
			int inputNum = Integer.parseInt(in.readLine().trim());
			
			command = new char[inputNum];
			
			String inputCommand = in.readLine().trim();
			for(int i=0; i<inputNum; i++) {
				command[i] = inputCommand.charAt(i);
			}
			
			startGame(startR, startC, dir);
			
			sb.append("#").append(t+1).append(" ");
			for(int i=0; i<mapR; i++) {
				for(int j=0; j<mapC; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static public void startGame(int r, int c, int dir) {
		int locationR = r;
		int locationC = c;
		int d = dir;
		
		for(char cm : command) {
			if(cm == 'S') { // 슈팅
				int sR = locationR;
				int sC = locationC;
				while(true) {
					sR += dx[d];
					sC += dy[d];
					
					if(!inRange(sR, sC)) break;
					if(map[sR][sC] == '#')break;
					if(map[sR][sC] == '*') {
						map[sR][sC] = '.';
						break;
					}
				}
			} else if(cm == 'U') { // 상
				d = 0;
				int[] location = move(locationR, locationC, d);
				locationR = location[0];
				locationC = location[1];
			} else if(cm == 'D') { // 하
				d = 1;
				int[] location = move(locationR, locationC, d);
				locationR = location[0];
				locationC = location[1];
			} else if(cm == 'L') { // 좌
				d = 2;
				int[] location = move(locationR, locationC, d);
				locationR = location[0];
				locationC = location[1];
			} else if(cm == 'R') { // 우
				d = 3;
				int[] location = move(locationR, locationC, d);
				locationR = location[0];
				locationC = location[1];
			}
		}
		
		if(d == 0) {
			map[locationR][locationC] = '^';
		} else if(d == 1) {
			map[locationR][locationC] = 'v';
		} else if(d == 2) {
			map[locationR][locationC] = '<';
		} else if(d == 3) {
			map[locationR][locationC] = '>';
		}
	}
	
	static int[] move(int r, int c, int dir) {
		int nx = r + dx[dir];
		int ny = c + dy[dir];
		
		if(!inRange(nx,ny)) return new int[] {r,c};
		
		if(map[nx][ny] == '.') {
			map[r][c] = '.';
			return new int[] {nx, ny};
		} else {
			return new int[] {r,c};
		}
	}
	
	static boolean inRange(int r, int c) {
		return (r>=0 && r<mapR && c>=0 && c<mapC);
	}
}
