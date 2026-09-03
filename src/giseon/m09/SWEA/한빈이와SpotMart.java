package giseon.m09.SWEA;

import java.util.*;
import java.io.*;

public class 한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine().trim());
			int N = Integer.parseInt(st.nextToken()); // 마트에 있는 과자 수
			int M = Integer.parseInt(st.nextToken()); // 들고 갈 수 있는 최대 수용 무게
			
			int[] snacks = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			// 오름차순 정렬
			// 정렬해놓으면 큰 수가 오른쪽에 몰려있을 것이므로 투 포인터로 조정해가면서 최적합을 찾는다.
			Arrays.sort(snacks);
			
			int sum = -1; // 갱신되지 않으면  -1 출력해야하므로 초기값 설정
			// 투 포인터로 부분합 확인
			int p1 = 0;
			int p2 = N - 1;
			while (p1 < p2) {
				int partSum = snacks[p1] + snacks[p2];
				// 부분합이 M 이하면 검사하기
				if (partSum < M) { 
					// 만약 기존 합보다 크면 갱신하고 부분합 더 키우는 방향으로 가기
					if (sum < partSum) {
						sum = partSum;
					}
					p1++;
				} 
				// 만약 M에 딱 맞췄다면 그보다 초과할 순 없으므로 break;
				else if (partSum == M) {
					sum = partSum;
					break;
				}
				else if (partSum > M){ // M 초과할 경우에는 줄여줘야 하므로 p2 옮기기
					p2--;
				}
			} // while end
			sb.append(sum).append("\n");
		} // tc end 
		System.out.print(sb);
	} // main end
}
