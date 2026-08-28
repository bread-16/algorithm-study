package giseon.m08.SWEA;

import java.util.*;
import java.io.*;

public class 암호문2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			// 암호문 리스트
			List<String> list = new LinkedList<>();
			
			// 연결 리스트로 암호문 구성
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(i, st.nextToken());
			}
			
			// 명령문 개수
			int numInst = Integer.parseInt(br.readLine());

			// 명령문을 입력 받아서 객체로 생성하고 배열에 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < numInst; i++) {
				// 삽입일 경우 데이터도 객체에 같이 넣어서 배열에 삽입
				char type = st.nextToken().charAt(0);
				// 삽입 or 삭제 실행할 위치
				int x = Integer.parseInt(st.nextToken());
				// 데이터 개수
				int y = Integer.parseInt(st.nextToken());
				if (type == 'I') {					
					// 삽입 명령 실행
					for (int j = 0; j < y; j++) {
						list.add(x + j, st.nextToken());						
					}
				}
				// 삭제 타입 명령어일 경우 data는 따로 만들지 않고 배열에 삽입
				else if (type == 'D'){
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				}
			}
			// 명령 실행 후 암호문을 sb에 저장(앞의 10개 항만 출력하므로 10개만 넣으면 됨)
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");				
			}
			sb.append("\n");
		} // tc end
		System.out.print(sb);
	} // main end
}
