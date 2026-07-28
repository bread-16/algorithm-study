package jinwoo.m07.swea;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.StringTokenizer;

public class MaxPrice_1244_D3 {
	
	static char[] numbers;
    static int changeNum;
    static int max;
    static HashSet<String>[] visited;
	
	public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            numbers = st.nextToken().toCharArray();
            changeNum = Integer.parseInt(st.nextToken());

            max = 0;

            visited = new HashSet[changeNum + 1];

            for (int i = 0; i <= changeNum; i++) {
                visited[i] = new HashSet<>();
            }

            dfs(0);

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int cnt) {

        String now = new String(numbers);

        if (visited[cnt].contains(now))
            return;

        visited[cnt].add(now);

        if (cnt == changeNum) {

            max = Math.max(max, Integer.parseInt(now));
            return;
        }

        int n = numbers.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                swap(i, j);

                dfs(cnt + 1);

                swap(i, j);
            }
        }
    }

    static void swap(int i, int j) {

        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
