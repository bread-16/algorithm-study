package dana.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers42839 {
	
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    int n;
    String numbers;
    
    public int solution(String numbers) {
        n = numbers.length();
        this.numbers = numbers;
        visited = new boolean[n];
        
        int answer = 0;
        dfs(new StringBuilder());
        
        // Set에 있는 후보 숫자가 소수인지 확인하고 세기
        for (int num : set) {
            if (isPrime(num)) answer++; 
        }
        return answer;
    }
    
    // dfs helper function 
    void dfs(StringBuilder sb) {
        
        if (sb.length() > 0) {
            set.add(Integer.parseInt(sb.toString()));
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            sb.append(numbers.charAt(i));
            
            dfs(sb);
            
            // backtracking: 방금 넣은 애를 빼기
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
    
    // isPrime helper function
    boolean isPrime(int n) {
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) cnt++;
        }
        
        if (cnt == 2) return true;
        else return false;
    }

}
