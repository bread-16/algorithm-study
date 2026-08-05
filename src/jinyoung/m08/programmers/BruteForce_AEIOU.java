package jinyoung.m08.programmers;

class Solution {
    String word;
	char[] aeiou= {'A','E','I','O','U'};
	int cnt= 0;
	int answer= 0;
    
    public int solution(String word) {
        this.word=word;
        dfs("",0);
        return answer;
    }
    
    public void dfs(String s, int depth) {
		if(s.equals(word)) {
			answer=cnt;
		}
        if(depth>=aeiou.length) {
			return;
		}
        for(int i=0;i<aeiou.length;i++) {
			cnt++;
			dfs(s+aeiou[i],depth+1);
		}
    }
}

/*
public class BruteForce_AEIOU {
	public static String word = "AAAE";
	public static char[] aeiou= {'A','E','I','O','U'};
	public static int cnt= 0;
	public static int answer= 0;
	
	public static void dfs(String s, int depth) {
		if(s.equals(word)) {
			System.out.println("cnt: "+cnt);
			answer=cnt;
		}
		if(depth>=aeiou.length) {
			return;
		}
		
		for(int i=0;i<aeiou.length;i++) {
			cnt++;
			System.out.println((s+aeiou[i])+"  "+cnt);
			dfs(s+aeiou[i],depth+1);
		}
	}
	
	public static void main(String[] args) {
		dfs("",0);
	}
}
*/
