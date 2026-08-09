package dana.m08.programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers12906 {
	
	public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>(); 
                
        for (int n : arr) {
            // 아무것도 없으면 숫자 넣기 !
            if (answer.isEmpty()) {
                answer.add(n); 
            }
            // 숫자 있을때: 전 숫자와 현재 다르면 넣기 
            else if ( n != answer.get(answer.size() - 1) ) {
                answer.add(n); 
            } 
        }
        
        // int[] arr를 리턴해야 되니까 리스트를 int[] arr로 바꿔주기 
        int sizeOfList = answer.size(); 
        int[] finalAnswer = new int[sizeOfList]; 
        
        for (int i = 0; i < sizeOfList; i++) {
            finalAnswer[i] = answer.get(i); 
        }

		return finalAnswer;
	}

}
