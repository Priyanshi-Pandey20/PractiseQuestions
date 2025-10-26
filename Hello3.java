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

    public static void main(String[]args){
    int[] nums = {1,2,3,1};
    int target = 5;
    int[] result= twoSum(nums, target);  
    System.out.println(Arrays.toString(result));
    }
}
