/**
 * Solutions to coding challenges from codingbat.com
 * Section: String-3
 * Date: 11/29/2018
 * Author: Omar Ahmed
 *
 */
public class String_3 {
	/**
	 *	Given a string, count the number of words ending in "y" or "z" -- so 'y' in "heavy" and 'z' in "fez" count, but not
	 * the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
	 * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
	 *
	 * countYZ("fez day")   → 2
	 * countYZ("day fez")   → 2
	 * countYZ("day fyyyz") → 2
	 */
	public static int countYZ(String str) {
		str = str.toLowerCase();
		int count = 0;
	  
	  	for (int i = 0; i < str.length(); i++) {
	   	if (i < str.length()-1 && (str.charAt(i) == 'y' || str.charAt(i) == 'z') && !Character.isLetter(str.charAt(i+1))) {
			  count++;
			} else if (i == str.length()-1 && (str.charAt(i) == 'y' || str.charAt(i) == 'z')) {
				count++;
			}
		}	
		return count;  
	}

	/**
	 * Given two strings, base and remove, return a version of the base string where all instances of the remove string
	 * have been removed (not case sensitive). You may assume that the remove string is length 1 or more. Remove only 
	 * non-overlapping instances, so with "xxx" removing "xx" leaves "x".
	 *
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") 	→ "Hllo thr"
	 * withoutString("Hello there", "x") 	→ "Hello there"
	 */
	public static String withoutString(String base, String remove) {
		StringBuilder sb = new StringBuilder();
	  	String baseLowercase = base.toLowerCase();
	  	String removeLowercase = remove.toLowerCase(); 
	  
	  	int j = 0;
		for (int i = 0; i <= base.length() - remove.length(); i++) {
		  if (baseLowercase.substring(i,i+remove.length()).equals(removeLowercase)) {
				sb.append(base,j,i);
				i = i + remove.length()-1;					
				j = i+1;
			}
		}
		return sb.append(base,j,base.length()).toString();
	}

	/**
	 * Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances 
	 * of "not" anywhere in the string (case sensitive).
	 * 
	 * equalIsNot("This is not") 		   → false
	 * equalIsNot("This is notnot") 	   → true
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */
	public static boolean equalIsNot(String str) {
		int isCount = 0, notCount = 0;
		int len = str.length();

		for (int i = 0; i < len; i++) {
			if (i+1 < len && str.substring(i,i+2).equals("is")) {
		  		isCount++;
			}
			if (i+2 < len && str.substring(i,i+3).equals("not")) {
				notCount++;
			}
		}
		return isCount == notCount;
	}

	/**
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. Return true 
	 * if all the g's in the given string are happy.
	 *
	 * gHappy("xxggxx")     → true
	 * gHappy("xxgxx")      → false
	 * gHappy("xxggyygxx")  → false
	 */
	public static boolean gHappy(String str) {
	  for (int i = 0; i < str.length(); i++) {
	     if (str.charAt(i) == 'g') {
            int end = i + 1;
            int j = end;
				for ( ; j < str.length() && str.charAt(j) == 'g'; j++);
				if (j == end) {
				  return false;
				} else {
					i = j;
				}
			}
		}
		return true;
   }

   /**
    * We'll say that a "triple" in a string is a char appearing three times in a row. Return the number of triples in the given string. 
    * The triples may overlap.

    * countTriple("abcXXXabc")   → 1
    * countTriple("xxxabyyyycd") → 3
    * countTriple("a")           → 0
    */
   public static int countTriple(String str) {
      int count = 0;
   
      for (int i = 0; i < str.length(); i++) {
         int j = i;
         while(++j < str.length() && str.charAt(j) == str.charAt(i));
         if (j - i >= 3) {
            count++;
         } 
      }  
      return count;
   }

   /**
    * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0 if there are no digits 
    * in the string. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. 
    * Integer.parseInt(string) converts a string to an int.)
    *
    * sumDigits("aa1bc2d3")   → 6
    * sumDigits("aa11b33")    → 8
    * sumDigits("Chocolate")  → 0
    */
   public static int sumDigits(String str) {
      int sum = 0;
  
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         if (Character.isDigit(ch)) {
            sum += Integer.parseInt(String.valueOf(ch));
         }
      }
      return sum;
   }

   /**
    * Given a string, return the longest substring that appears at both the beginning and end of the string without overlapping. 
    * For example, sameEnds("abXab") is "ab".
    *
    * sameEnds("abXYab")   → "ab"
    * sameEnds("xx")       → "x"
    * sameEnds("xxx")      → "x"
    */
   public static String sameEnds(String string) {
      StringBuilder res = new StringBuilder();
      int len = string.length()/2;
     
      for (int i = 0, j = len; i <= len-1 && j < string.length(); j++) {
         if (string.charAt(j) == string.charAt(i)) {
            res.append(string.charAt(i));
            i++;
         }
      }
      return res.toString();
   }

   /**
    *Given a string, look for a mirror image (backwards) string at both the beginning and end of the given string. In other words, zero or 
    * more characters at the very begining of the given string, and at the very end of the string in reverse order (possibly overlapping). 
    * For example, the string "abXYZba" has the mirror end "ab".
    *
    * mirrorEnds("abXYZba") → "ab"
    * mirrorEnds("abca")    → "a"
    * mirrorEnds("aba")     → "aba"
    */
   public static String mirrorEnds(String string) {
      int end = string.length()-1, k = end;
      int i = 0;
      for ( ; i < string.length() && string.charAt(i) == string.charAt(k); i++, k--); 
      if (i == end) {
         return string;
      }
      return string.substring(0,i);
   }

   /**
    * Given a string, return the length of the largest "block" in the string. A block is a run of adjacent chars that are the same.
    *
    * maxBlock("hoopla") → 2
    * maxBlock("abbCCCddBBBxx") → 3
    * maxBlock("") → 0
    */
   public static int maxBlock(String str) {
      int max = 0;
      
      for (int i = 0; i < str.length(); i++) {
         int count = 0;
         char ch = str.charAt(i);
         while (++count + i < str.length() && str.charAt(count + i) == ch);         
         if (count > max) {
            max = count;
         }
      }      
      return max;
   }

   /**
    * Given a string, return the sum of the numbers appearing in the string, ignoring all other characters. A number is a series of 1 or more digit 
    * chars in a row. (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'. Integer.parseInt(string) converts a string 
    * to an int.)
    *
    * sumNumbers("abc123xyz") → 123
    * sumNumbers("aa11b33") → 44
    * sumNumbers("7 11") → 18
    */
   public static int sumNumbers(String str) {
      int sum = 0;
      for (int i = 0; i < str.length(); i++) {
         if (Character.isDigit(str.charAt(i))) {
            int j = i;
            while(++j < str.length() && Character.isDigit(str.charAt(j)));
            sum += Integer.parseInt(str.substring(i,j));
            i = j;
         }
      }
      return sum;
   }

	/**
	 * Given a string, return a string where every appearance of the lowercase word "is" has been replaced with
	 * "is not". The word "is" should not be immediately preceded or followed by a letter. -- So for example the "is"
	 * in "this" does not count. (Note: Character.isLetter(char) tests if a char is a letter.)
	 *
	 * notReplace("is test")		 → "is not test"
	 * notReplace("is-is") 			 → "is not-is not"
	 * notReplace("This is right") → "This is not right"
	 */

	public static String notReplace(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (i+1 < str.length() && str.substring(i,i+2).equals("is")) {
				if (i-1 >= 0 && Character.isLetter(str.charAt(i-1)) 
						|| (i+2 < str.length() && Character.isLetter(str.charAt(i+2)))) {
					sb.append(str.charAt(i));
				} else {
					sb.append("is not");
					i += 1;
				}
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
      System.out.println(notReplace("Dis is bliss"));
	}
}
