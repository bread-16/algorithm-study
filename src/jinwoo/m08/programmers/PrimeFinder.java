package jinwoo.m08.programmers;

import java.util.HashSet;
import java.util.Set;

public class PrimeFinder {

    static int[] numberArr;
    static boolean[] visited;
    static int[] selected;
    static Set<Integer> result = new HashSet<>();


    public int solution(String numbers) {

        numberArr = new int[numbers.length()];

        for(int i = 0; i < numbers.length(); i++) {
            numberArr[i] = numbers.charAt(i) - '0';
        }

        visited = new boolean[numbers.length()];
        selected = new int[numbers.length()];


        for(int i = 1; i <= numbers.length(); i++) {
            dfs(0, i);
        }


        int answer = 0;

        for(int num : result) {

            if(isPrime(num)) {
                answer++;
            }

        }

        return answer;
    }


    static void dfs(int depth, int r) {

        if(depth == r) {

            int num = 0;

            for(int i = 0; i < r; i++) {
                num = num * 10 + selected[i];
            }

            result.add(num);

            return;
        }


        for(int i = 0; i < numberArr.length; i++) {

            if(visited[i]) continue;


            visited[i] = true;

            selected[depth] = numberArr[i];

            dfs(depth + 1, r);

            visited[i] = false;
        }
    }


    static boolean isPrime(int num) {

        if(num < 2) {
            return false;
        }


        for(int i = 2; i <= Math.sqrt(num); i++) {

            if(num % i == 0) {
                return false;
            }

        }

        return true;
    }
}