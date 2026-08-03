package jinwoo.m08.programmers;

public class Carpet {
	public int[] solution(int brown, int yellow) {
		
		int num = 0;
		
		for(int i=1; i * i <= yellow; i++) {
			if(yellow % i == 0) {
				if(2*(i + yellow/i) + 4 == brown) num = i;
			}
		}

        int[] answer = {(yellow/num + 2),(num+2)};
        return answer;
    }
}
