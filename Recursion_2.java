 /**
  * Solutions to coding challenges from codingbat.com.
  * Section: Recursion-2
  * Date: 12/14/2018
  * Author: Omar Ahmed 
  *
  */
import java.util.Arrays;

public class Recursion_2 {
	/**
	 * Given an array of ints, is it possible to choose a group of some of the ints, 
	 * such that the group sums to the given target?
	 * groupSum(0, [2,4,8], 10) → true 
	 * groupSum(0, [2,4,8], 14) → true 
	 * groupSum(0, [2,4,8], 9) → false */
	public static boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		if (groupSum(start+1, nums, target-nums[start])) 
			return true;
		return groupSum(start+1, nums, target);
	}

	/**
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * beginning at the start index, such that the group sums to the given target? 
	 * However, with the additional constraint that all 6's must be chosen.
	 * groupSum6(0, [5,6,2], 8) → true
	 * groupSum6(0, [5,6,2], 9) → false 
	 * groupSum6(0, [3,2,4,6], 8) → true 
	 * groupSum6(0, [1,6,2,6,5], 14) → true 
	 * groupSum6(0, [1], 1) → true  */
	public static boolean groupSum6(int start, int[] nums, int target) {
		// base case
		if (start >= nums.length) return target == 0;
		if (groupSum6(start+1, nums, target-nums[start]))
			return true;
		return nums[start] == 6 ? groupSum6(start+1, nums, target-nums[start]) : groupSum6(start+1, nums, target);
	}

	/** 
	 * Given an array of ints, is it possible to choose a group of some of the ints, such that the 
	 * group sums to the given target with this additional constraint: If a value in the array is chosen 
	 * to be in the group, the value immediately following it in the array must not be chosen. 
	 * Key idea: nums[start] is chosen or it is not.
  	 * deal with nums[start], letting recursion deal with all the rest of the array.
	 * groupNoAdj(0, [2,5,10,4], 12) → true
	 * groupNoAdj(0, [2,5,10,4], 14) → false
	 * groupNoAdj(0, [2,5,10,4,2], 7) → true
	 * groupNoAdj(0, [2,5,10,4], 7) → false  */
	public static boolean groupNoAdj(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		if (groupNoAdj(start + 2, nums, target - nums[start])) {
			return true;
		}
		return groupNoAdj(start+1, nums, target);
	}

	/** 
	 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to the
	 * given target with these additional constraints: all multiples of 5 in the array must be included in the group. 
	 * If the value immediately following a multiple of 5 is 1, it must not be chosen.
	 * groupSum5(0, [2,5,10,4], 19) → true
	 * groupSum5(0, [2,5,10,4], 17) → true 
	 * groupSum5(0, [2,5,10,4], 12) → false  
	 * groupSum5(0, [3,5,1], 9) → false 
	 * groupSum5(0, [3,5,1], 4) → false  */
	public static boolean groupSum5(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		if (start < nums.length-1 && nums[start]%5 == 0) {
	   		if (nums[start+1] == 1)
				return groupSum5(start+2, nums, target-nums[start]);
			return groupSum5(start+1, nums, target-nums[start]);
		}
		return groupSum5(start+1, nums, target-nums[start]) || groupSum5(start+1, nums, target);
	}


	/**
	 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums to 
	 * the given target, with this additional constraint: if there are numbers in the array that are adjacent and the
	 * identical value, they must either all be chosen, or none of them chosen. (one loop can be used to find the 
	 * extent of the identical values).
	 * groupSumClump(0, [2,4,8], 10) 	 → true
	 * groupSumClump(0, [1,2,4,8,1], 14) → true
	 * groupSumClump(0, [2,4,4,8], 14) 	 → false
	 * groupSumClump(0, [8,2,2,1], 9) 	 → true */
	public static boolean groupSumClump(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		int d = 0;
		for (int i = 0, j = 1; i < nums.length-1; i++) {
			if (nums[i] == nums[j++]) {
				d = nums[i];
			}
		}
		if (groupSumClump(start+1, nums, target-nums[start]))
			return true;
		if (nums[start] == d)
			return groupSumClump(start+1, nums, target-nums[start]) || groupSumClump(start+2, nums, target);
		return groupSumClump(start+1, nums, target);
	}



	/**
	 * Given an array of ints, is it possible to divide the ints into two groups, so that the sums of the two
	 * groups are the same. Every int must be in one group or the other. Write a recursive helper method that
	 * takes whatever arguments you like, and make the initial call to your recursive helper from splitArray().
	 * splitArray([2,2]) 	→ true
	 * splitArray([2,3]) 	→ false
	 * splitArray([5,2,3]) 	→ true
	 * splitArray([3,6,1,3,5])  */
	public static boolean splitArray(int[] nums) {
		return splitArrayHelper(0,0,nums,0);
	}

	/**
	 * This is a helper method for the splitArray method. */
	public static boolean splitArrayHelper(int desiredSum, int start, int[] nums, int sum) {
		if (start >= nums.length) return desiredSum == sum;
		if (splitArrayHelper(desiredSum+nums[start], start+1, nums, sum)) {
			return true;
		} else {
			return splitArrayHelper(desiredSum, start + 1, nums, sum + nums[start]);
		}
	}

	/**
	 * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of one group is a 
	 * multiple of 10, and the sum of the other group is odd. Every int must be in one group or the other. 
	 * Write a recursive helper method that takes whatever arguments you like, and make the initial call to your 
	 * recursive helper from splitOdd10(). 
	 * splitOdd10([5,5,5]) → true
	 * splitOdd10([5,5,6]) → false
	 * splitOdd10([5,5,6,1]) → true  */
	public static boolean splitOdd10(int[] nums) {
		return splitOdd10Helper(nums,0,0,0);
	}

	/**
	 * This is a helper method for the splitOdd10 method.  */
	private static boolean splitOdd10Helper(int nums[], int start, int sumGroup10, int sumGroupOdd) {		
		//base case - true if sum of one group is multiple of ten and sum of other group is odd.
		if (start >= nums.length) return sumGroup10 % 10 == 0 && sumGroupOdd % 2 != 0;
		if (splitOdd10Helper(nums, start+1, sumGroup10 + nums[start], sumGroupOdd)) {
			return true;
		} else {
			return splitOdd10Helper(nums, start+1, sumGroup10, sumGroupOdd + nums[start]);
		}
	}

	/** 
	 * Given an array of ints, is it possible to divide the ints into two groups, so that the sum of the two groups
	 * is the same, with these constraints: all the values that are multiple of 5 must be in one group, and all the
	 * values that are a multiple of 3 (and not a multiple of 5) must be in the other.
	 * split53([1,1]) 	→ true
	 * split53([1,1,1]) → false
	 * split53([2,4,2]) → true 
	 * split53([3, 5, 6, 10, 3, 3]) → true */
	public static boolean split53(int[] nums) {
		return split53Helper(nums,0,0,0);
	}

	/** 
	 * Helper method for the split53 method. */
	private static boolean split53Helper(int[] nums, int start, int groupSum, int groupSum1) {
		if (start >= nums.length) return groupSum == groupSum1;
		if (nums[start]%3 == 0 && nums[start]%5 != 0) {
			return split53Helper(nums, start+1, groupSum+nums[start], groupSum1);
		}
		if (nums[start]%5 == 0) {
			return split53Helper(nums, start+1, groupSum, groupSum1+nums[start]);
		}
		return split53Helper(nums, start+1, groupSum, groupSum1+nums[start]) || (split53Helper(nums, start+1, groupSum+nums[start], groupSum1));
	}

	public static void main(String[] args) {
		int[] nums = {3,5,8};
		int[] nums2 = {2,5,10,4};
		System.out.println(groupSum5(0,nums2,12));
	}
}
