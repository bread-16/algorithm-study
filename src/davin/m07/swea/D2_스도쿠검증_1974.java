package davin.m07.swea;

import java.util.*;
import java.io.*;

public class D2_스도쿠검증_1974 {
	static boolean isSudoku(int[][] nums) {
		// 칸 하나를 방문할 때, 그 칸이 속한 행/열/박스를 한 번에 다 체크
		boolean[][] row = new boolean[9][10];
	    boolean[][] col = new boolean[9][10];
	    boolean[][] box = new boolean[9][10];

	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            int v = nums[i][j];
	            int b = (i / 3) * 3 + (j / 3);

	            if (row[i][v] || col[j][v] || box[b][v]) return false;

	            row[i][v] = true;
	            col[j][v] = true;
	            box[b][v] = true;
	        }
	    }

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
