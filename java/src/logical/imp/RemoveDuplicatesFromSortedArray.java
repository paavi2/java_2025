package logical.arrays.imp;

import java.util.Arrays;

//Two pointers
public class RemoveDuplicatesFromSortedArray {

    //slow pointer & fast pointer
    public static int[] removeDuplicates(int []ar){
        System.out.println("Input => "+Arrays.toString(ar));
        int left = 0;
        int right = 1;
        while(right < ar.length){
            if(ar[left] != ar[right]){
                left = left+1;
                ar[left] = ar[right];
            }
            right++;
        }
        int out[] = Arrays.copyOf(ar,left);
        System.out.println("Output => "+ Arrays.toString(out));
        return ar;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,2,3,3,3,4,4,4,5});
//        removeDuplicates(new int[]{0,1,1,1,2,2,3,5});
    }
}
