package jinwoo.m08.programmers;

public class ChangeWord {
	
	String begin;
	String target;
	String[] words;
	int answer = Integer.MAX_VALUE;
	boolean[] visited;
	
	public int solution(String begin, String target, String[] words) {
		this.begin = begin;
		this.target = target;
		this.words = words;
		this.visited = new boolean[words.length];
		
		// Target이 words에 있는지 검사
		if(!searchTarget()) {
			return 0;
		}
		
		dfs(0,0, begin);
        
        return answer;
    }
	
	public void dfs(int depth, int changeNum, String word) {
		// 같아면 바꾼 횟수 업데이트, 최소 변경 수를 구해야 하므로 math.min
		if(word.equals(target)) {
			answer = Math.min(answer, changeNum);
			return;
		}
		
		if(depth == words.length) return;
		
		// 이미 바꾼 단어 건너뛰기, 바꿀 수 있는 여부 검사하고 바꿀수 있다면 변경
		for(int i=0; i<words.length; i++) {
			if(!visited[i] && changeWord(word, words[i])) {
				visited[i] = true;
				dfs(depth+1, changeNum+1, words[i]);
				visited[i] = false;
			}
		}
	}
	// Target이 words안에 있는지 검사
	public boolean searchTarget() {
		boolean isTarget = false;
		for(int i=0; i<words.length; i++) {
			if(target.equals(words[i])) {
				isTarget = true;
				break;
			}
		}
		return isTarget;
	}
	// 단어가 1개만 달라야 하므로, 바꿀수 있는지 여부 검사
	public boolean changeWord(String word,String changeWord) {
		boolean isChange = false;
		int n = 0;
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) != changeWord.charAt(i)) {
				n++;
			}
		}
			
		if(n == 1) isChange = true;
		
		return isChange;
	}
}
