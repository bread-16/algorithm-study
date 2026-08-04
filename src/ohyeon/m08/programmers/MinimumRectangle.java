package ohyeon.m08.programmers;

public class MinimumRectangle {
	public int solution(int[][] sizes) {
        
        int maxheight = 0;
        int maxwidth = 0;
        for(int [] card : sizes) {
            int l = Math.max(card[0], card[1]);
            int s = Math.min(card[0], card[1]);
            
            maxwidth = Math.max(maxwidth , l);
            maxheight = Math.max(maxheight, s);
        }
        
        return maxwidth*maxheight;
    }
}