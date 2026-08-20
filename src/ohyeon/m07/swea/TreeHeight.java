package ohyeon.m07.swea;

import java.io.*;
import java.util.*;

public class TreeHeight {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] trees = new int[N];
            int maxHeight = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            int odd = 0;  // +1 성장이 필요한 횟수
            int even = 0; // +2 성장이 필요한 횟수

            for (int i = 0; i < N; i++) {
                int diff = maxHeight - trees[i];
                even += diff / 2;
                odd += diff % 2;
            }

            // +2 성장을 +1 성장 2개로 바꾸며 균형을 맞춤
            while (even > odd + 1) {
                even--;
                odd += 2;
            }

            int ans;
            if (odd > even) {
                ans = odd * 2 - 1; // 홀수 날이 더 많으면 마지막은 홀수 날에 끝남
            } else {
                ans = even * 2;    // 짝수 날이 같거나 1개 더 많으면 짝수 날로 끝남
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
