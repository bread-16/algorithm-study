package jinwoo.m08.programmers;

import java.util.ArrayList;

public class MockExam {

	 public int[] solution(int[] answers) {
		 
		 int[] s1 = {1,2,3,4,5};
		 int[] s2 = {2,1,2,3,2,4,2,5};
		 int[] s3 = {3,3,1,1,2,2,4,4,5,5};
		 
		 int s1Score = 0;
		 int s2Score = 0;
		 int s3Score = 0;
		 
		 for(int i=0; i<answers.length; i++) {
			 if(s1[i%5] == answers[i]) s1Score++;
			 if(s2[i%8] == answers[i]) s2Score++;
			 if(s3[i%10] == answers[i]) s3Score++;
		 }
		 
		 int maxNum = Math.max(s1Score, Math.max(s2Score, s3Score));
		 
		 ArrayList<Integer> list = new ArrayList<>();
		 
		 if(maxNum == s1Score) list.add(1);
		 if(maxNum == s2Score) list.add(2);
		 if(maxNum == s3Score) list.add(3);
		 
		 int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
	        return answer;
	    }
}
