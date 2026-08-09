package giseon.m08.programmers;

import java.util.*;

public class MockExam {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>(); // 출력할 3인방의 번호를 넣을 배열
        int[] count = new int[3]; // 각 3인방의 맞힌 개수
        int size = answers.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        int maxNum; // 맞힌 횟수 최댓값

        int[] p1 = { 1, 2, 3, 4, 5 };
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        for (int i = 0; i < size; i++) {
            // p은 %를 통해 돌아가면서 answers의 요소와 각각 비교하여 맞으면 count를 늘린다.
            if (p1[i % 5] == answers[i]) {
                cnt1++;
            }
            if (p2[i % 8] == answers[i]) {
                cnt2++;
            }
            if (p3[i % 10] == answers[i]) {
                cnt3++;
            }
        }

        // 그 중 최댓값을 구한다.
        maxNum = Math.max(Math.max(cnt1, cnt2), cnt3);

        // 만약 동점수가 있다면 가변배열에 넣어준다.
        if (maxNum == cnt1) {
            answer.add(1);
        }
        if (maxNum == cnt2) {
            answer.add(2);
        }
        if (maxNum == cnt3) {
            answer.add(3);
        }

        // 가변 배열에 넣은 걸 int[]로 반환해야하므로 복사한다.
        int[] result;
        result = new int[answer.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
