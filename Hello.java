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

    public static void main(String[] args) {
        int[] arr = { 0, 2, 3, 4, 75, 6 };
        // reverseArray(arr);
        // for(int i =0;i<arr.length;i++){
        // System.out.println(arr[i]);
        // }
        SortArray(arr);

    }
}