import java.util.Arrays;

public class Test {
    public static void findMinMax(int[] arr) { // Q1
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
        }
        System.out.println(smallest);
        System.out.println(largest);

    }

    public static void reveseArrayInPlace(int[] arr) { // Q2
        int first = 0;
        int last = arr.length - 1;
        while (first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void findKthMaxMin(int[] arr, int k) { // Q3
        int size = arr.length;
        Arrays.sort(arr);
        int kthsmallest = arr[k - 1];
        int kthlargest = arr[arr.length - k];
        System.out.println(kthsmallest);
        System.out.println(kthlargest);

    }

    public static void dutchNationalFlag(int[] arr) { // Q4
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
            System.out.println(arr[i]);
        }
    }

    public static void moveNegativeAtbeignning(int[] arr) { // Q5
        int n = arr.length;
        int[] newarr = new int[n];
        Arrays.sort(arr);
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                newarr[index++] = arr[i];

            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= 0) {
                newarr[index++] = arr[i];
            }

        }
        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i] + " ");
        }
    }

    public static void findUnionNIntersection(int[] arr1, int[] arr2) { // Q6
        System.out.println("Intersection elements ");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    System.out.print(arr1[i] + " ");
                }
            }
        }
        System.out.println();

        int max = 0;
        for (int val : arr1)
            max = Math.max(max, val);
        for (int val : arr2)
            max = Math.max(max, val);

        boolean[] found = new boolean[max + 1];
        System.out.println("union elements");

        for (int i = 0; i < arr1.length; i++) {
            if (!found[arr1[i]]) {
                System.out.println(arr1[i]);
                found[arr1[i]] = true;
            }

            for (int j = 0; j < arr2.length; j++) {
                if (!found[arr2[j]]) {
                    System.out.println(arr2[j]);
                    found[arr2[j]] = true;
                }
            }

        }

    }

    public static void cyclicallyRotate(int[] arr) { // Q7
        int n = arr.length;
        int last = arr[n - 1];

        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void KandansAlogrithm(int[] arr) { // Q8
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        System.out.println(maxSum);
       
    }

    

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 7 };
       KandansAlogrithm(arr);
    }

}
