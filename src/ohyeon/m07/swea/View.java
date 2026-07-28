/**
문제: D3 1206. [S/W 문제해결 기본] 1 일차 - View
시간: 96ms
메모리: 28,544 kb
시간복잡도: O(N)
푸는 데 걸린 시간 : 50분
전략 
검사하려는 대상기준으로 양 옆으로 2칸씩 총 길이가 5인 배열 생성
그 배열에서 검사하려는 대상이 최댓값이면 
검사하려는 대상에서 그 대상을 제외한 배열에서 최댓값의 차를 구함.
반복문으로 모든 건물을 검사한 뒤 차를 totalView에 더함.
*/

package ohyeon.m07.swea;

import java.util.*;
import java.io.*;

public class View {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] buildings = new int[N];
			int totalView = 0;
			for (int j = 0; j < N; j++) {
				buildings[j] = Integer.parseInt(st.nextToken());
			}
			for (int k = 2; k < N - 2; k++) {
				int[] check = new int[5];
				int index = 0;
				for (int l = k - 2; l < k + 3; l++) {
					check[index] = buildings[l];
					index++;
				}
				int leftMax = Math.max(check[0], check[1]);
				int rightMax = Math.max(check[3], check[4]);

				int aroundMax = Math.max(leftMax, rightMax);

				if (check[2] > aroundMax) {
					totalView += (check[2] - aroundMax);
				}
			}
			System.out.println("#" + (i + 1) + " " + totalView);
		}
	}
}