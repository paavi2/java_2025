package logical.interviews.jiostar;

import java.util.Arrays;

//Arrays.copy -> shouldn't be used
// input -> [0,1,2,0,3,0,12] -> [1,2,3,12,0,0,0]
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int ar[] = new int[]{0,1,2,0,3,0,12};
        int out[] = new int[ar.length];
        int count = 0;
        for(int i=0; i<ar.length; i++){
            if(ar[i] != 0)
                out[count++] = ar[i];
        }
        System.out.println("Input => "+ Arrays.toString(ar));
        System.out.println("Output => "+ Arrays.toString(out));
    }
}
