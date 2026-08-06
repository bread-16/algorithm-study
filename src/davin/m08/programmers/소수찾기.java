package davin.m08.programmers;
import java.util.*;

public class 소수찾기 {
	class Solution {
	    HashSet<Integer> set = new HashSet<>();
	    boolean[] visited = new boolean[7];
	    
	    public int solution(String numbers) {
	        int count=0;
	        
	        dfs(numbers, "");
	        
	        for(Integer num : set){
	           if(isPrime(num)) {
	               count++;
	               //System.out.println(num);
	           }
	        }
	        
	        return count;
	    }
	    
	    void dfs(String numbers, String s){
	        for(int i=0; i<numbers.length(); i++){
	            if(visited[i]==true) continue;
	            
	            visited[i]=true;
	            set.add(Integer.parseInt(s+numbers.charAt(i)));
	            dfs(numbers, s+numbers.charAt(i));
	            visited[i]=false;
	        }
	    }
	    
	    boolean isPrime(int num){
	        if (num==0) return false;
	        if (num==1) return false;
	        
	        for(int i=2; i<=Math.sqrt(num); i++){
	            if(num%i==0) return false;
	        }
	        return true;
	    }
	}
}
