
//countEvens 
public int countEvens(int[] nums) {
    int count = 0;
    for (int x = 0; x < nums.length; x++) {
        if (nums[x] % 2 == 0) count++;
    }
    return count;
}

//bigDiff
public int bigDiff(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    for (int n = 0; n < nums.length-1; n++) {
        min = Math.min(min, nums[n+1]);
        max = Math.max(max, nums[n+1]);
    }
    return (max - min);
}

//centeredAverage
public int centeredAverage(int[] nums) {
    int min = nums[0];
    int max = nums[0];
    int sum = 0;
    for (int n = 0; n < nums.length; n++) {
        min = Math.min(min, nums[n]);
        max = Math.max(max, nums[n]);
        sum += nums[n];
    }
    return (sum - (min + max)) / (nums.length-2);
}


//sum13
public int sum13(int[] nums) {
    int sum = 0;
    for (int i = 0; i<nums.length;) {
        if (nums[i] == 13) {
            i += 2;
        } else {
            sum += nums[i];
            i++;
        }
    }
    return sum;
}


//sum67
public int sum67(int[] nums) {
    int sum = 0;
    for (int i = 0; i<nums.length; i++){
        if (nums[i] == 6 && i < nums.length-1) {
            if (nums[i+1] != 7) nums[i+1] = 6;
            if (nums[i+1] == 7) nums[i+1] = 0;
        }
        if (nums[i] != 6) { 
            sum += nums[i]; 
        }
    } 
    return sum;
}

//has22
public boolean has22(int[] nums) {
    for (int i = 0; i < nums.length-1;i++){
        if (nums[i] == 2 && nums[i+1] == 2) return true;
    }
    return false;
}


//lucky13
public boolean lucky13(int[] nums) {
    for (int i=0; i<nums.length;i++){
        if(nums[i] == 1 ||  nums[i] == 3){
            return false;
        }
    }
    return true;
}


//sum28
public boolean sum28(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length;i++){
        if (nums[i] == 2) count++;
    }
    return (2 * count == 8);
}

//more14
public boolean more14(int[] nums) {
    int oneCount = 0, fourCount = 0;
    for (int x =0; x < nums.length; x++){
        if (nums[x] == 1) oneCount++;
        if (nums[x] == 4) fourCount++;
    }
    return (oneCount > fourCount);
}


//fizzArray
public int[] fizzArray(int n) {
    int[] result = new int[n];
    for (int x=0; x<n; x++) {
        result[x] = x;
    }
    return result;
}

//only14
public boolean only14(int[] nums) {
    boolean hasOneOrFour = false;
    for (int i = 0; i < nums.length; i++){
        if (nums[i] == 1 || nums[i] == 4) hasOneOrFour = true;
        else return false;
    }
    return nums.length < 1 ? true : hasOneOrFour;
}


//fizzArray2
public String[] fizzArray2(int n) {
    String[] result = new String[n];
    for (int z = 0; z < n; z++){
        result[z] = String.valueOf(z);
    }
    return result;
}


//n014
public boolean no14(int[] nums) {
    boolean hasOne = false, hasFour = false;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 1) hasOne = true;
        if (nums[i] == 4) hasFour = true;
    }
    return (hasOne && hasFour ? false : true);
}


//isEverywhere
public boolean isEverywhere(int[] nums, int val) {
    if (nums.length == 1) return true;
    for (int i = 0; i < nums.length; i++) {
        if (i != nums.length - 1 && nums[i] != val && nums[i+1] != val) return false;
        if (i == nums.length - 1 && nums[i] != val && nums[i-1] != val) return false;
    }
    return true;
}

//either24
public boolean either24(int[] nums) {
    boolean onlyTwo = false, onlyFour = false;
    for (int x = 0; x < nums.length; x++){
        if (x < nums.length-1 && nums[x] == 2 && nums[x+1] == 2) onlyTwo = true;
        if (x < nums.length-1 && nums[x] == 4 && nums[x+1] == 4) onlyFour = true;
    }
    return (onlyTwo && onlyFour ? false : onlyTwo || onlyFour);
}


//matchUp
public int matchUp(int[] nums1, int[] nums2) {
    int count = 0;
    for (int i = 0; i < nums1.length; i++){
        if((Math.abs(nums1[i] - nums2[i]) <= 2) && (nums1[i] != nums2[i])) count++;
    }
    return count;
}

//has77
public boolean has77(int[] nums) {
    for (int x = 0; x < nums.length; x++) {
        if (nums[x] == 7) {
            if ( x < nums.length-1 && nums[x+1] == 7) return true;
            x++;
            if (x < nums.length-1 && nums[x+1] == 7) return true;
        }
    }
    return false;
}


//has12
public boolean has12(int[] nums) {
    for (int i = 0; i < nums.length; ) {
        if (nums[i] == 1) {
            while (i < nums.length-1) {
                i++;
                if (nums[i] == 2) return true;
            }
        }
        i++;
    }
    return false;
}

//modThree
public boolean modThree(int[] nums) {
    for (int i = 0; i < nums.length-2; i++) {
        if (nums[i]%2 == 0 && nums[i+1]%2 == 0 && nums[i+2]%2 == 0) return true;
        if (nums[i]%2 != 0 && nums[i+1]%2 != 0 && nums[i+2]%2 != 0) return true;
    }
    return false;
}

//haveThree
public boolean haveThree(int[] nums) {
    if (nums.length < 3)return false;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
        if (i != 0 && i != nums.length-1 && nums[i] == 3) {
            if (nums[i-1] != 3 && nums[i+1] != 3) count++;
        } else if ((i == 0 && nums[i] == 3 && nums[i+1] != 3)
            || (i == nums.length-1 && nums[nums.length-1] == 3 && nums[nums.length-2] != 3)) count++;
    }
    return count == 3;
}


//twoTwo
public boolean twoTwo(int[] nums) {
    int count = 0, index = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 2) {
            count++;
            if (i > (index+1)) return false;
            else index = i;
        }
    }
    return count > 1 || count == 0;
}


//sameEnds
public boolean sameEnds(int[] nums, int len) {
    int j = 0, length = nums.length - 1;
    for (int i = len - 1; i >= 0; i--) {
        if (nums[j] != nums[length - i]) return false;
        j++;
    }
    return true;
}   

//tripleUp
public boolean tripleUp(int[] nums) {
    for (int i = 0; i < nums.length-2; i++) {
        if (nums[i] + 1 == nums[i+1] && nums[i+1] + 1 == nums[i+2]) return true;
    }
    return false;
}


//fizzArray3
public int[] fizzArray3(int start, int end) {
    int[] arr = new int[end-start];
    for (int i = start; i < end; i++) {
        arr[i-start] = i;
    }
    return arr;
}

//shiftLeft
public int[] shiftLeft(int[] nums) {
    if (nums.length == 0) return nums;
    int temp = nums[0];
    for (int i = 0; i < nums.length-1; i++) {
        nums[i] = nums[i+1];
    }
    nums[nums.length-1] = temp;
    return nums;
}

//tenRun
public int[] tenRun(int[] nums) {
    int t = 0;
    while (t < nums.length && nums[t] % 10 != 0) t++;
    for (int j = t+1; j < nums.length; j++) {
        if (nums[j] % 10 != 0) {
            nums[j] = nums[t];
        } else {
            t = j;
        }
    }
    return nums;
}

//pre4
public int[] pre4(int[] nums) {
    int[] arr = new int[nums.length];
    int four = nums.length;
    for (int i = 0; i < four; i++ ) {
        if (nums[i] == 4) {
            four = i;
            arr = new int[four];
            i = 0;
        }
        if (nums[i] != 4) arr[i] = nums[i];
    }
    return arr;
}

//post4
public int[] post4(int[] nums) {
    int[] arr = new int[nums.length];
    int four = 0, len = arr.length-1;
    for (int i = nums.length-1; i >= four; i--) {
        if (nums[i] == 4) {
            four = i;
            arr = new int[(nums.length-1)-four];
            i = nums.length-1;
            len = arr.length-1;
        }
        if (nums[i] != 4) {                             
            arr[len--] = nums[i];
            if (len < 0) break;
        }
    }
    return arr;
}

//notAlone
public int[] notAlone(int[] nums, int val) {
    for (int i = 1; i < nums.length-1; i++) {
        if (nums[i] == val && nums[i-1] != val && nums[i+1] != val) {
            if (nums[i-1] > nums[i+1]) nums[i] = nums[i-1];
            else nums[i] = nums[i+1];
        }
    }
    return nums;
}


//zeroFront
public int[] zeroFront(int[] nums) {
    int temp = 0;
    for (int i = nums.length - 1; i > 0; ) {
        if (i <= nums.length-1 && nums[i] == 0 && nums[i-1] != 0) {
            temp = nums[i];
            nums[i] = nums[i-1];
            nums[i-1] = temp;
            i++;
        } else {
            i--;
        }
    }
    return nums;
}

//withoutTen
public int[] withoutTen(int[] nums) {
    int i = 0, index = 0;
    while (i < nums.length) { 
        if (nums[i] == 10) {
            index = i;
            while (index < nums.length-1) {
                nums[index] = nums[index+1];
                index++;
            }
            nums[nums.length-1] = 0;
        }
        if (nums[i] != 10) { 
            i++;
        }
    }
    return nums;
}


//zeroMax
public int[] zeroMax(int[] nums) {
    int largestOdd = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            for (int j = i; j < nums.length; j++) {
                if(nums[j] % 2 != 0 && nums[j] >= largestOdd) {
                    largestOdd = nums[j];
                    nums[i] = largestOdd;
                }
            }
            largestOdd = 0;
        }
    }
    return nums;
}

//evenOdd
public int[] evenOdd(int[] nums) {
    int temp = 0, even = 0;
    for (int x = 0; x < nums.length; x++) {
        if (nums[x] % 2 == 0) {
            temp = nums[even];
            nums[even] = nums[x];
            nums[x] = temp;             
            even++;
        }
    }
    return nums;
}

//fizzBuzz
public String[] fizzBuzz(int start, int end) {
    String[] result = new String[end-start];
    for (int i = start; i < end; i++){
        if (i%5 == 0 && i%3 == 0) {
        result[i-start] = "FizzBuzz";
        } else if (i%3 == 0) {
            result[i-start] = "Fizz";
        } else if (i%5 == 0) {
            result[i-start] = "Buzz";
        } else {
            result[i-start] = String.valueOf(i);
        }
    }
    return result;
}
