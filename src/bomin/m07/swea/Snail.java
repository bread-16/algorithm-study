package bomin.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snail {

	// 방향은 우 하 좌 상 순서.
	// N * N 일때, 처음에만 N, 다음부턴 방향 전환 2번마다 N-1..N-2.. 이런식으로 줄어듬.
	// 규칙 찾아서 방향이랑 같이 for문 돌려주면 될 것 같다.
	// 방향은 4개로 반복해서 for문 돌려야하는데 방법이..? -> /로 몫만 구하기..
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] snail = solve(n);
			
			sb.append("#")
			.append(tc)
			.append("\n");
			
			for(int i = 0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sb.append(snail[i][j]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
		
	}
	
	static int[][] solve(int n){
		int[][] snail = new int[n][n];
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		int count = 1;
		int r = 0;
		int c = -1;
		
		int turn = 0;
		int moveCount = n;
		//n-> n-1 -> n-2-> n-3 ... 1까지, 방향 2번 변화 -> 수 change, count는 지속적으로
		
		while(count <= n * n) {
			int dir = turn % 4;
			
			for(int i=0; i<moveCount; i++) {
				r += dr[dir];
				c += dc[dir];
				snail[r][c] = count++;
			}
			//이동 후 방향 전환
			turn++;
			
			
			//방향전환 2번마다 숫자 -1.
			if(turn % 2 == 1) {
				moveCount--;
			}
			
			
		}
		
		
		return snail;
	}
	
}
