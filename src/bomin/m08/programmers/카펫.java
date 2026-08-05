package bomin.m08.programmers;

public class 카펫 {
	public int[] solution(int brown,int yellow) {
		int[] answer = {};
		//노란색 개수 -> 곱으로 판별. 인자값 중 높은 것을 가로 길이로 체크
		//노란색 쌍 구해서 갈색 개수로 정확히 테두리 감쌀 수 있는지 체크
		// 둘레 -> 2(가로+세로) + 4
		//노란색 가로/세로 기준으로 -> +2씩.
		
		
		
		for(int i=1 ; i<= yellow; i++) {
			if(yellow % i == 0) {
				int x = yellow / i;
				if(x >= i && (x+i)*2 + 4 == brown) {
					answer = new int[]{x+2,i+2};
				}
			}
		}
		
		
		
		
		return answer;
	}
}
