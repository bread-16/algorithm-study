package giseon.m09.A;

import java.io.*;

public class 사칙연산유효성검사 {
	// 제시된 연산자의 종류를 저장해놓고 하나씩 비교하여 판별한다.
	static final char[] oper = {'+', '-', '*', '/'};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			
			// 연산 가능 여부 1: 가능 / 0: 불가능
			int answer = 1;
			
			// 노드 수 입력
			int N = Integer.parseInt(br.readLine().trim());
			
			// 한 줄씩 입력을 검사한다. 입력 형식: 노드번호, 연산자/숫자, left자식, right자식
			// 연산자일경우 - 자식이 숫자 2개로 입력 받았는지
			// 숫자일 경우 - 자식이 없는지
			// 위 조건을 만족하지 않으면 계산이 불가하므로 answer = 0
			for (int i = 0; i < N; i++) {
				// 자식이 있는지 토큰 단위로 배열에 저장하여 확인 / [0]: 노드 번호, [1]: root, [2]: left, [3]: right
				String[] values = br.readLine().split(" ");
				// 루트 노드
				String root = values[1];
				
				// 연산자인지 판별할 flag
				boolean isOper = false;
				
				// 루트 노드가 연산자인지 판별
				for (int j = 0; j < 4; j++) {
					if (root.charAt(0) == oper[j]) {
						isOper = true;
						break;
					}
				}
				
				// 만약 연산자라면
				if (isOper) {
					// 토큰 수(배열 길이)가 2인지 검사한다.
					if (values.length != 4) {
						answer = 0;
//						break; -> 한 테스트케이스에서 계산 불가 조건을 확인했더라도 입력을 계속 받아야하므로 break해버리면 안됨
					}
				}
				// 만약 숫자라면
				else {
					// 토큰 수(배열 길이)가 없는지 검사한다.
					if (values.length != 2) {
						answer = 0;
					}
				}
			}
			sb.append(answer).append("\n");
		} // tc end
		System.out.print(sb);
	} // main end
}
