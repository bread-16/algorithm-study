package giseon.m08.programmers;

// 0.04ms, 80.5MB
class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int day;
        Queue<Integer> q = new ArrayDeque<>();

        // 각 기능별로 진도 100 이상이 되는 day를 계산하여 queue에 넣기
        for (int i = 0; i < progresses.length; i++) {
            day = (100 - progresses[i]) / speeds[i];
            // 100이 넘어가는 경우에는 day 올림해준다.
            // 다른 방법
            // 1. 올림 나눗셈 - (a + b - 1)/b
            // 2. 올림 함수 - Math.ceil(double);
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day += 1;
            }
            q.offer(day);
        }

        List<Integer> result = new ArrayList<>();

        int pivot;
        int count;

        // queue에 값이 남아 있는 경우에만 반복
        while (!q.isEmpty()) {
            // 꺼내서 같이 배포할 수 있는 기능들을 확인
            pivot = q.poll();
            count = 1;
            // 앞서 완료된 기능을 배포할 수 있으므로 이미 완성된 기능들을 꺼내면서 기능의 개수를 카운트
            while (!q.isEmpty() && q.peek() <= pivot) {
                q.poll();
                count++;
            }
            result.add(count);
        }

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
