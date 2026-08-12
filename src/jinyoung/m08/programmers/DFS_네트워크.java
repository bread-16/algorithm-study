package jinyoung.m08.programmers;

import java.util.*;

public class DFS_네트워크 {
	
	public static int n=3;
	public static int[][] computers= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
	public static List<List<Integer>> network = new ArrayList<>(); 
	public static int cnt = 0;
	public static boolean[] visited;
	
	public static void main(String[] args) {
		for(int i=0;i<n;i++) {
			computers[i][i]=0;
		}
		for(int i=0;i<n;i++) {
			network.add(new ArrayList<>());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(computers[i][j]==1) {
					network.get(i).add(j);
				}
			}		
		}
		visited = new boolean[n];
		for(int i=0;i<n;i++ ) {
			if(!visited[i]) {
				dfs(i,network);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	public static void dfs(int start, List<List<Integer>> current) {
		visited[start] = true;
		
		for(int next : current.get(start)) {
			if(!visited[next]) {
				dfs(next,current);
			}
		}
	}
}
	
		
		
		
		
//		for(int i=0;i<n;i++) {
//			System.out.println(network.get(i));
		

