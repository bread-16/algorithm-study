package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class CropHarvest_D3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(in.readLine());
		
		for(int t=0; t<test_case; t++) {
			
			int arrlen = Integer.parseInt(in.readLine());
			
			int[][] arr = new int[arrlen][arrlen];
			
			for(int i=0; i<arrlen; i++) {
				String numbers = in.readLine();
				for(int j=0; j<arrlen; j++) {
					arr[i][j] = numbers.charAt(j) - '0';
				}
			}
			
			// 대각선으로 가는 4방향 설정 - (아래,왼쪽), (아래,오른쪽), (위,오른쪽), (위,왼쪽)
			int[] dx = {1, 1, -1, -1};
			int[] dy = {-1, 1, 1, -1};
			
			int sum = 0;
			
			// 시작 위치(arr[0][배열길이/2] 기준으로 대각선을 탐색하며 sum에 값 축적
			for(int i=0; i<arrlen/2; i++) {
				int nx = i;
				int ny = arrlen/2;
				int n = 0;
				
				boolean tb = true;
				
				while(tb) {
					//한쪽 대각선으록 계속이동
					nx += dx[n];
					ny += dy[n];
					// 대각선 끝에 도달했을시 다른 다음 대각선 탐색, 4방향 탐색시 끝내기
					if(nx < i || nx >= arrlen - i || ny < i || ny >=arrlen - i) {
						nx -= dx[n];
						ny -= dy[n];
						n++;
						if(n == 4) {
							tb = false;
						}
					} else {
						sum += arr[nx][ny];
					}
					
				}
			}
			// 한가운데 값 더하기
			sum += arr[arrlen/2][arrlen/2];
			
			sb.append("#").append(t+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
