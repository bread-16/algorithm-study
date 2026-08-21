package jinwoo.m08.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Hunter {
	
	static int arrLen;
	static boolean[] visited;
	static List<Creature> creatures;
	static boolean[] isClear;
	static int result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t=1;t<=T;t++){
			
			arrLen = Integer.parseInt(in.readLine());
			
			creatures = new ArrayList<>();
			
			// 맵 저장, 생명체가 나오면 생명체 객체 만들어 creatures에 저장
			for(int i=0; i<arrLen; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int j=0;j<arrLen;j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n != 0) {
						creatures.add(new Creature(i,j,n));
					}
				}
			}
			
			result = Integer.MAX_VALUE;
			// 방문여부
			visited = new boolean[creatures.size()];
			// 몬스터 퇴치 여부
			isClear = new boolean[creatures.size()/2];
			
			dfs(0, 0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int clear, int time, int x, int y) {
		
		// 시간이 이미 초과라면 끝내기
		if(time > result) return;
		
		// 몬스터 퇴치, 의뢰 완료 를 전부 완료시 result 갱신
		if(clear == creatures.size()) {
			result = Math.min(result, time);
			return;
		}
		
		for(int i=0; i<creatures.size(); i++) {
			if(visited[i]) continue;
			
			Creature target = creatures.get(i);
			
			// target이 몬스터라면 퇴치후 isClear 갱신
			// npc라면 몬스터 퇴치여부 확인 후 퇴치 안했다면 넘어가기
			if(target.type < 0) {
				if(!isClear[Math.abs(target.type)-1])continue;
			} else {
				isClear[Math.abs(target.type)-1] = true;
			}
			
			visited[i] = true;
			
			dfs(clear + 1, time+(Math.abs(x-target.r) + Math.abs(y-target.c)), target.r, target.c);
			
			visited[i] = false;
			
			if(target.type > 0) {
				isClear[Math.abs(target.type)-1] = false;
			} 
		}
	}
	
	// 생명체 좌표, 타입 저장
	// 더 필요한게 있을까...
	static class Creature {
		int r;
		int c;
		int type;
		
		public Creature(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}
