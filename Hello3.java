
import java.security.Key;
import java.util.*;

public class Hello3 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static boolean containsDuplicates(int[] nums) { // sorting approach
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicates1(int[] nums) { // hashet approach

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
            nums[i] = i;

        for (int num : nums) {
            if (set.contains(num)) {
                return false;
            }
            set.add(num);
        }
        return true;
    }

    public static void moveZeroes(int[] nums) { // optimal
        int nonzero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nonzero];
                nums[nonzero] = nums[i];
                nums[i] = temp;
                nonzero++;
            }

        }
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;

        }
    }

    public static String reverseWords(String str) {
        char[] s = str.toCharArray();
        int start = 0;

        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reversePart(s, start, i - 1);
                start = i + 1;

            }
        }
        return new String(s);
    }

    public static void reversePart(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public static void mergeTwoSortedArray(int[] num1, int m, int[] num2, int n) { // brute force
        m = num1.length;
        n = num2.length;

        for (int j = 0, i = m; j < n; j++) {
            num1[i] = num2[j];
            i++;
        }
        Arrays.sort(num1);

    }

    public static int[] mergeTwoSortedArray1(int[] num1, int[] num2) {
        int m = 3;
        int n = 3;
        int i = m - 1;
        int k = m + n - 1;
        int j = n - 1;
        while (j >= 0) {
            if (i >= 0 && num1[i] > num2[j]) {
                num1[k] = num1[i];
                k--;
                i--;
            } else {
                num1[k] = num2[j];
                k--;
                j--;
            }
        }
        return num1;

    }

    public static boolean isPalindrome(String s) { // check if it is palindrome after removing character
        String str = s.replaceAll("[A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            return true;
        } else if (str == "") {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validPalindrom(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return checkPalindrom(str, left + 1, right) || checkPalindrom(str, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkPalindrom(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int SumClosest(int[] nums, int target) {
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target - currSum);
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = currSum;
                }
                if (currSum == target) {
                    return currSum;
                } else if (currSum < target) {
                    j++;
                } else {
                    k--;
                }

            }
        }
        return closestSum;
    }

    public static void sortColors(int[] nums) {
        int left = 0;
        int temp = 0;
        int right = nums.length - 1;

        while (temp <= right) {
            if (nums[temp] == 0) {
                int k = nums[temp];
                nums[temp] = nums[left];
                nums[left] = k;
                temp++;
                left++;
            } else if (nums[temp] == 1) {
                temp++;
            } else {
                int l = nums[temp];
                nums[temp] = nums[right];
                nums[right] = l;
                right--;

            }
        }
    }

    public static int[] findSquare(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                arr[pos] = leftSq;
                left++;
            } else {
                arr[pos] = rightSq;
                right--;
            }
            pos--;
        }
        return arr;
    }

    public static int validTraingle(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    public static int numRescueBoats(int[] nums, int limit) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[j] + nums[k] <= limit) {
                j++;
                k--;
            } else {
                k--;
            }
            count += 1;
        }
        return count;
    }

    public static int countSubstring(String s) {
        char[] arr = s.toCharArray();
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int left = i;
                int right = j;
                boolean isPalindrome = true;
                while (left < right)
                    if (arr[left] != arr[right]) {
                        isPalindrome = false;
                        break;
                    } else {
                        left++;
                        right--;
                    }

                if (isPalindrome) {
                    count++;
                }
            }
        }
        return count;

    }

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (nums[i] == nums[j]) {
                    return nums[i];
                }

            }
        }
        return -1;
    }

    public static int findTheDistance(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isFar = true;
            for (int j = 0; j < m; j++) {
                int diff = Math.abs(arr1[i] - arr2[j]);
                if (diff <= d) {
                    isFar = false;
                    break;
                }
            }
            if (isFar) {
                count++;
            }

        }
        return count;

    }

    public static int[] kthSmallest(int[] arr, int k) {
        int n = arr.length;

        List<int[]> fractions = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                fractions.add(new int[] { arr[i], arr[j] });
            }
        }
        Collections.sort(fractions, (a, b) -> {
            return a[0] * b[1] - a[1] * b[0];
        });
        return fractions.get(k - 1);
    }

    public static String reverseString(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i += 2 * k) {

            int end = Math.min(i + k, s.length());

            String reversedPart = new StringBuilder(sb.substring(i, end)).reverse().toString();

            sb.replace(i, end, reversedPart);
        }

        return sb.toString();
    }

    public static String ReverseString1(String s) {
        char[] str = s.toCharArray();

        int start = 0;

        for (int end = 0; end <= str.length; end++) {
            if (end == str.length || str[end] == ' ') {
                int left = start;
                int right = end - 1;

                while (left < right) {
                    char temp = str[left];
                    str[left] = str[right];
                    str[right] = temp;
                    left++;
                    right--;

                }
                start = end + 1;
            }
        }
        return new String(str);

    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;

        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);

    }

    public static void reverse(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int minimumRecolor(String blocks,int k){
        int n = blocks.length();

        int white = 0;
        for(int i = 0;i<k;i++){
            if(blocks.charAt(i) == 'W'){
                white++;
            }
        }
        int ans = white;

        for(int i = k;i<n;i++){
            if(blocks.charAt(i-k) == 'W'){
                white--;
            }
            if(blocks.charAt(i) == 'W'){
                white++;
            }
          ans = Math.min(ans,white);
        }
        return ans;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
      int k = 7;
     System.out.println(minimumRecolor(blocks, k)); 




    }
}
