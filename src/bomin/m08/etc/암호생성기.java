import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class 암호생성기{
    // 큐를 사용해서 값 화인 후 0이상일때까지 1~5 감소 돌리기.
    // 0이하가 되면 0으로 맨 뒤에 넣고 앞에서부터 큐 빌때까지 꺼냄.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new ArrayDeque<>();
            for(int i=0; i<8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }
             
            boolean flag = true;
            while(flag) {
                for(int i=1;i<=5;i++) {
                    if(q.peek() - i >0) {
                        q.offer(q.poll() - i);
                    }
                    else {
                        q.poll();
                        q.offer(0);
                        flag = false;
                        break;
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            while(!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}