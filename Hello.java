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
        int count = 0;
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
                System.out.println("Target " + target);
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
        int[] arr2 = { 1, 2, 3, 6, 7 };
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
                System.out.println(curr + "is leader in an array");
            }
        }
    }

    public static void CyclicallyRoatateArray(int[] arr) { // Cyclically rotate an array by one
        int n = arr.length;
        int last = arr[arr.length - 1];

        for (int i = n- 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
       

    }


    public static void main(String[] args) {
        int[] arr = { 1, 2,3,4,5 };
       
        CyclicallyRoatateArray(arr);
         for(int i = 0;i<arr.length;i++){
            System.out.println(  arr[i] + " ");
        }
    }
}