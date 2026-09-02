package giseon.m09.A;

import java.io.*;
import java.util.*;

public class 키순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());

			// 각 인덱스별 자신보다 크거나 작은 학생의 수 배열(얼마나 알고 있는지) -> 이 수가 N - 1 이면 자신의 순서 알고 있음
			int[] known = new int[N + 1];
			// 각 인덱스마다 인접한 자신보다 작은 학생들을 원소로 가짐
			List<Integer>[] smallerThan = new ArrayList[N + 1];
			// 각 인덱스마다 인접한 자신보다 큰 학생들을 원소로 가짐
			List<Integer>[] tallerThan = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++) {
				smallerThan[i] = new ArrayList<>();
				tallerThan[i] = new ArrayList<>();
			}

			// 인접 리스트에 원소 삽입
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallerThan[a].add(b);
				smallerThan[b].add(a);
			}

			Queue<Integer> smallQ = new ArrayDeque<>();
			Queue<Integer> tallQ = new ArrayDeque<>();
			
			
			// 각 인접 리스트를 순회하면서 인접한 노드 만날 때마다 known[원소]++
			// 각 학생별로 출발하면서 수정하기
			for (int i = 1; i <= N; i++) {
				boolean[] smallVisited = new boolean[N + 1];
				smallQ.offer(i);
				smallVisited[i] = true;
				
				// smaller bfs
				while (!smallQ.isEmpty()) {
					int node = smallQ.poll();

					// 인접 리스트가 비어있지 않다면 순회 -> 비어있으면 어차피 0번 실행될거라 분기 필요 x
//					if (!smallerThan[node].isEmpty())
					for (int next : smallerThan[node]) {
						// 방문하지 않은 노드만 탐색
						if (!smallVisited[next]) {
							smallVisited[next] = true;
							known[i]++;
							smallQ.offer(next);								
						}
					} // for next end
				} // smaller bfs end

				boolean[] tallVisited = new boolean[N + 1];
				tallQ.offer(i);
				tallVisited[i] = true;

				// taller bfs
				while (!tallQ.isEmpty()) {
					int node = tallQ.poll();

					for (int next : tallerThan[node]) {
						// 방문하지 않은 노드만 탐색
						if (!tallVisited[next]) {
							tallVisited[next] = true;
							known[i]++;
							tallQ.offer(next);
						}
					} // for next end
				} // taller bfs end
				
			} // for i end
			
			// known이 N-1인 명 수 찾아서 sb.append
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if(known[i] == N-1) {
					count++;
				}
			}
			sb.append(count).append("\n");
		} // tc end
		System.out.print(sb);
	} // main end
	
} // class end
