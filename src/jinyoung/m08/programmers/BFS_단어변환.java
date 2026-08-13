package jinyoung.m08.programmers;

import java.util.*;
class BFS_단어변환 {
    String begin;
    String target;
    String[] words;
    boolean[] visited;
    
    class Node {
		String word;
		int cnt;
		Node(String word, int cnt) {
			this.word=word;
			this.cnt=cnt;
		}
	}
    
    Deque<Node> deque = new ArrayDeque<>(); 
    
    public int solution(String begin, String target, String[] words) {
        this.begin=begin;
        this.target=target;
        this.words=words;
        int answer = 0;
        
        int flag=0;
		for(String word : words) {
			if(target.equals(word)) flag=1;
		}
		if(flag==0) return answer;
        
        
        visited = new boolean[words.length];
		deque.offer(new Node(begin,0));
        
        while(!deque.isEmpty()) {
			Node current=deque.poll();
			if(current.word.equals(target)) {
				answer=current.cnt;
			}
			for(int i=0;i<words.length;i++) {
                if(visited[i]) continue;
				if(check(current.word, words[i])) {
					visited[i]=true;
					deque.offer(new Node(words[i],current.cnt+1));
				}
			}
		}
        return answer;
    }
    
    public static boolean check(String a, String b) {
		int k=0;
		int n=a.length();
		for(int i=0;i<n;i++) {
			if(a.charAt(i)==b.charAt(i)) k++;
		}
		if(k==n-1) return true;
		else return false;
    }
}

/*
import java.util.*;

public class BFS_단어변환 {
	
	public static String begin="hit";
	public static String target="cog";
	public static String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};
	public static boolean[] visited;
		
	public static class Node {
		String word;
		int cnt;
		Node(String word, int cnt) {
			this.word=word;
			this.cnt=cnt;
		}
	}
	
	public static Deque<Node> deque = new ArrayDeque<>(); 
	
	public static void main(String[] args) {
		int flag=0;
		for(String word : words) {
			if(target.equals(word)) flag=1;
		}
		if(flag==0) return 0;
		
		visited = new boolean[words.length];
		deque.offer(new Node(begin,0));
		
		while(!deque.isEmpty()) {
			Node current=deque.poll();
			if(current.word.equals(target)) {
				System.out.println(current.cnt); 
				break;
			}
			for(int i=0;i<words.length;i++) {
				if(visited[i]==false && check(current.word, words[i])) {
					visited[i]=true;
					deque.offer(new Node(words[i],current.cnt+1));
				}
			}
		}
		return 0;
	}
	
	public static boolean check(String a, String b) {
		int k=0;
		int n=a.length();
		for(int i=0;i<n;i++) {
			if(a.charAt(i)==b.charAt(i)) k++;
		}
		if(k==n-1) return true;
		else return false;
	}
}
*/