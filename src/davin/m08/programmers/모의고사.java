package davin.m08.programmers;

public class 모의고사 {

	import java.util.*;

	class Solution {
	    public int[] solution(int[] answers) {
	        int[] n1 = {1,2,3,4,5};
	        int[] n2 = {2,1,2,3,2,4,2,5};
	        int[] n3 = {3,3,1,1,2,2,4,4,5,5};
	        
	        int[] count = new int[3];
	        
	        int n = answers.length;
	        
	        
	        for(int i=0; i<n ;i++){
	            if (answers[i]==n1[i%5]) count[0]++;
	            if (answers[i]==n2[i%8]) count[1]++; 
	            if (answers[i]==n3[i%10]) count[2]++; 
	        }
	        
	        int max = Math.max(count[0], Math.max(count[1], count[2]));
	        
	        ArrayList<Integer> ans = new ArrayList<>();
	        
	        for(int i=0; i<3 ;i++){
	            if(max==count[i]){
	                ans.add(i+1);
	            }
	        }

	        return ans.stream().mapToInt(x-> x).toArray();
	    }  
	}
	
//	class Solution {
//	    public int[] solution(int[] answers) {
//	        int[] n1 = {1,2,3,4,5};
//	        int[] n2 = {2,1,2,3,2,4,2,5};
//	        int[] n3 = {3,3,1,1,2,2,4,4,5,5};
//	        
//	        int n1Count=0, n2Count=0, n3Count=0;
//	        
//	        int n = answers.length;
//	        for(int i=0; i<n ;i++){
//	            if (answers[i]==n1[i%5]) n1Count++;
//	            if (answers[i]==n2[i%8]) n2Count++; 
//	            if (answers[i]==n3[i%10]) n3Count++; 
//	        }
//	        
//	        int max = Math.max(n1Count, Math.max(n2Count, n3Count));
//	        
//	        if(n1Count==n2Count && n1Count==n3Count)  {
//	            return new int[] {1, 2, 3};
//	        }
//	        else if (max==n3Count && n2Count==n3Count) {
//	            return new int[] {2, 3};
//	        }
//	        else if (max==n3Count && n1Count==n3Count) {
//	            return new int[] {1, 3};
//	        }
//	        else if (max==n2Count && n1Count==n2Count) {
//	            return new int[] {1, 2};
//	        }
//	        else if (max==n1Count){
//	            return new int[] {1};
//	        }
//	        else if (max==n2Count){
//	            return new int[] {2};
//	        }
//	        else if (max==n3Count){
//	            return new int[] {3};
//	        }
//	        
//	        return new int[] {0};
//	    }  
//	}
	
	
	
}
