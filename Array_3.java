/**
 * Solutions to coding challenges from codingbat.com
 * Section: Array-3
 * Author: Omar Ahmed
 */
 public class Array_3 {
    /**
     * Consider the leftmost and righmost appearances of some value in an array. We'll say that the "span" is the number of elements
     * between the two inclusive. A single value has a span of 1. Return the largest span found in the given array.
     * (Efficiency is not a priority.)
     * maxSpan([1, 2, 1, 1, 3])       → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */
     public static int maxSpan(int[] nums) {
        int max = 0, span = 0;
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

     /**
     * Return an array that contains exactly the same numbers as the given array, but rearranged so that every 3 is immediately 
     * followed by a 4. Do not move the 3's, but every other number may move. The array contains the same number of 3's and 4's, 
     * every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
     * fix34([1, 3, 1, 4])          → [1, 3, 4, 1]
     * fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
     * fix34([3, 2, 2, 4])          → [3, 4, 2, 2]
     */
     public int[] fix34(int[] nums) {
        int previous = 0;
        for (int i = 0, j = 1; i < nums.length; i++) {
            if (nums[i] == 3) {
                for (j = previous; j <= nums.length-1; j++) {
                    if (nums[j] == 4 && nums[j-1] != 3) {
                        int temp = nums[j];
                        nums[j] = nums[i+1];
                        nums[i+1] = temp;
                        previous = j;
                        break;
                    }
                }
            }
        }
        return nums;
    }
	
  
  /**
   *(This is a slightly harder version of the fix34 problem.) Return an array that contains exactly the same numbers as the given array,
   * but rearranged so that every 4 is immediately followed by a 5. Do not move the 4's, but every other number may move. The array 
   * contains the same number of 4's and 5's, and every 4 has a number after it that is not a 4. In this version, 5's may appear
   * anywhere in the original  array.
   * fix45([5, 4, 9, 4, 9, 5])      → [9, 4, 5, 4, 5, 9]
   * fix45([1, 4, 1, 5])            → [1, 4, 5, 1]
   * fix45([1, 4, 1, 5, 5, 4, 1])   → [1, 4, 5, 1, 1, 4, 5]
   */
   public int[] fix45(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 4 && nums[i+1] != 5) {
                for ( ; nums[j] != 5; j++);
                if (j > 0 && nums[j-1] == 4) {
                    i--;
                    j++;
                    continue;
                } else {
                    nums[j] = nums[i+1];
                    nums[i+1] = 5;					
                }
            }
        }
        return nums;
    }
  
  /**
   * Given a non-empty array, return true if there is a place to split the array so that the sum of the numbers on one
   * side is equal to the sum of the numbers on the other side.
   * canBalance([1, 1, 1, 2, 1])  → true
   * canBalance([2, 1, 1, 2, 1])  → false
   * canBalance([10, 10])         → true
   */
   public boolean canBalance(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left += nums[i];
            int right = 0;
            for (int j = nums.length-1; j >= i; j--) {
                right += nums[j]; 
                if (left == right && i+1 + (nums.length-j) == nums.length) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Given two arrays of ints sorted in increasing order, outer and inner, return true if all of the numbers in inner appear in outer. 
     * The best solution makes only a single "linear" pass of both arrays, taking advantage of the fact that both arrays
     * are already in sorted order.
     * linearIn([1, 2, 4, 6], [2, 4])       → true
     * linearIn([1, 2, 4, 6], [2, 3, 4])    → false
     * linearIn([1, 2, 4, 4, 6], [2, 4])    → true
     */
    public boolean linearIn(int[] outer, int[] inner) {
        for (int i = 0; i < inner.length; ) {
            for (int j = 0; j < outer.length && i != inner.length; j++) {
                if (inner[i] != outer[j]) {
                    continue;
                } else {
                    i++;
                }
            }
            return i == inner.length;
        }
        return true;
    }

    /**
     * Given n>=0, create an array length n*n with the following pattern, shown here for n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1}
     * (spaces added to show the 3 groups).
     * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
     * squareUp(2) → [0, 1, 2, 1]
     * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     */
    public int[] squareUp(int n) {
        int[] arr = new int[n*n];
        int num = n, k = 0;        
        for (int i = arr.length-1; i >= 0; i -= n) {
            for (int j = 1; j <= num; j++) {
                arr[i - k++] = j;
            }
            k = 0;
            num--;
        }
        return arr;
    }

    /**
     * Given n>=0, create an array with the pattern {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n} (spaces added to show the grouping).
     * Note that the length of the array will be 1 + 2 + 3 ... + n, which is known to sum to exactly n*(n + 1)/2.
     * seriesUp(3) → [1, 1, 2, 1, 2, 3]
     * seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
     * seriesUp(2) → [1, 1, 2]
     */
    public int[] seriesUp(int n) {
        int[] arr = new int[n*(n+1)/2];
        int num = 1;
        for (int i = 0; i < arr.length; ) {
            for (int j = 1; j <= num; j++) {
                arr[i++] = j;
            }
            num++;
        }
        return arr;
    }

    /**
     * We'll say that a "mirror" section in an array is a group of contiguous elements such that somewhere in the array, the same 
     * group appears in reverse order. For example, the largest mirror section in {1, 2, 3, 8, 9, 3, 2, 1} is length 3
     * (the {1, 2, 3} part). Return the size of the largest mirror section found in the given array.
     * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
     * maxMirror([1, 2, 1, 4]) 		→ 3
     * maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
     */
    public int maxMirror(int[] nums) {
        int max = 0, count = 0, pos = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >= i; j--) {
                if (i+pos <= nums.length-1 && j-pos >= 0 && nums[i+pos] == nums[j-pos]) {
                    count++;
                    pos++;
                    j++;
                    } else {
                        count = 0;
                        pos = 0;
                        continue;       
                    }
                    if (count > max) {
                        max = count;
                    }
                }   
            }
        return max;
    }

    /**
     * Say that a "clump" in an array is a series of 2 or more adjacent elements of the same value. 
     * Return the number of clumps in the given array.
     * countClumps([1, 2, 2, 3, 4, 4]) 	→ 2
     * countClumps([1, 1, 2, 1, 1]) 	→ 2
     * countClumps([1, 1, 1, 1, 1]) 	→ 1
     */
    public int countClumps(int[] nums) {
        int count = 0, len = nums.length-1;
        for (int i = 0, j = 0; i < len; i++) {
            if (nums[i] == nums[i+1]) {           
                j = i;              
                while (j+1 <= len && nums[++j] == nums[i]);
                if (j - i >= 2 || nums[len-1] == nums[len]) {
                    count++;
                }
                int size = j - i;
                i += size - 1;
            }
        }
        return count;
    }


 }
