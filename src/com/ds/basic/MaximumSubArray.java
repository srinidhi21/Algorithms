package com.ds.basic;

import java.util.Arrays;

public class MaximumSubArray {
	public static void main(String[] args) {
		// int[] a = { -2, -1, -3, -4, -5, -6, -7 };
		int[] a = { -1, 3, -5, 4, 6, -1, 2, -7, 13, -3 };
		// int[] a = { -6, -2, -3, -4, -1, -5, -5 };
		System.out.println(Arrays.toString(a));
		// find all the indices and everything
		findMaxSubArray(a);

		// find just maximum
		System.out.println(findMaxSum(a));
	}

	public static void findMaxSubArray(int[] a) {

		int lo = 0;
		int hi = 0;
		int maxSum = Integer.MIN_VALUE;

		int currentsum = 0;
		int indexUntilNow = 0;


		for (int i = 0; i < a.length; i++) {

			currentsum = currentsum + a[i];

			if (currentsum > maxSum) {
				maxSum = currentsum;
				lo = indexUntilNow;
				hi = i;
			} else if (currentsum < 0) {
				indexUntilNow = i + 1;
				currentsum = 0;
			}
		}

		System.out.println("Max sum         : " + maxSum);
		System.out.println("Max start index : " + lo);
		System.out.println("Max end index   : " + hi);
		int lengthOfNewArray = hi - lo + 1; // / very important
		int[] b = new int[lengthOfNewArray];
		System.arraycopy(a, lo, b, 0, lengthOfNewArray);
		System.out.println("Maximum SubArray   : " + Arrays.toString(b));

	}

	// 0(1) space, don't need DP here.
	private static int findMaxSum(int[] a) {
		int max = a[0];
		int currentsum = a[0];

		for (int i = 1; i < a.length; i++) {
			currentsum = Math.max(currentsum + a[i], a[i]);
			max = Math.max(max, currentsum);
		}
		return max;
	}
}
