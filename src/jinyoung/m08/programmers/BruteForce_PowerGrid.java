package jinyoung.m08.programmers;

import java.util.*;

public class BruteForce_PowerGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		int n = 9;
		List<List<Integer>> grid = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			grid.add(new ArrayList<>());
		}
		for (int[] wire : wires) {
			grid.get(wire[0]).add(wire[1]);
			grid.get(wire[1]).add(wire[0]);
		}

		int answer = 1000;

		for (int[] wire : wires) {
			int v1 = wire[0];
			int v2 = wire[1];
			int left = dfs(v1, v2, grid);
			int right = dfs(v2, v1, grid);
			answer = Math.min(Math.abs(left - right), answer);
		}
		System.out.println(answer);
	}

	public static int dfs(int start, int parent, List<List<Integer>> grid) {
		int cnt = 1;
		for (int i : grid.get(start)) {
			if (i == parent) {
				continue;
			}
			cnt += dfs(i, start, grid);
		}
		return cnt;
	}
}
