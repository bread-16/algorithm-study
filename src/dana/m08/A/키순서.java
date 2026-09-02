package dana.m08.A;

import java.io.*;
import java.util.*; 

public class 키순서 {
	
	static int N, M; 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine()); 
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine()); 
			
			/*
			 * graph = small -> big 
			 * reverse = big -> small 
			 * */
			ArrayList<Integer>[] graph = new ArrayList[N+1]; 
			ArrayList<Integer>[] reverse = new ArrayList[N+1]; 
			
			for (int i = 1; i <= N; i++) {
				graph[i] = new ArrayList<>(); 
				reverse[i] = new ArrayList<>(); 
			}
			
			// a -> b를 graph와 reverse에 넣어주기 
			for (int m = 0; m < M; m++) {
				StringTokenizer st = new StringTokenizer(br.readLine()); 
				
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				
				graph[a].add(b); 
				reverse[b].add(a); 
			}
			
			int answer = 0; 
			// 각 키(노드) 마다 DFS 
			for (int i = 1; i <= N; i++) {
				int taller = dfs(i, graph); 
				int shorter = dfs(i, reverse); 
				// 만약 조건에 맞으면 , 답 ++ 
				if (taller + shorter == N - 1) {
					answer++; 
				}
			}
			// sb 
			sb.append("#").append(tc).append(" ").append(answer).append("\n"); 
		}
		// print 
		System.out.print(sb);
	}
	
	// DFS 
	static int dfs(int start, ArrayList<Integer>[] graph) {
		boolean[] visited = new boolean[N+1]; 
		Stack<Integer> stack = new Stack<>(); 
		// start넣어주기 
		stack.add(start); 
		visited[start] = true; 
		
		int count = 0; 
		while(!stack.isEmpty()) {
			int current = stack.pop();
			// current 노드의 children 탐방 
			for (int num : graph[current]) {
				if (!visited[num]) {
					visited[num] = true; 
					stack.add(num); 
					count++; 
				}
			}
		}
		return count; 
	}

}
