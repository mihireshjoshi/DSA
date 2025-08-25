package Java.problem_solving;


public class DiagonalTraversal {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Input Matrix");
        for(int i = 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Output");
        DiagonalTraversal obj = new DiagonalTraversal();
        int[] ret = obj.findDiagonalOrder(mat);
        for(int ele : ret){
            System.out.print(ele + " ");
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int[] ret = new int[mat.length*mat[0].length];
        boolean up = true;
        int i = 0, j = 0, k = 0;
        while(k < mat.length*mat[0].length){
            ret[k++] = mat[i][j];
            if(up){
                if(j == mat[0].length - 1){
                    i++;
                    up = false;
                } else if(i == 0){
                    j++;
                    up = false;
                } else{
                    i--;
                    j++;
                }
            } else{
                if(i == mat.length - 1){
                    j++;
                    up = true;
                } else if(j == 0){
                    i++;
                    up = true;
                } else{
                    i++;
                    j--;
                }
            }
        }

        return ret;
    }
}