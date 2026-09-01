package jinwoo.m09.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class HeightOrder {

	static List<Integer>[] tallGraph;
	static List<Integer>[] shortGraph;
	static int studentNum;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine().trim());

		for (int t = 0; t < T; t++) {

			studentNum = Integer.parseInt(in.readLine().trim());
			int checkNum = Integer.parseInt(in.readLine().trim());

			tallGraph = new List[studentNum];
			shortGraph = new List[studentNum];

			for (int i = 0; i < studentNum; i++) {
				tallGraph[i] = new ArrayList<>();
				shortGraph[i] = new ArrayList<>();
			}

			for (int i = 0; i < checkNum; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine().trim());
				// idx 0~
				int st1 = Integer.parseInt(st.nextToken()) - 1;
				int st2 = Integer.parseInt(st.nextToken()) - 1;

				tallGraph[st1].add(st2);
				shortGraph[st2].add(st1);
			}
			
			answer = 0;
			// 이게 bfs가 맞나?
			for (int i = 0; i < studentNum; i++) {
				bfs(i);
			}

			sb.append("#").append(t+1).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	static public void bfs(int num) {
		Deque<Integer> tDq = new ArrayDeque<Integer>();
		Deque<Integer> sDq = new ArrayDeque<Integer>();

		boolean[] tVisited = new boolean[studentNum];
		boolean[] sVisited = new boolean[studentNum];

		tDq.offer(num);
		sDq.offer(num);

		int tNum = 0;
		int sNum = 0;
		int totalNum = 0;

		while (!tDq.isEmpty()) {

			int target = tDq.poll();

			tVisited[target] = true;

			for (int i = 0; i < tallGraph[target].size(); i++) {

				if (tVisited[tallGraph[target].get(i)])
					continue;

				tVisited[tallGraph[target].get(i)] = true;

				tDq.offer(tallGraph[target].get(i));

				tNum++;
			}
		}

		while (!sDq.isEmpty()) {

			int target = sDq.poll();

			sVisited[target] = true;

			for (int i = 0; i < shortGraph[target].size(); i++) {

				if (sVisited[shortGraph[target].get(i)])
					continue;

				sVisited[shortGraph[target].get(i)] = true;

				sDq.offer(shortGraph[target].get(i));

				sNum++;
			}
		}
		
		totalNum = tNum + sNum;
		
		if(totalNum == (studentNum - 1)) answer++;
	}
}
