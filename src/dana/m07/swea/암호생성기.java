package dana.m07.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 암호생성기 {
	
	public static void main(String args[]) throws Exception{ 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			// 인풋: test case number
			int tc = Integer.parseInt(br.readLine());
			
			// 인풋: 8개의 데이터
			int[] arr = new int[8];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int d = 0; d < 8; d++) {
				arr[d] = Integer.parseInt(st.nextToken());
			}
			
			// 전략 시작 
			boolean stop = false;
			int subtractNum = 1; 
			while(!stop) {
				int firstNum = arr[0];
				int temp = firstNum - subtractNum;
				subtractNum++;
				
				if (temp < 0) {
					temp = 0;
					stop = true;
				} else {
					// 한칸씩 앞으로 옮기기
					for (int i = 1; i < arr.length; i++) {
						arr[i - 1] = arr[i];
					}
					arr[7] = temp;
				}
				
				if (stop) {
					break;
				}
			}
			
			// 프린트 
			System.out.print("#" + test_case + " ");
			for (int num : arr) {
				System.out.print(num + " ");
			}
		}
	}
}
