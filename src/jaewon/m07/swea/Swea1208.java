package jaewon.m07.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 총 10개의 테스트 케이스
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수
			int dumpCount = Integer.parseInt(in.readLine());
			// 각 상자의 높이값
			StringTokenizer st = new StringTokenizer(in.readLine());

			int[] box = new int[100];

			// 가로 길이 항상 100, 띄워쓰기 단위로 끊어 배열에 저장
			for (int i = 0; i < 100; i++) {
				int boxHeight = Integer.parseInt(st.nextToken());
				box[i] = boxHeight;
			}

			// 덤프 횟수만큼 반복문 동작
			while (dumpCount > 0) {
				int maxIdx = 0; // 최대높이 인덱스
				int minIdx = 0; // 최소높이 인덱스
				for (int i = 0; i < 100; i++) {
					// 최대높이 인덱스 갱신
					if (box[i] > box[maxIdx]) {
						maxIdx = i;
					}
					// 최소높이 인덱스 갱신
					if (box[i] < box[minIdx]) {
						minIdx = i;
					}
				}
				// 최대 높이에서 상자 하나 감소, 최소 높이에서 상자 하나 추가
				box[maxIdx]--;
				box[minIdx]++;
				dumpCount--;
			}
			int max = box[0], min = box[0];
			
			// 덤프 과정 이후 최대값, 최소값 설정
			for (int i = 1; i < 100; i++) {
				max = Math.max(max, box[i]);
				min = Math.min(min, box[i]);
			}
			int result = max - min;

			sb.append("#").append(testCase).append(" ").append(result).append("\n");

		}

		System.out.println(sb.toString());

	}

}
