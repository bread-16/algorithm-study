package jaewon.m08.programmers;

import java.util.Arrays;
// 풀이 시간: 30분
// 실행 속도: 0.02ms
// 메모리: 81.8MB
public class Programmers42840 {
	class Solution {
	    public int[] solution(int[] answers) {

	        int[] supo1 = {1,2,3,4,5};
	        int[] supo2 = {2,1,2,3,2,4,2,5};
	        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
	        
	        int supo1Idx = 0;
	        int supo2Idx = 0;
	        int supo3Idx = 0;
	        
	        int supo1Cnt = 0;
	        int supo2Cnt = 0;
	        int supo3Cnt = 0;
	        
	        for(int i=0 ; i<answers.length ; i++) {
	        	if(answers[i] == supo1[supo1Idx]) {
	        		supo1Cnt++;
	        	}
	        	if(answers[i] == supo2[supo2Idx]) {
	        		supo2Cnt++;
	        	}
	        	if(answers[i] == supo3[supo3Idx]) {
	        		supo3Cnt++;
	        	}
	        	
	        	supo1Idx++;
	        	supo2Idx++;
	        	supo3Idx++;
	        	
	        	if(supo1Idx >= 5) {
	        		supo1Idx = 0;
	        	}
	        	if(supo2Idx >= 8) {
	        		supo2Idx = 0;
	        	}
	        	if(supo3Idx >= 10) {
	        		supo3Idx = 0;
	        	}
	        }
	        
	        int max = Math.max(supo1Cnt, Math.max(supo2Cnt, supo3Cnt));
	        
	        int[] temp = new int[3];
	        int idx = 0;
	        if(max == supo1Cnt) temp[idx++] = 1;
	        if(max == supo2Cnt) temp[idx++] = 2;
	        if(max == supo3Cnt) temp[idx++] = 3;
	        
	        return Arrays.copyOf(temp, idx);
	    }
	}
}
