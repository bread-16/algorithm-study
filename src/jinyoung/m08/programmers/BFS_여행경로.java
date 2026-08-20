package jinyoung.m08.programmers;

import java.util.*;

class BFS_여행경로 {
    boolean[] visited;
    Deque<String> deque = new ArrayDeque<>();
    String[] answer;
    boolean isFound = false;

    public String[] solution(String[][] tickets) {
        // 알파벳 사전 순 정렬
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });
        int n = tickets.length;
        visited = new boolean[n];
        answer = new String[n + 1];
        deque.offer("ICN");
        dfs("ICN", tickets, 0);

        return answer;
    }

    private void dfs(String current, String[][] tickets, int count) {
        if (isFound) return;
        if (count == tickets.length) {
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                answer[i] = deque.poll();
            }
            isFound = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                deque.offer(tickets[i][1]);
                dfs(tickets[i][1], tickets, count + 1);
                deque.pollLast();
                visited[i] = false;
            }
        }
    }
}

/* bfs를 사용하려고 열심히 풀었는데
   시작점이 tickets[0]이 아닐 수도 있음.
   그래서 ticketsqueue에 다 집어넣고 경로가 없을 시 다시 큐에 끝으로 삽입하는 방법을 생각
   구현이 너무 어려움..
   그래서 dfs 선택해서 다시 시도

class BFS_여행경로 {
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer;
        int n=tickets.length;
        answer = new String[n+1];
        visited=new boolean[n];
                
        Deque<String[]> deque = new ArrayDeque<>();
        visited[0]=true;
        deque.offer(tickets[0]);
        int idx=0;
        while(!deque.isEmpty()) {
            for(String[] tempS : deque) {
                System.out.println(tempS[0]+" "+tempS[1]);
            }
            String[] s = deque.poll();
            String a = s[0];
            String b = s[1];
            for(String[] tempS : deque) {
                char tempB=tempS[1].charAt(0);
                if(tempB<s[1].charAt(0)) {
                    deque.offer(s);
                    s=deque.poll();
                    a=s[0];
                    b=s[1];
                }
            }
            
            System.out.println("추가: "+a+" 같은거: "+b+" idx: "+idx);
            answer[idx]=a;
            idx++;
        
            for(int i=0;i<n;i++) {
                System.out.println("현재: "+a+" "+b+" "+idx);
                if(visited[i]==true) continue;
                if(b.equals(tickets[i][0])) {
                    visited[i]=true;
                    deque.offer(tickets[i]);
                    
                }
            }
            answer[idx]=b;
        }
        return answer;
    }
}

 */