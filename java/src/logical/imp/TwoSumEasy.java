package logical.imp;

import java.util.Arrays;

//Input: nums = [2,7,11,15], target = 9 Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Input: nums = [3,2,4], target = 6 Output: [1,2]
//Input: nums = [3,3], target = 6 Output: [0,1]
public class TwoSumEasy {

    public static int[] findIndices(int ar[], int target){
        System.out.print("Input => "+ Arrays.toString(ar)+", Output =>");
        int left = 0;
        for(int right = left+1; right <ar.length; right++){
            int currentSum = ar[left] + ar[right];
            if(currentSum == target){
                return new int[]{left,right};
            }
            else if(right == ar.length-1 && left < ar.length-1)
            {
                ++left;
                right = 0;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIndices(new int[]{2,7,11,15},9)));//0,1
        System.out.println(Arrays.toString(findIndices(new int[]{8,7,2,15},9)));//1,2
        System.out.println(Arrays.toString(findIndices(new int[]{7,0,7,2},9)));//0,3
        System.out.println(Arrays.toString(findIndices(new int[]{3,0,9,6},6)));//0,3

    }
}
