package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 나무높이 {
	static int answer;
	static int diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= T; tc++) {
			// 출력 형식 세팅
			sb.append("#").append(tc).append(" ");
			
			// 나무 개수 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			// 나무 높이 저장할 배열
			Integer[] trees = new Integer[N];
			// 나무 높이 입력
			st = new StringTokenizer(br.readLine());
			
			int pivot = -1;
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				pivot = Math.max(pivot, trees[i]); // 입력 받으면서 기준(최댓값) 추리기
			}
			// 내림차순 정렬 했을 때 맨 앞이 최댓값(부족한 나무들이 충족해야 하는 기준) -> 입력 받으면서 최댓값 추리면 되니까 정렬 필요 x
			// Arrays.sort(trees, (a, b) -> Integer.compare(b, a));
			
			// 나무 높이들을 각각 돌면서 차이값을 구한다.
			int[] diff = new int[N];
			// diff[0]은 나무 높이의 최댓값, 즉 충족해야하는 기준이므로 1부터 차이값을 구한다.
			// 각 나무별 차이값에  +1, +2 작업을 어떻게 분배할건지가 관건
			int one = 0;
			int two = 0;
			for (int i = 0; i < N; i++) {
				diff[i] = pivot - trees[i];
				// 차이값이 홀수면 +1 1회, 나머지는 +2로 작업하면 됨
				one += diff[i] % 2;
				two += diff[i] / 2;
			}
			
			// +1은 홀수일, +2는 짝수일에만 작업할 수 있으므로 전체 필요한 날짜를 최적화한다.
			// 2의 개수가 1의 개수보다 2이상 많을 때 +2를 +1 작업 2개로 변환하는 게 이득이므로 변환 작업
			// 1개 많을 때는 바꿔도 이득이 아니므로 2개 많을 때부터 변환하면 됨 
			while (two > one + 1) { // two - one >= 2를 바꾼 형태임
				two--;
				one+=2;
			}
			
			// 이때 +2 하나를 +1 두 개로 바꿀 수 있으니 +1/+2 작업 수가 비슷할수록 건너뛰는게 적어지므로 작업일수를 낭비하지 않는다.
			// +1의 개수: 2*one - 1과, +2의 개수: 2*two 중에 큰 걸(적어도 기준치를 다 만족해야 하므로)선택한다.
			answer = Math.max(2 * one - 1, 2 * two);
			
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}
