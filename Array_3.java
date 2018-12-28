/**
 * Coding solutions to challenges from codingbat.com
 * Section: Array-3
 * Author: Omar Ahmed
 */
 
 public class Array_3 {
    /**
     * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" 
     * is the number of elements between the two inclusive. A single value has a span of 1. Returns the largest 
     * span found in the given array. (Efficiency is not a priority.)
     * maxSpan([1, 2, 1, 1, 3])       → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */
     public int maxSpan(int[] nums) {
        int max = 0;
        int span = 0;

        if (nums.length > 0 && nums[0] == nums[nums.length-1]) {
          return nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    span = j - i + 1;
                    if (span > max) {
                        max = span;
                    }
                }
            }
        }
        return max;	 
    }
 }
 
