package davin.m08.programmers;

public class 최소직사각형 {

	import java.util.*;

	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        for(int[] size : sizes){
	            Arrays.sort(size);
	        }
	        
	        int firstMax =0;
	        int secondMax =0;
	        int n= sizes.length;
	        
	        for(int i=0; i<n; i++){
	            firstMax= Math.max(sizes[i][0], firstMax);
	            secondMax= Math.max(sizes[i][1], secondMax);
	        }
	         
	        return firstMax*secondMax;
	    }
	}

}
