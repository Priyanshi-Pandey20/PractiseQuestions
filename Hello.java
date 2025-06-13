import java.util.*;

public class Hello {

    public static void FindMaxAndMin(int[] arr) { // find max and min elements in array

        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            } else if (min > arr[i]) {
                min = arr[i];
            }

        }
        System.out.println(min);
        System.out.println(max);
    }

    public static void reverseArray(int[] arr) { // reverse an array
        int first = 0, last = arr.length - 1;
        while (first < last) {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;
        }

    }

    public static int TrappingRainWater(int[] height) { // trapping rainwater problem
        Stack<Integer> stack = new Stack<>();
        int n = height.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && (height[stack.peek()] < height[i])) {
                int pop_height = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int min_height = Math.min(height[stack.peek()], height[i]) - pop_height;

                ans += distance * min_height;

            }
            stack.push(i);

        }
        return ans;
    }

    public static void SortArray(int[] arr) { // sort in 0s 1s 2s in array
        int size = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void MergeTwoArray() { // merge two array without using extra space
        int[] s = { 2, 3, 0, 0 };
        int[] p = { 4, 5 };
        int m = 2;
        int n = p.length;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        for (; k >= 0; k--) {
            if (j < 0)
                break;
            if (i >= 0 && s[i] > p[j]) {
                s[k] = s[i];
                i--;
            } else {
                s[k] = p[j];
                j--;
            }
        }
        for (int num : s) {
            System.out.print(num + " ");

        }
    }

    public static void KadanesAlgorithm(int[] nums) { // maximum subarray sum
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = currSum + nums[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        System.out.println("maximum subarray sum : " + maxSum);
    }

    public static void RearrangeArray(int[] arr) { // Move all negative numbers to beginning and positive to end
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int[] temp = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
            System.out.print(arr[i] + " ");
        }
    }

    public static void Occurences(int[] arr) { // Count the number of occurrences of an element
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            boolean alreadyCounted = false;

            for (int k = 0; k < i; k++) {
                if (arr[i] == arr[k]) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted) {
                continue;
            }

            for (int j = i; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println(arr[i] + " ocuured " + count + " times ");
        }
    }

    public static void FindDuplicates(int[] arr) {// find duplicate element in array
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate element is : " + arr[j]);
                    break;
                }
            }

        }
    }

    public static int FindMissingElement(int[] arr) { // find missing element in an array
        if (arr == null || arr.length < 2) {
            return -1;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i] + 1) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    public static void AlternatingPositiveNegative(int[] arr) { // alternating postive negative elements
        int n = arr.length;
        int[] temp = new int[n];
        int postIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                if (postIdx < n) {
                    temp[postIdx] = arr[i];
                    postIdx += 2;
                }
            } else {
                if (negIdx < n) {
                    temp[negIdx] = arr[i];
                    negIdx += 2;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp[i] + " ");
        }

    }

    public static boolean isRoatatedSorted(int[] arr) { // check wheter array is roatated and sorted
        int count = 0; // {5,6,1,2,3,4}
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void FindPairs(int[] arr, int target) { // find all pairs of given sum
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                System.out.println("Pairs found : " + "(" + arr[l] + "," + arr[r] + ")");
                return;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
    }

    public static void FindUnionIntersection() {// find union and intersection of array
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 4, 5, 7 };
        System.out.print("union of array : ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");

                    break;
                }

            }
        }
        System.out.println();
        System.out.print("Intersection of array : ");
        for (int j = 0; j < arr2.length; j++) {
            boolean found = false;
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[j] == arr1[i]) {
                    found = true;
                    break;

                }
            }
            if (!found) {
                System.out.print(arr2[j] + " ");
            }
        }

    }

    public static void LeadersInArray(int[] arr) { // find the leader element in an array
        for (int i = 0; i < arr.length - 1; i++) {
            int curr = arr[i];
            boolean isfound = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (curr < arr[j]) {
                    isfound = false;
                    break;
                }
            }
            if (isfound) {
                System.out.println(curr + " is leader in an array");
            }
        }
    }

    public static void CyclicallyRoatateArray(int[] arr) { // Cyclically rotate an array by one
        int n = arr.length;
        int last = arr[arr.length - 1];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        System.out.print("cyclically roated array : ");

        for (int i = 0; i < n; i++) {
            System.out.print(+arr[i] + " ");
        }

    }

    public static void AllZeroAtFront(int[] arr) { // put all zeroes in front then negative then positive
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int[] temp = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                temp[idx++] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
            System.out.print(arr[i] + " ");
        }

    }

    public static void findKthMaxMin(int[] arr, int k) { // find kth max and min element
        int size = arr.length;
        Arrays.sort(arr);

        int kthsmallest = arr[k - 1];
        int kthlargest = arr[arr.length - k];

        System.out.println("kth min elemnt : " + kthsmallest);
        System.out.println("kth max element : " + kthlargest);

    }

    public static void dutchNationalFlag(int[] arr) { // Dutch National flag problem
        int mid = 0;
        int low = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void ReverseString() {// revere a string
        String str = "coding";
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }

    public static String CompressString(String str) {// count the no. of frequency of a character

        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            Integer count = 1;
            while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if (count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }

    public static void RemoveDuplicates() { // remove duplicates
        String str4 = "happy";
        for (int i = 0; i < str4.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (str4.charAt(i) == str4.charAt(j) && i != j) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                System.out.print(str4.charAt(i) + "");
            }

        }
    }

    public static void isPalindrome(String str) { // check whether a string is palindrome or not
        int n = str.length();
        boolean isPalindrome = true;

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }

        }
        if (isPalindrome) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }

    }

    public static void printAllPermutaions(String str, String ans) { // print all permutation of given string

        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String result = str.substring(0, i) + str.substring(i + 1);

            printAllPermutaions(result, ans + curr);
        }

    }

    public static String longestCommonPrefix(String[] str) { // longest common prefix {"sun", "sunset", "sunshine"}

        if (str == null || str.length == 0) {
            return " ";
        }

        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (!str[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public static String sortString(String str) { // group anagrams
        char[] chars = str.toCharArray();

        Arrays.sort(chars);
        return new String(chars);

    }

    public static List<List<String>> GroupAnagrams(String[] s) {
        List<List<String>> result = new ArrayList<>();
        List<String> keys = new ArrayList<>();

        for (String str : s) {
            String sorted = sortString(str);

            boolean found = false;

            for (int i = 0; i < keys.size(); i++) {
                if (keys.get(i).equals(sorted)) {
                    result.get(i).add(str);
                    found = true;
                    break;
                }
            }

            if (!found) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                result.add(newGroup);
                keys.add(sorted);
            }
        }
        return result;
    }

    public static int subStringSearch(String str1, String str2) { // Substring search
        if (str2.length() == 0) {
            return 0;
        }
        int l1 = str1.length();
        int l2 = str2.length();

        for (int i = 0; i <= l1 - l2; i++) {
            int j;
            for (j = 0; j < l2; j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    break;
                }
            }
            if (j == l2) {
                return i;
            }
        }
        return -1;

    }

    public static boolean checkPalindrome(String str, int left, int right) {// Valid Palindrome after removing at most
                                                                            // one character

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean ValidPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return checkPalindrome(str, left + 1, right) || checkPalindrome(str, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static int stringToInt(String str) { // convert string to integer
        int result = 0;
        int i = 0;
        boolean isNegative = false;

        if (str.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        while (i < str.length()) {
            char ch = str.charAt(i);
            result = result * 10 + (ch - '0');
            i++;
        }
        return isNegative ? -result : result;
    }

    public static boolean isSubstring(String combined, String s2) { // Check if a string is a rotation of another string

        int n = combined.length();
        int m = s2.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && combined.charAt(i + j) == s2.charAt(j)) {
                j++;
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }
        String combined = s1 + s1;

        return isSubstring(combined, s2);
    }

    public static boolean isSubsequence(String s, String t) { // Check if one string is a subsequence of another
        int j = 0;
        for (int i = 0; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) == t.charAt(i))
                j++;
        }
        return (j == s.length()) ? true : false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 0, 1, 2, 1, 0, 0, 1, 2 };
        dutchNationalFlag(arr);
    }
}