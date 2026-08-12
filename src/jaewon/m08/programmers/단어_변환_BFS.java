package jaewon.m08.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

// 0.03ms, 78.9MB, O(N^2)
public class 단어_변환_BFS {

    public boolean canChange(String curWord, String nextWord) {
        int diff = 0;
        for (int i = 0; i < curWord.length(); i++) {
            if (curWord.charAt(i) != nextWord.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length;
        boolean[] visited = new boolean[n];

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();   // 현재 레벨의 개수를 먼저 고정

            for (int s = 0; s < size; s++) {
                String cur = queue.poll();

                if (cur.equals(target)) {
                    return depth;
                }

                for (int i = 0; i < n; i++) {
                    if (visited[i] || !canChange(cur, words[i])) continue;

                    visited[i] = true;
                    queue.offer(words[i]);
                }
            }
            depth++;   // 한 레벨 처리 완료
        }
        return 0;   // target에 도달 불가
    }
}