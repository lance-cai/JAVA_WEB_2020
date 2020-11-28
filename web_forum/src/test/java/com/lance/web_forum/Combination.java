package com.lance.web_forum;

import java.util.UUID;

public class Combination {

	public static void main(String[] args) {
//		System.out.println(UUID.randomUUID());
		// 列出所有組合，升冪排列
		combinationList(4, 1, 2, 0);
		

	}
	
	public static int combination(int n, int k) {
		if (k == 0 || k == n) {
			return 1;
		}
		return combination(n-1, k) + combination(n-1, k-1);
//		return n == 0 || k == 0 ? 1 : n-k+1 / k * combination(n, k-1);

	}
	
	// 當前印到哪裡
	public static void combinationList(int n, int start, int k, int i) {
		if (k == 0 || k == n) {
			System.out.print("there's zero combination");
			return;
		}
		if (k == 1) {
			System.out.println(start);
		}
		if (k > i) {
			combinationList(n-1, start++, k, i++);
			combinationList(n-1, start++, k-1, i++);
		}
		
		
		//		int[][] list = new int[combination(n, k)][k];
//		if (k == 0 || n == 0) {
//			return list;
//		}
//		for (int[] num : list_combination(n, k-1)) {
//			if (num[num.length-1] == n) {
//				continue;
//			}
//			int[] next
//			
//		}
		
	}
	
	

}
