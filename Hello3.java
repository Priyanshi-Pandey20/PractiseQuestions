import java.util.*;
public class Hello3 {

    public static int[] twoSum(int[]nums,int target){
        for(int i = 0;i<nums.length-1;i++){
            for(int j = 0;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    } 

    public static boolean containsDuplicates(int[] nums){  // sorting approach
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for(int i = 0;i<nums.length-1;i++){
            for (int j = i+1;j< nums.length;j++){
                if(nums[i] == nums[j]){
                   return true;
                }
            }
        }
      return false;
    }

    public static boolean containsDuplicates1(int[] nums){ // hashet approach 

        HashSet<Integer>set = new HashSet<>();

         for (int i = 0; i < nums.length; i++)
          nums[i] = i;

        for(int num:nums){
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }
        return true;
    }


    public static void moveZeroes(int[] nums){  // optimal
        int nonzero = 0;

        for (int i = 0;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[nonzero];
                nums[nonzero] = nums[i];
                nums[i] = temp;
                 nonzero++;
            }
          
        }
    }

    public static void reverseString(char[] s){
        int start = 0;
        int end = s.length-1;
          
     while(start<end){
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        start++;
        end--;

     }
    }

    public static String reverseWords(String str){
        char[] s = str.toCharArray();
        int start = 0;

        for(int i = 0;i<=s.length;i++){
            if(i == s.length || s[i] == ' '){
                reversePart(s,start,i-1);
                start = i+1;

            }
        }
        return new String(s);
    }

    public static void reversePart(char[] s,int start,int end){
        while(start<end){
             char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        start++;
        end--;
        }
    }

    public static void mergeTwoSortedArray(int[] num1,int m,int[] num2,int n){  //brute force 
         m = num1.length;
         n = num2.length;

         for(int j = 0, i = m;j<n;j++){
            num1[i] = num2[j];
            i++;
         }
         Arrays.sort(num1);

    }

    public static int[] mergeTwoSortedArray1(int[] num1,int[] num2){
      int m = 3;
       int n = 3;
        int i = m-1;
        int k = m+n-1;
        int j = n-1;
        while(j>=0){
            if(i>=0 && num1[i] > num2[j]){
                num1[k] = num1[i];
                k--;
                i--;
            }
            else{
                num1[k] = num2[j];
                k--;j--;
            }
        }
        return num1;

    
    }




    public static void main(String[]args){
    int[] nums = {0,1,0,3,12};
    // int target = 5;
    // int[] result= twoSum(nums, target);  
    // System.out.println(Arrays.toString(result));
   
    //  boolean hasduplicates = containsDuplicates1(nums);
    //  System.out.println(hasduplicates);
    moveZeroes(nums);

    for(int num :nums){
        System.out.println(num);
    }

    char[] s = {'h','e','l','l','o'};
    reverseString(s);
    for (char c : s) {
    System.out.print(c);  // olleh
}

String str = "Let's take Leetcode contest";
 String res = reverseWords(str);
 System.out.println(res);

 int[] num1 = {1,2,3,0,0,0};
 int[] num2 = {2,5,6};

 int[] result = mergeTwoSortedArray1(num1, num2);

 System.out.println(Arrays.toString(result));  


     

    }
}
