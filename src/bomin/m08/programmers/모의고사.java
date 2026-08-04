package bomin.m08.programmers;

public class 모의고사 {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] supo1 = new int[answers.length];
		int[] supo2 = new int[answers.length];
		int[] supo3 = new int[answers.length];
		int[] ex2 = {2,1,2,3,2,4,2,5};
		int[] ex3 = {3,3,1,1,2,2,4,4,5,5};
		
		int[] count = new int[3];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < answers.length; i++) {
			supo1[i] = (i % 5) + 1;
			supo2[i] = ex2[i%8];
			supo3[i] = ex3[i%10];
			
		}
		
		for(int i=0;i<answers.length;i++) {
			if(answers[i] == supo1[i]) {
				count[0]++;
			}
			if(answers[i] == supo2[i]) {
				count[1]++;
			}
			if(answers[i] == supo3[i]) {
				count[2]++;
			}
		}
		
		for(int i=0;i<3;i++) {
			if(count[i]>=max) {
				max = Math.max(count[i],max);
			}
		}
		
		int winnerCount = 0;
		for(int i=0;i<3;i++) {
			if(max == count[i])
				winnerCount++;
		}
		answer = new int[winnerCount];
		
		int index = 0;
		for(int i=0;i<count.length;i++) {
			if(count[i] == max) {
				answer[index] = i+1;
				index++;
			}
		}
		//배열 값이 [1], [1,2,3]이 나올 수 있는데, 이걸 한번에 초기화하는법?-> winnerCount 변수 하나 추가해서, 다시 쭉 돌려보기
		
		
		
		
		return answer;
	}
}
