package jinyoung.m08.programmers;

import java.util.*;
class Queue_CorrectParentheses {
    boolean solution(String s) {
		boolean answer = false;
		
		Deque<Character> deque = new ArrayDeque<>();
		//deque에 집어넣으면서 "(" 일때 cnt1 ")" 일때 cnt2 증가
		int cnt1=0;
		int cnt2=0;
        int flag=0;
		for(int i=0;i<s.length();i++) {
			deque.addLast(s.charAt(i));
			if(s.charAt(i)=='(') {
				cnt1++;
			}
			else {
				cnt2++;
            }
			//반례 "())(()"  한번이라도 커지면 flag 1
            if (cnt1-cnt2<0) {
                flag=1;
            }
            
		}
		//처음 )일때, 마지막(일때 false, cnt개수 다르면 false
        if(flag==1) {
            return answer;
        }
		if(deque.peekFirst()==')') {
			return answer;
		} else if(deque.peekLast()=='(') {
			return answer;
		} else {
			if(cnt1==cnt2) {
                answer=true;
				return answer;
			}
			else {
				return answer;
			}
		}
	}
}

/*
import java.util.*;

public class Queue_CorrectParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = ")()(";
		
		Deque<Character> deque = new ArrayDeque<>();
		//deque에 집어넣으면서 "(" 일때 cnt1 ")" 일때 cnt2 증가
		int cnt1=0;
		int cnt2=0;
        int flag=0;
		for(int i=0;i<s.length();i++) {
			deque.addLast(s.charAt(i));
			if(s.charAt(i)=='(') {
				cnt1++;
			}
			else {
				cnt2++;
            }
			//반례 "())(()"  한번이라도 커지면 flag 1
            if (cnt1-cnt2<0) {
                flag=1;
            }
            
		}
		//처음 )일때, 마지막(일때 false, cnt개수 다르면 false
		
        if(flag==1) {
            System.out.println(false);
        } else {
			if(deque.peekFirst()==')') {
				System.out.println(false);
			} else if(deque.peekLast()=='(') {
				System.out.println(false);
			} else {
				if(cnt1==cnt2) {
					System.out.println(true);
				}
				else {
					System.out.println(false);
				}
			}
        }
	}
}
*/
