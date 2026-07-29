package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_스도쿠검증_1974 {
	static boolean isSudoku(int[][] nums) {

		// 행 체크
		for (int i = 0; i < 9; i++) {
			int[] count = new int[10];
			for (int j = 0; j < 9; j++) {
				count[nums[i][j]]++;
				if (count[nums[i][j]] >= 2)
					return false;
			}

		}

		// 열 체크
		for (int i = 0; i < 9; i++) {
			int[] count = new int[10];
			for (int j = 0; j < 9; j++) {
				count[nums[j][i]]++;
				if (count[nums[i][j]] >= 2)
					return false;
			}
		}

		// 3*3 체크 -> 4중 for문으로 했다가 2중 for문으로 리팩토링
		for (int box = 0; box < 9; box++) {
		    int[] count = new int[10];
		    int startX = (box / 3) * 3;
		    int startY = (box % 3) * 3;
		    for (int cell = 0; cell < 9; cell++) {
		        int x = startX + cell / 3;
		        int y = startY + cell % 3;
		        count[nums[x][y]]++;
		        if (count[nums[x][y]] >= 2)
		            return false;
		    }
		}

		// 위 체크했는데 다 해당 안되면 스도쿠임
		return true;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		int[][] nums = new int[9][9];

		for (int a = 1; a <= t; a++) {
			sb.append("#").append(a).append(" ");
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (isSudoku(nums))
				sb.append("1").append("\n");
			else
				sb.append("0").append("\n");
		}

		System.out.println(sb);
	}
}



//package davin.m07.swea;
//
//import java.util.*;
//import java.io.*;
//
//public class D2_스도쿠검증_1974 {
//	static boolean isSudoku(int[][] nums) {
//
//		// 행 체크
//		for (int i = 0; i < 9; i++) {
//			int[] count = new int[10];
//			for (int j = 0; j < 9; j++) {
//				count[nums[i][j]]++;
//				if (count[nums[i][j]] >= 2)
//					return false;
//			}
//
//		}
//
//		// 열 체크
//		for (int i = 0; i < 9; i++) {
//			int[] count = new int[10];
//			for (int j = 0; j < 9; j++) {
//				count[nums[j][i]]++;
//				if (count[nums[i][j]] >= 2)
//					return false;
//			}
//		}
//
//		// 3*3 체크
//		for (int x = 0; x < 9; x += 3) {
//			for (int y = 0; y < 9; y += 3) {
//				int[] count = new int[10];
//				for (int j = 0; j < 3; j++) {
//					for (int k = 0; k < 3; k++) {
//						count[nums[x + j][y + k]]++;
//						if (count[nums[x + j][y + k]] >= 2)
//							return false;
//					}
//				}
//			}
//		}
//
//		// 위 체크했는데 다 해당 안되면 스도쿠임
//		return true;
//	}
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringBuilder sb = new StringBuilder();
//
//		int t = Integer.parseInt(br.readLine());
//		int[][] nums = new int[9][9];
//
//		for (int a = 1; a <= t; a++) {
//			sb.append("#").append(a).append(" ");
//			for (int i = 0; i < 9; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < 9; j++) {
//					nums[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			if (isSudoku(nums))
//				sb.append("1").append("\n");
//			else
//				sb.append("0").append("\n");
//		}
//
//		System.out.println(sb);
//	}
//}
