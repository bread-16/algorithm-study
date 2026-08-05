package jinwoo.m08.programmers;

import java.util.ArrayList;
import java.util.List;

public class PowerGrid {
	
	 static List<Integer>[] linkedWires;
	    static boolean[] visited;

	    public int solution(int n, int[][] wires) {

	        int answer = Integer.MAX_VALUE;

	        linkedWires = new ArrayList[n + 1];

	        for (int i = 1; i <= n; i++) {
	            linkedWires[i] = new ArrayList<>();
	        }

	        // 인접 리스트 생성
	        for (int[] wire : wires) {
	            linkedWires[wire[0]].add(wire[1]);
	            linkedWires[wire[1]].add(wire[0]);
	        }


	        // 전선 하나씩 끊어보기
	        for (int[] wire : wires) {

	            visited = new boolean[n + 1];

	            // wire[0]에서 시작해서 wire[1]로 가는 길을 제외
	            int first = dfs(wire[0], wire[1]);

	            int second = n - first;

	            answer = Math.min(answer, Math.abs(first - second));
	        }


	        return answer;
	    }


	    public int dfs(int node, int except) {

	        visited[node] = true;

	        int count = 1;

	        for (int next : linkedWires[node]) {

	            // 끊은 전선이면 이동하지 않음
	            if (next == except) continue;

	            if (!visited[next]) {
	                count += dfs(next, node);
	            }
	        }

	        return count;
	    }
}
