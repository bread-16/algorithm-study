package jinyoung.m07.swea;

import java.util.*;
import java.io.*;

public class D3_1225 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int idx = 1; idx <= 10; idx++) {
			int[] arr = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int diff = 1;
			int tmp = 0;
			// 마지막 자리가 0보다 클동안 반복
			while (arr[7] > 0) {
				// 1씩 증가하는 diff 중간에 마지막 자리가 0보다 커질수도 있음
				while (diff < 6 && arr[7] > 0) {
					// arr[0]-diff tmp로 복사
					tmp = arr[0] - diff;
					// 하나씩 당김
					for (int i = 0; i < 7; i++) {
						arr[i] = arr[i + 1];
					}
					// 맨 뒤에 tmp 넣기
					arr[7] = (tmp >= 0) ? tmp : 0;
					diff++;
				}
				diff = 1;
			}
			sb.append("#").append(n).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(arr[i]);
				if (i == 7)
					sb.append("\n");
				else
					sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
