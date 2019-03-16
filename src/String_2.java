//doubleChar
public String doubleChar(String str) {
  String result = "";
  for (int i = 0; i < str.length(); i++) {
    result += str.charAt(i);
    result += str.charAt(i);
  }
  return result;
}


//countHi
public int countHi(String str) {
  int count = 0;
  for (int i = 0; i < str.length()-1; i++) {
    if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i') {
      count++;
    }
  }
  return count;
}


//catDog
public boolean catDog(String str) {
  int countCat = 0, countDog = 0;
  
  for (int i = 0; i < str.length()-2; i++) {
     if (str.substring(i, i+3).equals("cat")) countCat++;
     if (str.substring(i,i+3).equals("dog")) countDog++;
   }
   return countCat == countDog;
}


//countCode
public int countCode(String str) {
  int count = 0;  
  for (int i = 0; i < str.length()-3; i++) {
    if (str.substring(i,i+2).equals("co")) {
      if(str.charAt(i+3) == 'e') count++;
    }
  }
  return count;
}


//endOther
public boolean endOther(String a, String b) {
  return a.length() > b.length() ? 
  a.substring(a.length() - b.length()).toLowerCase().equals(b.toLowerCase()) :
  b.substring(b.length() - a.length()).toLowerCase().equals(a.toLowerCase());
}


//xyzThere
public boolean xyzThere(String str) {
  int index = 0, i = 0;

  while ( (i = str.indexOf("xyz", index)) != -1) {
    if (i == 0 || str.charAt(i-1) != '.') return true;    
    index = str.indexOf("xyz",index);
    index++;
  }
  return false;
}


//bobThere
public boolean bobThere(String str) {
 for (int i = 0; i < str.length()-2; i++) {
   if (str.charAt(i) == 'b' && str.charAt(i+2) == 'b') {
     return true;
   }
 }
  return false;
}


//xyBalance
public boolean xyBalance(String str) {
  int x = 0, y = 0;
  for (int i = str.length()-1; i >= 0; i--) {
    if (str.charAt(i) == 'y') y = i;
    if (str.charAt(i) == 'x') {
      x = i;
      if (x >= y) return false;
    }
  }
  return true;
}


//mixString
public String mixString(String a, String b) {
  String result = "";
  String smallerString = a.length() < b.length() ? a : b;
  
  for (int i = 0; i < smallerString.length(); i++) {
    result += a.charAt(i)+""+b.charAt(i);
  }
  result += a.length() > smallerString.length() ? 
      a.substring(smallerString.length()) : b.substring(smallerString.length());

  return result; 
}


//repeatEnd
public String repeatEnd(String str, int n) {
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < n; i++) {
    sb.append(str.substring(str.length() - n));  
  }
  return sb.toString();
}


//repeatFront
public String repeatFront(String str, int n) {
  StringBuilder result = new StringBuilder();
  result.append(str.substring(0,n));
  for (int i = n-1; i >= 0; i--) {
    result.append(str.substring(0,i));  
  }
  return result.toString();
}


//repeatSeparator 
public String repeatSeparator(String word, String sep, int count) {
  StringBuilder result = new StringBuilder();
  for (int i = 0; i < count; i++) {
    if (i > 0) result.append(sep);
    result.append(word);            
  }
  return result.toString();
}


//prefixAgain
public boolean prefixAgain(String str, int n) {
  String searchString = str.substring(0,n);
  for (int i = n; i <= (str.length() - searchString.length()); i++) {
    if (str.substring(i, i + searchString.length()).equals(searchString)) return true;
  }
  return false;
}


//xyzMiddle
public boolean xyzMiddle(String str) {
  int index = 0, diff = 0;
  
  for (int i = 0; i < str.length()-2; i++) {
    if (str.substring(i,i+3).equals("xyz")) {
        index = i;
        diff = Math.abs(((str.length()-1) - (index + 2)) - index);
        if (diff <= 1) return true;
    }
  }
  return false;
}


//sameStarChar
public boolean sameStarChar(String str) {
  for (int i = 0; i < str.length()-1; i++) {
    if (i == 0 && str.charAt(i) == '*') continue;
    if (str.charAt(i) == '*' && str.charAt(i-1) != str.charAt(i+1)) return false;
  }
  return true;
}


//oneTwo
public String oneTwo(String str) {
  StringBuilder result = new StringBuilder();
  for (int i = 0; i < str.length(); i += 3) {
    if (str.length() - i > 2) {
      result.append(str.substring(i+1, i+3));
      result.append(str.charAt(i));
    }
  }
  return result.toString();
}


//zipZap
public String zipZap(String str) {
  for (int i = 0; i < str.length()-2; i++) {
    if (str.charAt(i) == 'z' && str.charAt(i+2) == 'p') {
      str = str.substring(0,i+1) + str.substring(i+2);
    }
  }
  return str;
}


//starOut
public String starOut(String str) {
  String temp = "";
  int i = 0;
  
  while (i < str.length()) {
    if ((i > 0 && str.charAt(i-1) == '*') || ( i < str.length()-1 && str.charAt(i+1) == '*' )) {
        i++;
        continue;
      }
      if (str.charAt(i) == '*') {
        i++;
        continue;
      } else {
        temp += str.charAt(i);
      }
      i++;
    }
    return temp;
}

//plusOut
public String plusOut(String str, String word) {
  String result = "", temp = "";
  for (int i = 0, j = 0; i < str.length(); i++) {
    if (str.charAt(i) == word.charAt(j)) {
      temp += str.charAt(i);        
      j++;
      if (j < word.length()) continue;
      else {
        result += temp;
        temp = "";
        j = 0;
      }
    } else result += "+";
  }
  return result;
}


//wordEnds
public String wordEnds(String str, String word) {
  String result = "";
  for (int i = 0; i <= str.length() - word.length(); i++) {
    if (str.substring(i, i + word.length()).equals(word)) {
      if (i - 1 < 0) result += str.length() > word.length() ? str.charAt(i + word.length()) : "";
      else if (i + word.length() + 1 > str.length()) result += str.charAt(i-1);
      else result += str.charAt(i-1) + str.substring(i+word.length(),i+word.length()+1);
    }
  }   
  return result;
}
