public class Hello {

    public static void FindMaxAndMin(int[] arr) { // find max and min elements in array
       
        int max =arr[0];
        int min =arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            else if(min>arr[i]){
                min = arr[i];
            }
          
        }
        System.out.println(min);
        System.out.println(max);
    }
    

    public static void main(String[] args) {
        int[] arr = { 0, 2, 3, 4, 75, 6 };
        FindMaxAndMin(arr);
    }
}