package jinyoung.m08.programmers;

import java.util.*;
import java.io.*;

class Solution {
    
    public static int[] arr;
	public static boolean[] visited;
	public static Set<Integer> resultSet;
    
    public static void generate(String current) {
		if (!current.isEmpty()) {
			resultSet.add(Integer.parseInt(current));
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			generate(current + arr[i]);
			visited[i] = false;
		}
	}
    
    public int solution(String numbers) {
		arr = new int[numbers.length()];
		visited = new boolean[numbers.length()];
        resultSet = new HashSet<>();
		int num = Integer.parseInt(numbers);

		for (int i = 0; i < numbers.length(); i++) {
			arr[i] = num % 10;
			num /= 10;
		}

		generate("");

		List<Integer> resultList = new ArrayList<>(resultSet);
		Collections.sort(resultList);

		int answer = 0;
		int cnt = 0;
		for (int i = 0; i < resultList.size(); i++) {
			if (resultList.get(i) > 1) {
				for (int j = 1; j <= Math.sqrt(resultList.get(i)); j++) {
					if (resultList.get(i) % j == 0) {
						cnt++;
					}
				}
				if (cnt == 1) {
					answer++;
				}
                cnt = 0;
            }
		}
        return answer;
    }
}