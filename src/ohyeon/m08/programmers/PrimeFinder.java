package ohyeon.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class PrimeFinder {
	Set<Integer>  numberSet = new HashSet<Integer>();
    boolean[] visited;
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        
        for (int goal = 1; goal <= numbers.length(); goal++) {
            dfs(0, goal, "", numbers);
        }
        
        int count = 0;
        for (int num : numberSet) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
    private void dfs(int depth, int GOAL, String current, String numbers) {
        if (depth == GOAL) {
            numberSet.add(Integer.parseInt(current));
            return;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;                              
                dfs(depth + 1, GOAL, current + numbers.charAt(i), numbers);
                visited[i] = false;                            
            }
        }
    }
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
