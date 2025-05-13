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

    public static void SortArray(int[] arr) { // sort in 0s 1s 2s in array
        int size = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
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


    public static void main(String[] args) {
        int[] height = { 2, 1, 5, 4, 7, 4 };
        System.out.println(TrappingRainWater(height));
    }
}