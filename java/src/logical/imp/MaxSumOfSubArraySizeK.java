package logical.arrays.imp;

import java.util.*;
import java.util.stream.Collectors;

/*
* Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions
* */
public class MaxSumOfSubArraySizeK {

    public static int maxSumWithouDuplicates(int ar[], int k){
        if(ar.length < k)
            return 0;
        System.out.print("ar => "+Arrays.toString(ar)+", k="+k+", maxSum =>> ");
        Set<Integer> sets = new LinkedHashSet();
        for(int data : ar){
            sets.add(data);
        }
        List<Integer> uniques = new ArrayList<>(sets);
        if(ar.length == k && uniques.size() == 1)
            return 0;
        else if(ar.length > k && uniques.size() == 1)
            return uniques.get(0);
        int currentSum = 0;
        for(int i=0; i<k; i++){
            currentSum += uniques.get(i);
        }
        int maxSum = currentSum;
        for(int i=1; i<uniques.size()-k+1; i++){
            currentSum = currentSum - uniques.get(i-1) + uniques.get(i+k-1);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumWithouDuplicates(new int[]{1,2,2},2)); //3
        System.out.println(maxSumWithouDuplicates(new int[]{1,5,4,2,9,9,9},3)); //15
        System.out.println(maxSumWithouDuplicates(new int[]{1,1,1,1,1,1,1},3)); //1
        System.out.println(maxSumWithouDuplicates(new int[]{4,4,4},3)); //0

    }
}
