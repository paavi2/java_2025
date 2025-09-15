package logical.interviews.jiostar;
//Input:
//{"matrix":[[1,4,7,11],[2,5,8,12],[3,6,9,16],[10,13,14,17]],"target":5}
//Output: true
public class FindTargetIn2DArray {

    public static void main(String[] args) {
        int ar[][] = {{1,4,7,11},{2,5,8,12},{3,6,9,16},{10,13,14,17}};
        int target = 5;
        for(int i=0; i<ar.length; i++){
            for(int j=0; j<ar[i].length; j++){
                if(ar[i][j] == target)
                    System.out.println(String.format("Target found, i=%d,j=%d ",i,j));

            }
        }
    }
}
