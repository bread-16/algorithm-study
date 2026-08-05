package dana.m08.programmers;

import java.util.List;
import java.util.ArrayList;

public class Programmers42840 {
	
    public int[] solution(int[] answers) {
        
        int[] firstPerson = {1, 2, 3, 4, 5};
        int[] secondPerson = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = {0, 0, 0};
        
        int ansLen = answers.length;
        for (int i = 0; i < ansLen; i++) {
            if (answers[i] == firstPerson[i%firstPerson.length]) scores[0]++;
            if (answers[i] == secondPerson[i%secondPerson.length]) scores[1]++;
            if (answers[i] == thirdPerson[i%thirdPerson.length]) scores[2]++;
        }
        
        // answer 
        List<Integer> answer = new ArrayList<>();
        int maxScore = Math.max(Math.max(scores[0], scores[1]), scores[2]);
        if (maxScore == scores[0]) answer.add(1);
        if (maxScore == scores[1]) answer.add(2);
        if (maxScore == scores[2]) answer.add(3);
        
        // turn List into int arr
        int[] finalAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size() ; i++) {
            finalAnswer[i]= answer.get(i);
        }
            
        return finalAnswer;
    }

}
