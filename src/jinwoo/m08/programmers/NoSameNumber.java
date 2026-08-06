package jinwoo.m08.programmers;

import java.util.ArrayList;
import java.util.List;

public class NoSameNumber {
	 public int[] solution(int []arr) {

		 List<Integer> numbers = new ArrayList<>();
		 
		 numbers.add(arr[0]);
		 int num = 0;
		 
		 for(int i=1; i<arr.length; i++) {
			 if(numbers.get(num) != arr[i]) {
				 numbers.add(arr[i]);
				 num++;
			 }
		 }
		 
		 int[] answer = new int[numbers.size()];
		 int idx=0;
		 
		 for (Integer number : numbers) {
			answer[idx++] = number;
		}

	        return answer;
	    }
}
