package jinwoo.m08.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ReturnToBase {
	int[] answer;
    List<List<Integer>> graph;
    int[] distance;
    Deque<Integer> dq;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        answer = new int[sources.length];

        graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            graph.get(road[0] - 1).add(road[1]);
            graph.get(road[1] - 1).add(road[0]);
        }
        
        distance = new int[n];
        
        Arrays.fill(distance, -1);
        
        distance[destination - 1] = 0;
        dq = new ArrayDeque<>();
        dq.offer(destination);
        bfs(destination);

        for(int i=0; i<answer.length; i++) {
        	answer[i] = distance[sources[i] - 1];
        }
        
        return answer;
    }
    
    public void bfs(int destination) {
    	
    	while(!dq.isEmpty()) {
    		int num = dq.poll();
    		
    		for(int i=0; i<graph.get(num-1).size(); i++) {
    			
    			int next = graph.get(num - 1).get(i);

    		    if(distance[next - 1] != -1) continue;

    		    distance[next - 1] = distance[num - 1] + 1;

    		    dq.offer(next);
    			
    		}
    	}
    }
}
