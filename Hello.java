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

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3, 3, 3 };
        Occurences(nums);

    }
}