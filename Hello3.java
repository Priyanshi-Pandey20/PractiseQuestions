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
     

    }
}
