package jaewon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

//		배열의 크기는 항상 100*100 동일
		int[][] arrayMap = new int[101][101];

//		 총 10개의 테스트 케이스
		for (int T = 1; T <= 10; T++) {
			int testCase = Integer.parseInt(in.readLine());

			int[] rowArr = new int[100];
			int[] colArr = new int[100];
			int rightDiagonal = 0;
			int leftDiagonal = 0;

//			이중 배열로 arrayMap 갱신
//			행 최댓값: maxRow[i]중 최댓값
//			열 최댓값: maxCol[j]중 최댓값
//			오른쪽 대각선 최댓값: i+j=100
//			왼쪽 대각선 최댓값: i==j
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 100; j++) {
					arrayMap[i][j] = Integer.parseInt(st.nextToken());
					colArr[j] += arrayMap[i][j];
					rowArr[i] += arrayMap[i][j];
					if (i == j)
						leftDiagonal += arrayMap[i][j];
					if (i + j == 100)
						rightDiagonal += arrayMap[i][j];

				}

			}

			int rowMax = 0;
			int colMax = 0;

			for (int i = 0; i < 100; i++) {
				rowMax = Math.max(rowMax, rowArr[i]);
				colMax = Math.max(colMax, colArr[i]);
			}

			int temp1 = Math.max(rowMax, colMax);
			int temp2 = Math.max(leftDiagonal, rightDiagonal);

			int result = Math.max(temp1, temp2);

			sb.append("#").append(T).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
