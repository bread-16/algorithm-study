package jinwoo.m09.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class 선수과목 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] subjects =new List[N+1];
		
		for(int i=1; i<=N; i++) {
			subjects[i] = new ArrayList<Integer>();
		}
		
		int[] prerequisite = new int[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine().trim());
			
			int pre = Integer.parseInt(st.nextToken());
			int sub = Integer.parseInt(st.nextToken());
			
			subjects[pre].add(sub);
			prerequisite[sub]++;
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		int[] answer = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			if(prerequisite[i] == 0) {
				q.offer(i);
				answer[i] = 1;
			}
		}
		// 여기가 중요
		while (!q.isEmpty()) {
            int pre = q.poll();

            for (int sub : subjects[pre]) {
                prerequisite[sub]--;

                if (prerequisite[sub] == 0) {
                    answer[sub] = answer[pre] + 1;
                    q.offer(sub);
                }
            }
        }
		
		for(int i=1; i<=N; i++) {
			sb.append(answer[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
