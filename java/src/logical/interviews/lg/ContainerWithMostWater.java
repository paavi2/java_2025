package logical.interviews.lg;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.print(maxWater(new int[]{1,2,4,5,6,2})); //8
//        System.out.print(maxWater(new int[]{1,2,5,9,6,2})); //8
//        System.out.print(maxWater(new int[]{1,2,6,0,6,12})); //8
    }

    public static int maxWater(int heights[]){
        System.out.println("Input => "+ Arrays.toString(heights)+", => ");
        int maxArea = 0;
        int index1=0;
        int index2=0;
        int left = 0;
        int right = heights.length-1;;
        while(left<right){ //area  = height & width; width = right - left
            int currentArea = Math.min(heights[left],heights[right]) * (right - left);
            maxArea = Math.max(currentArea,maxArea);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
