package davin.m08.programmers;

public class 카펫 {
	class Solution {
	    public int[] solution(int brown, int yellow) {
	        int yWidth;
	        int yHeight;
	        
	        for(int i =1; i<=Math.sqrt(yellow); i++){
	            if(yellow%i==0){
	                yHeight = i;
	                yWidth=yellow/i;
	                if((brown+yellow)== (yWidth+2)*(yHeight+2)){
	                    return new int[] {yWidth+2, yHeight+2};
	                }
	            }
	            
	        }
	    return new int[] {};
	    }
	}
}
