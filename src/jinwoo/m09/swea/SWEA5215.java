package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {
	
	static Ingredient[] ingredients;
	static int ingredientNum;
	static int maxCalories;
	
	static int answer;
	
	static class Ingredient{
		int preference;
		int calories;
		
		public Ingredient(int preference, int calories) {
			this.preference = preference;
			this.calories = calories;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine().trim());
			
			ingredientNum = Integer.parseInt(st.nextToken());
			maxCalories = Integer.parseInt(st.nextToken());
			
			ingredients = new Ingredient[ingredientNum];
			
			for(int i=0; i<ingredientNum; i++) {
				st = new StringTokenizer(in.readLine().trim());
				
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				ingredients[i] = new Ingredient(p, c);
			}
			answer = 0;
			
			dfs(0, 0, 0);
			
			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	static public void dfs(int start, int preference, int calories) {
		if(calories > maxCalories) return;
		if(preference > answer) answer = preference;
		
		
		for(int i=start; i<ingredientNum; i++) {
			
			Ingredient ig = ingredients[i];
			
			dfs(i+1, preference+ig.preference, calories+ig.calories);
			
		}
	}
}
