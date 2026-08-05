package bomin.m08.programmers;

public class 모음사전 {
	int count=0;
	char[] voArr= {'A','E','I','O','U'};
	boolean found = false;
	public int solution(String word) {
		
		
		
		
		dfs(word,"");
		
		return count;
	}
	
	public void dfs(String word, String vowel) {
		if(word.equals(vowel)) {
			// 다른 조건을 넣지 않으면 부모 DFS가 계속 돌아가서 count가 계속 늘어남.. -> boolean 추가
			found = true;
			return;
		};
		
		if(vowel.length() == 5) return;
		
		for(int i=0;i< voArr.length;i++) {
				count++;
				dfs(word,vowel + voArr[i]);
				// 부모 함수에서 확인하는 boolean
				if(found) return;
		}
	}
}
