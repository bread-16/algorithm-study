package jinyoung.m08.programmers;
import java.util.*;
public class BFS_아이템줍기 {
    int[][] board=new int[102][102];
    //우하좌상
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    Deque<int[]> deque = new ArrayDeque<>();
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int n = rectangle.length;
        int m = 4;
        
        characterX*=2;
        characterY*=2;
        itemX*=2;
        itemY*=2;
        
        for(int i=0;i<n;i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int x=x1;x<=x2;x++) {
                for(int y=y1;y<=y2;y++) {
                    board[x][y]=1;
                }
            }
        }
         for(int i=0;i<n;i++) {
            int x1 = rectangle[i][0]*2;
            int y1 = rectangle[i][1]*2;
            int x2 = rectangle[i][2]*2;
            int y2 = rectangle[i][3]*2;
            
            for(int x=x1+1;x<=x2-1;x++) {
                for(int y=y1+1;y<=y2-1;y++) {
                    board[x][y]=0;
                }
            }
        }
                   
        board[characterX][characterY]=0;
        deque.offer(new int[]{characterX, characterY, 0});
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            if(x==itemX && y==itemY) {
                answer=dist;
                break;
            }
            for(int dir=0;dir<4;dir++) {
                int nx = x+dx[dir];
                int ny = y+dy[dir];
                if(nx<0 || nx>=102 || ny<0 || ny>=102) {
                    continue;
                }
                if(board[nx][ny]==0) {
                    continue;
                }
                board[nx][ny]=0;
                deque.offer(new int[]{nx,ny,dist+1});
            }
        }
        
        // for(int i=0;i<102;i++) {
        //     for(int j=0;j<102;j++) {
        //         System.out.print(board[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        answer=answer/2;
        return answer;
    }
}
