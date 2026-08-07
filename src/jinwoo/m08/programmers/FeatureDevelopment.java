package jinwoo.m08.programmers;

import java.util.ArrayList;
import java.util.List;

public class FeatureDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {

        boolean isFinish = false;

        int idx = 0;

        List<Integer> clearNum = new ArrayList<>();

        while (!isFinish) {

            int finishNum = 0;

            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];

                if (progresses[i] > 100) {
                    progresses[i] = 100;
                }
            }

            if (progresses[idx] == 100) {
                for (int i = idx; i < progresses.length; i++) {
                    if (progresses[i] == 100) {
                        finishNum++;
                    } else {
                        break;
                    }
                }
                idx += finishNum;
                clearNum.add(finishNum);
            }

            if (idx == progresses.length)
                isFinish = true;

        }

        int[] answer = new int[clearNum.size()];
        int i = 0;

        for (Integer num : clearNum) {
            answer[i++] = num;
        }

        return answer;
    }
}
