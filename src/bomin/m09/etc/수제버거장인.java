package bomin.m09.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수제버거장인 {
	
	static boolean[][] ban;
	static int N;
	static int count;
	static List<Integer> ingredients;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ban = new boolean[N+1][N+1];
			count = 0;
			ingredients = new ArrayList<>();
			for(int i=1;i<=M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				ban[a][b] = true;
				ban[b][a] = true;
			}
			dfs(0);
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int depth) {
		boolean flag = true;
		if(depth == N) {
			count++;
			return;
		}
		//다음 숫자 안넣기
		dfs(depth+1);
		
		//다음 숫자 넣기
		for(int number : ingredients) {
			if(ban[number][depth+1]) {
				flag = false;
				break;
			}
		}
		if(flag) {
			ingredients.add(depth+1);
			dfs(depth+1);
			ingredients.remove(ingredients.size()-1);
		}
	}
}
