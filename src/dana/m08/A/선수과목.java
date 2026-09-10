package dana.m08.A;

import java.util.*;
import java.io.*; 

public class 선수과목 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		// 입력: 과목의 수 N (= node numbers? )
		int N = Integer.parseInt(br.readLine()); 
		// 입력: 과목 관계 M 
		int M = Integer.parseInt(br.readLine()); 
		
		// 1. indegree 
		int[] indegree = new int[N + 1]; 
		// 2. graph 생성 (각 노드마다 children 저장)
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 
		// 2.1. 텅 빈 [] 로 시작 
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>()); 
		}
		
		// 3. 각 관계 읽기 
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			// a -> b 
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()); 
			// 그래프에 추가하기 
			graph.get(a).add(b);
			// indegree 업데이트하기 
			indegree[b]++; 
		}
		
		// 4. Queue 생성하기 
		Queue<Integer> queue = new LinkedList<>(); 
		// 5. Indegree 가 0인 노드 찾기 (시작점) 
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				queue.add(i); 
			}
		}
		
		// 6. 위상정렬 본격 시작
		// semester[i] = i번 과목을 들을 수 있는 최소 학기
		int[] semester = new int[N + 1]; 
		while (!queue.isEmpty()) { 
			// result 에 추가해주기 
			int curr = queue.poll(); 
			// curr 노드의 children의 indegree 1씩 줄여주기 
			for (int next : graph.get(curr)) {
				indegree[next]--; 
				// 만약 indegree 가 0이 됬다면 queue에 추가 
				if (indegree[next] == 0) {
					queue.add(next);
					semester[next] = semester[curr] + 1; 
				}
			}
		}
		
		// 7. 결과 출력 
		for (int i = 1; i <= N; i++) {
			sb.append(semester[i]).append(" "); 
		}
		System.out.println(sb); 
	}
}
