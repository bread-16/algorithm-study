package jinyoung.m08.programmers;

public class DFS_타겟넘버 {
    int[] numbers;
    int target;
    int answer=0;
    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;
		dfs(new StringBuilder(), 0);
		return answer;
	}
	void dfs(StringBuilder sb, int depth) {
		if (depth >= numbers.length) {
			String ex = sb.toString();
			
			int result = evaluate(ex);
			if(result == target) {
				answer++;
			}
			return;
		}
		int len = sb.length();
		sb.append("+").append(numbers[depth]);
		dfs(sb, depth + 1);
		sb.setLength(len);

		sb.append("-").append(numbers[depth]);
		dfs(sb, depth + 1);
		sb.setLength(len);
	}
	
	int evaluate(String ex) {
		int sum = 0;
		int current = 0;
		int sign = 1;
		for (int i = 0; i < ex.length(); i++) {
			char c = ex.charAt(i);
			if (Character.isDigit(c)) {
				current=current*10+(c-'0');
			} else if (c=='+' || c=='-') {
				sum+=sign*current;
				current=0;
				if(c=='+') sign=1;
				else sign=-1;
			}
		}
		sum+=sign*current;
		return sum;
	}
}
