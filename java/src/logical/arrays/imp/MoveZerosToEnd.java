package logical.arrays.imp;

import java.util.Arrays;

public class MoveZerosToEnd {

    public static void moveZerosToEnd(int ar[]){
        System.out.println("Input => "+ Arrays.toString(ar));
        int left = 0;
        // Move all non-zero elements forward
//        for (int num : ar) {
//            if (num != 0) {
//                ar[left] = num;
//                left++;
//            }
//        }

        int right = 0;
        while(right < ar.length){
            if(ar[right] != 0){
                ar[left] = ar[right];
                left++;
            }
            right++;
        }
        // Fill remaining positions with 0
        while (left < ar.length) {
            ar[left++] = 0;
        }
        System.out.println("Output => "+ Arrays.toString(ar));
    }

    public static void main(String[] args) {
        moveZerosToEnd(new int[]{0, 1, 0, 3, 12});
        moveZerosToEnd(new int[]{5, 6, 7, 0, 0, 0});
        moveZerosToEnd(new int[]{0, 5, 0, 6, 0, 7});
        moveZerosToEnd(new int[]{0, 0, 1, 2, 3});
    }
}
