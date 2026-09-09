package giseon.m09.SWEA;

import java.io.*;
import java.util.*;

public class 수제버거장인 {
	
	static int N, M;
	static int count;
	static List<Integer>[] graph; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 인접 리스트에 안되는 조합의 구성을 저장
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);				
			}
			
			count = 0;
			
			// 조합 문제이므로 되는 경우의 수를 확인하면서 탐색
			// 각 숫자부터 출발해서 나머지들을 뽑아 조합을 만들어간다.
			backTrack(1, 0); // 재료 1부터 시작, 비트마스킹으로 해당 재료 뽑았는지 확인할 것이므로
			
			sb.append('#').append(tc).append(' ').append(count).append('\n');
		} // tc end
		System.out.print(sb);
	} // main end
	
	static void backTrack(int current, int cantPick) {
		count++; // 공집합도 개수에 포함되므로 1개부터 시작되도록 하고 조건에 맞지 않으면 재귀가 시작되지 않게 조건을 설정했으므로 재귀 호출 횟수가 곧 조합 개수
		
		for (int i = current; i <= N; i++) {
			// 이미 뽑았거나 뽑으면 안되는 재료면 패스
			// and 연산에서 0이 아니면 그 자리가 1일 것이므로 뽑은 수가 됨 
			if ((cantPick & (1 << i)) != 0) continue;

			// 다음 조합 찾기 위해 뽑은 수 체크한 수를 그대로 넘겨주고 그래프에 있는 쓰면 안되는 조합 확인해서 체크
			int cantNext = cantPick;
			for (int next : graph[i]) {
				// 궁합이 맞지 않는 조합이면 뽑지 않도록 비트 체크
				cantNext |= (1 << next);
			}
			// 다른 조합 탐색
			backTrack(i+1, cantNext);
		}
		
	} // backTrack end
} // class end
