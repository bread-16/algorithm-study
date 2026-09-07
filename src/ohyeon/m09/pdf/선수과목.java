package ohyeon.m09.pdf;

import java.io.*;
import java.util.*;

public class 선수과목 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
        	graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N+1];
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	graph.get(A).add(B);
        	indegree[B]++;
        }
        
        int[] semester = new int[N + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= N; i++) {
        	if (indegree[i] == 0) {
        		queue.offer(i);
        		semester[i] = 1;
        	}
        }
        
        while(!queue.isEmpty()) {
        	int curr = queue.poll();
        	
        	for (int next : graph.get(curr)) {
        		semester[next] = Math.max(semester[next], semester[curr]+1);
        		indegree[next]--;
        		if (indegree[next] == 0) {
        			queue.offer(next);
        		}
        	}
        }
        for (int i = 1; i <= N; i++) {
        	sb.append(semester[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}