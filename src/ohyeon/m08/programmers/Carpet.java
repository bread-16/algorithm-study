package ohyeon.m08.programmers;

public class Carpet {
	public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int[] answer = {};
        for (int h = 3; h<=total; h++) {
            if (total%h==0) {
                int w = total/h;
            
                if ((h-2)*(w-2)==yellow) {
                    answer = new int [] {w,h};
                    break;
                }
            }
        }    
        return answer;
    }
}
