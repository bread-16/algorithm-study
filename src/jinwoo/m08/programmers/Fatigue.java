package jinwoo.m08.programmers;

public class Fatigue {

	static boolean[] visited;
	static int clearNum;
	static int maxClearNum;

	public int solution(int k, int[][] dungeons) {

		visited = new boolean[dungeons.length];

		clearNum = 0;
		maxClearNum = 0;

		dfs(0, k, dungeons);

		int answer = maxClearNum;
		return answer;
	}

	public void dfs(int depth, int remainFatigue, int[][] dungeons) {
		
		if(depth == visited.length) {
			maxClearNum = Math.max(maxClearNum, clearNum);
			return;
		}
		
		for(int i=0; i<dungeons.length; i++) {
			
			if(visited[i]) continue;
			
			visited[i] = true;
			
			int beforeFatigue = remainFatigue;
			
			if(remainFatigue >= dungeons[i][0]) {
				remainFatigue -= dungeons[i][1];
				clearNum++;
			}
			
			dfs(depth+1, remainFatigue, dungeons);
			
			remainFatigue = beforeFatigue;
			
			if(remainFatigue >= dungeons[i][0]) {
				clearNum--;
			}
			
			visited[i] = false;
			
		}
	}

	}


