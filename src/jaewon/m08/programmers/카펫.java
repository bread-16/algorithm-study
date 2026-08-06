package jaewon.m08.programmers;

public class 카펫 {

	public int[] solution(int brown, int yellow) {
		int[] answer = {};

		int total = brown + yellow; // w*h
		int sum = (brown + 4) / 2; // w+h

		for(int h=3 ; h<=sum/2 ; h++) {
			int w = sum-h;
			if(w*h == total)
				return new int[]{w,h};
		}
		return answer;
	}

}
