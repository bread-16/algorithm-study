package giseon.m09.SWEA;

import java.io.*;
import java.util.*;

public class 규영이와인영이의카드게임 {

	static boolean[] isSelected; // 선택한 카드는 중복을 허용하지 않으므로 상태 체크
	static int winCnt; 	// 규영이 기준 이긴 횟수
	static int loseCnt;	// 규영이 기준 진 횟수
	static int[] gyu; // 규영이가 뽑은 카드 저장 배열
	static int[] in; // 인영이가 뽑을 카드 저장 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// 규영이 카드를 배열에 저장해놓고, 인영이가 낼 수 있는 모든 카드의 경우의 수를 다 일일이 비교해서 이기는 거, 지는 것만 카운트
			gyu = new int[9];
			isSelected = new boolean[19]; // 1번부터 18번까지 사용
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				isSelected[gyu[i]] = true;
			}

			// 인영이 카드 새로 만들기
			in = new int[9];
			int p = 0;
			for (int i = 1; i <= 18; i++) {
				if (isSelected[i]) continue;
				in[p++] = i;
			}

			winCnt = 0;
			loseCnt = 0;
			// 인영이 카드 한 장씩 뽑으면서 재귀 dfs(백트래킹)
			dfs(0, 0, 0);

			sb.append(winCnt).append(" ").append(loseCnt).append("\n");
		} // tc end
		System.out.print(sb);
	} // main end

	static void dfs(int depth, int gyuSum, int inSum) {
		if (depth == 9) {
			if (gyuSum < inSum) {
				loseCnt++;
			} else if (gyuSum > inSum) {
				winCnt++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[in[i]]) continue;
			
			isSelected[in[i]] = true;
			if (gyu[depth] > in[i]) {
				dfs(depth+1, gyuSum + gyu[depth] + in[i], inSum);
			} else {
				dfs(depth+1, gyuSum, inSum + gyu[depth] + in[i]);
			}
			isSelected[in[i]] = false;
		} // for i end
		
	} // dfs end
	
} // class end
