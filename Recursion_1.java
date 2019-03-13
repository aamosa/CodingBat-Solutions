/*
 * Solutions to coding challenges from codingbat.com
 * Section: Recursion_1
 * Date: 12/15/2018
 * Author: Omar Ahmed
 *
 */
 import java.util.Arrays;

 public class Recursion_1 {
   /*
    * Given n of 1 or more, return the factorial of n, which is n * (n-1) * (n-2) ... 1. 
    * Compute the result recursively (without loops).
    */
   public static int factorial(int n) {
      if (n < 1) {
         return 1;
      }
      return n * factorial(n-1);
   }

   /*
    * We have a number of bunnies and each bunny has two big floppy ears. We want to compute
    * the total number of ears across all the bunnies recursively (without loops or 
    * multiplication). */
   public static int bunnyEars(int bunnies) {
      if (bunnies == 0)
         return 0;
      return 2 + bunnyEars(bunnies-1);
   }

   /*
    * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
    * The first two values in the sequence are 0 and 1 (essentially two base cases). Each subsequent value 
    * is the sum of the previous two values, so the whole sequence is: 0,1,1,2,3,5,8,13,21 and so on. 
    * Define a recursive fibonacci(n) method that returns the nth fibonacci number, with n = 0 representing
    * the start of the sequence. */
   public static int fibonacci(int n) {
      if (n <= 1) return n;
      return fibonacci(n-1) + fibonacci(n-2);
   }

   /*
    * We have bunnies standing in a line, numbered 1,2,... The odd bunnies (1,3,...) have normal
    * 2 ears. The even bunnies (2,4,...) we'll say have 3 ears, because they each have a raised 
    * foot. Recursively return the number of "ears" in the bunny line 1,2,...n (without loops or 
    * multiplication). */
   public static int bunnyEars2(int bunnies) {
      int ears = 2;
      if (bunnies == 0) return 0;
      if (bunnies%2 == 0) {
         ears = 3;
      }
      return ears + bunnyEars2(bunnies-1);
   }

   /*
    * We have a triangle made of blocks. The topmost row has 1 block, the next row down has
    * 2 blocks, the next row has 3 blocks, and so on. Compute recursively (no loops or multiplication)
    * the total number of blocks in such a triangle with the given number of rows. */
   public static int triangle(int rows) {
      if (rows == 0) return 0;
      return rows + triangle(rows-1);
   }

   /*
    * Given a non-negative int n, return the sum of its digits recursively (no loops).
    * sumDigits(126) → 9
    * sumDigits(49) → 13
    * sumDigits(12) → 3 */
   public static int sumDigits(int n) {
      if (n/10 == 0) return n;
      return n%10 + sumDigits(n/10);
   }

   /*
    * Given a non-negative int n, return the count of the occurrences of 7 as a digit.
    * count7(717) → 2
    * count7(7) → 1 */
   public static int count7(int n) {
      int s = 0;
      if (n%10 == 7) {
         s = 1;
      }  
      if (n == 0) return 0;
      return s + count7(n/10);      
   }

   /*
    * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 
    * 8 as a digit, except that 8 with another 8 immediately to its left count double.
    * count8(8) → 1
    * count8(8818) → 4 */ 
   public static int count8(int n) {
      int s = 0;     
      if (n%10 == 8) {
         s = 1;
         if ((n/10)%10 == 8) s = 2;       
      }
      if (n == 0) return 0;
      return s + count8(n/10);
   }

   /*
    * Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power.
    * powerN(3,2) → 9 
    * powerN(3,3) → 27 */
   public static int powerN(int base, int n){
      if (n == 0) return 1;
      return base * powerN(base, n-1);     
   }

   /*
    * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
    * countX("xxhixx") → 4
    * countX("xhixhix") → 3 */ 
   public static int countX(String str) {
      if (str.length() <= 0) return 0;
      int s = 0;     
      if (str.substring(str.length()-1).equals("x")) s = 1;
      return s + countX(str.substring(0,str.length()-1));
   }
   

   /*
    * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in
    * the string.
    * countHi("xxhixx") → 1
    * countHi("xhixhix") → 2 */ 
   public static int countHi(String str) {
      if (str.length() <= 1) return 0;
      if (str.substring(0,2).equals("hi")) 
         return 1 + countHi(str.substring(1));
      return countHi(str.substring(1));
   }

   /*
    * Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars
    * have been changed to 'y' chars.
    * changeXY("xxhixx") → yyhiyy */ 
   public static String changeXY(String str) {
      if (str.length() == 0) return "";
      if (str.charAt(0) == 'x') {
         return "y" + changeXY(str.substring(1));
      }
      return str.charAt(0) + changeXY(str.substring(1));
   }

   /* 
    * Given a string, compute recursively (no loops) a new string where all appearances of "pi"
    * have been replaced by "3.14".
    * changePi("xpix") → "x3.14x"
    * changePi("pipi") → "3.143.14" */
   public static String changePi(String str) {
      if (str.length() <= 1) return str;
      return str.substring(0,2).equals("pi") ? "3.14"+changePi(str.substring(2)) : str.charAt(0)+changePi(str.substring(1)); 
   }

   /*
    * Given a string, compute recursively a new string where all the 'x' chars have been removed. */
   public static String noX(String str) {
      if (str.length() == 0) return str;
      return (str.charAt(0) != 'x' ? str.charAt(0) : "") + noX(str.substring(1));
   }

   /*
    * Given an array of ints, compute recursively if the array contains a 6.
    * array6([1,6,4], 0) → true
    * array6([1,4], 0) → false  */
   public static boolean array6(int[] nums, int index) {
      if (index > nums.length-1 || nums.length == 0) return false;
      return nums[index] == 6 || array6(nums, index+1);
   }

   /*
    * Given an array of ints, compute recursively the number of times that the value 11 appears in the array. 
    * array11([1,2,11]) → 1  */
   public static int array11(int[] nums, int index) {
      if (index > nums.length-1 || nums.length == 0) return 0;
      return nums[index] == 11 ? 1+array11(nums,index+1) : array11(nums, index+1);
   }

   /*
    * Given an array of ints, compute recursively if the array contains somewhere a 
    * value followed in the array by that value times 10. We'll use the convention of considering only 
    * the part of the array that begins at the given index. In this way, a recursive call can pass index+1
    * to move down the array. The initial call will pass in index as 0.
    * array220([1,2,20], 0) → true
    * array220([3], 0) → false  */
   public static boolean array220(int[] nums, int index) {
      if (index > nums.length-2 || nums.length == 0) return false;
      return nums[index+1] == nums[index]*10 || array220(nums,index+1); 
   }

   /*
    * Given a string, compute recursively a new string where all adjacent chars are now separated by a '*'.
    * allStar("hello") → "h*e*l*l*o"
    * allStar("abc") → "a*b*c"
    * allStar("ab") → "a*b" */
   public static String allStar(String str) {
      String res = "";
      if (str.length() <= 1) return str;
      res += str.charAt(0);
      return res + "*" + allStar(str.substring(1));
   }


   /*
    * Given a string, compute recursively a new string where identical chars that are adjacent in the original
    * string are separated from each other by a '*'.
    * pairStar("hello") → "hel*lo"
    * pairStar("xxyy") → "x*xy*y" */
   public static String pairStar(String str) {
      if (str.length() <= 1) return str;
      return str.charAt(0) + (str.charAt(0) == str.charAt(1) ? "*" : "") + pairStar(str.substring(1));
   }

   /*
    * Given a string, compute recursively a new string where all lowercase 'x' chars have been moved to 
    * the end of the string.
    * endX("xxre") → "rexx" 
    * endX("xxhixx") → "hixxxx"
    * endX("xhixhix") → "hihixxx" */
   public static String endX(String str) {
      if (str.length() <= 0) return str;
      if (str.charAt(0) == 'x')
         return endX(str.substring(1))+"x";
      return str.charAt(0)+endX(str.substring(1));    
   }

   /*
    * We'll say that a "pair" in a string is two instances of a char separated by a char. So in "AxA"
    * the "A's" make a pair. Pairs can overlap. Recursively compute the number of pairs in the given string.
    * countPairs("axa") → 1
    * countPairs("axax") → 2 */
   public static int countPairs(String str) {
      if (str.length() <= 2) return 0;
      return str.charAt(0) == str.charAt(2) ? 1+countPairs(str.substring(1)) : countPairs(str.substring(1));
   }

   /*
    * Count recursively the total number of "abc" and "aba" substrings that appear in the given string.
    * countAbc("abc") → 1
    * countAbc("abaxxaba") → 2 */
   public static int countAbc(String str) {
      if (str.length() <= 2) return 0;          
      return str.substring(0,3).equals("abc") || str.substring(0,3).equals("aba") ? 
      1+countAbc(str.substring(1)) : countAbc(str.substring(1));
   }

   /*
    * Given a string, compute recursively (no loops) the number of "11" substrings in the string.
    * The "11" substring should not overlap.
    * count11("11abc11") → 2
    * count11("111") → 1 */
   public static int count11(String str) {
      if (str.length() <= 1) return 0;
      if (str.substring(0,2).equals("11")) {
         return 1+count11(str.substring(2));
      }
      return count11(str.substring(1));
   }

   /*
    * Given a string, return recursively a "cleaned" string where adjacent chars that are the same
    * have been reduced to a single char. 
    * stringClean("yyzzza") → "yza"
    * stringClean("abbbcdd") → "abcd" */
   public static String stringClean(String str) {
      if (str.length() <= 1) return str;
      if (str.charAt(0) == str.charAt(1)) {
         return stringClean(str.substring(1));
      }
      return str.charAt(0) + stringClean(str.substring(1));
   }

   /*
    * Given a string, compute recursively the number of times lowercase "hi" appears in the string,
    * however do not count "hi" that have a "x" immediately before them.
    * countHi2("ahixhi") → 1
    * countHi2("ahibhi") → 2 
    * countHi2("hihihi") → 3 */
   public static int countHi2(String str) {
      if (str.length() <= 2) {
         if (str.equals("hi"))
            return 1;
         return 0;
      }
      if (str.substring(str.length()-2).equals("hi") && str.charAt(str.length()-3) != 'x')
         return 1 + countHi2(str.substring(0,str.length()-1));
      return countHi2(str.substring(0,str.length()-1));
   }

   /*
    * Given a string that contains a single pair of parenthesis, compute recursively a new string
    * made of only of the parenthesis and their contents.
    * parenBit("xyz(abc)123") → "(abc)"
    * parenBit("x(hello)") → "(hello)" */
   public static String parenBit(String str) {
      if (str.charAt(0) == '(' && str.charAt(str.length()-1) == ')') 
         return str;
      if (str.charAt(0) == '(')
         return parenBit(str.substring(0,str.length()-1));
      return parenBit(str.substring(1));
   }

   /*
    * Given a string, return true if it is nesting of zero or more pairs of parenthesis, like "(())" or
    * "((()))". Suggestion: check the first and last chars, and then recur on what's inside them.
    * nestParen("(())") → true
    * nestParen("((()))") → true
    * nestParen("(((x)))") → false */
   public static boolean nestParen(String str) {
      if (str.length() <= 0) return true;
      if (str.charAt(0) != '(' || str.charAt(str.length()-1) != ')')
         return false;
      return nestParen(str.substring(1,str.length()-1));
   }  

   /*
    * Given a string and non-empty substring "sub", compute recursively the number of times
    * that sub appears in the string, without the "sub" strings overlapping.
    * strCount("catcowcat", "cat") → 2
    * strCount("catcowcat", "cow") → 1
    * strCount("iiiijj", "ii") → 2 */
   public static int strCount(String str, String sub) {
      if (str.length() < sub.length()) return 0;
      if (str.substring(0,sub.length()).equals(sub)) 
         return 1+strCount(str.substring(sub.length()), sub);
      return strCount(str.substring(1), sub);
   }

   /*
    * Given a string and non-empty substring "sub", compute recursively if at least n copies of 
    * sub appear in the string, somewhere possibly with overlapping. N will be non-negative.
    * strCopies("catcowcat", "cat", 2) → true
    * strCopies("catcowcat", "cow", 2) → false */
    public static boolean strCopies(String str, String sub, int n) {
      if (str.length() < sub.length())
         return n == 0;
      if (str.substring(0,sub.length()).equals(sub))
         return strCopies(str.substring(1), sub, n-1);
      return strCopies(str.substring(1), sub, n);
    } 

   /*
    * Given a string and a non-empty substring "sub", compute recursively the largest substring
    * which starts and ends with sub and return its length.
    * strDist("catcowcat", "cat") → 9
    * strDist("xyx", "z") → 0
    * strDist("hiHellohihihi", "ll") → 2 */
   public static int strDist(String str, String sub) {
      if (str.length() < sub.length()) return 0;
      if (str.substring(0,sub.length()).equals(sub)) {
         if (str.substring(str.length()-sub.length()).equals(sub))
            return str.length();
         return strDist(str.substring(0,str.length()-1), sub);
      }
      return strDist(str.substring(1), sub);
   }

   public static void main(String[] args) {
      System.out.println(strDist("hiHellohihihi", "ll"));
   }
}
