package logical.arrays.imp;

import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicatesInArray {

    //Without using inbuilt data structures
    public static void findDuplicates(int ar[]){
        System.out.println("Input => "+ Arrays.toString(ar));
        int left = 0;
        int right = 1;
        while(right < ar.length){
           if(ar[left] == ar[right]){
               System.out.println("Output => "+ar[left]+",");
           }
            left++;
            right++;
        }

    }

    //With Collection
    public static void findDuplicatesUsingCollection(int ar[]){
        HashSet<Integer> unique = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for(int ele: ar){
            boolean isUnique = unique.add(ele);
            if(!isUnique){
                duplicates.add(ele);
            }
        }
        System.out.println("Duplicates using collection => "+duplicates);
    }

    public static void main(String[] args) {
        findDuplicates(new int[]{0,1,1,1,2,2,3,5,5});
        findDuplicatesUsingCollection(new int[]{0,1,1,1,2,2,3,5,5});
    }
}
