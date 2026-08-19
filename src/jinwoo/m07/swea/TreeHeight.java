package jinwoo.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class TreeHeight {
	public static void main(String args[]) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			// 나무개수
			int treeNum = Integer.parseInt(in.readLine());
			
			int[] trees = new int[treeNum];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			int targetTreeHeight = 0;
			
			// 나무를 배열에 저장 및 가장 큰 나무길이 저장
			for(int i=0; i<trees.length; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				targetTreeHeight = Math.max(targetTreeHeight, trees[i]);
			}
			
			int oddNum = 0;
			int evenNum = 0;
			
			// 각 나무별로 차이를 구해서 짝수 날짜(2)와 홀수 날짜(1) 개수로 분배
			for(int i=0; i<trees.length; i++) {
				int diff = targetTreeHeight - trees[i];
				evenNum += diff / 2;
				oddNum += diff % 2;
			}
			
			// 짝수 날짜가 홀수 날짜보다 2개 이상 많다면, 
            // 짝수(+2) 하나를 홀수(+1, +1) 두 개로 쪼개어 균형을 맞춤
			while(evenNum > oddNum + 1) {
				evenNum--;
				oddNum += 2;
			}
			
			int day = 0;
			
			if(oddNum > evenNum) {
				day = oddNum * 2 - 1;
			} else if (evenNum > oddNum) {
				day = evenNum * 2;
			} else {
				day = oddNum + evenNum;
			}
			
			sb.append("#").append(test_case).append(" ").append(day).append("\n");
			
				}
		System.out.println(sb.toString());
			}
		}
