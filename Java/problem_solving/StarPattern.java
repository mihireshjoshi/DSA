package Java.problem_solving;

import java.util.Scanner;

public class StarPattern {
    // Pattern 1
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter number of rows of upper half");
        int n = sc.nextInt();
        for (int i = 1; i <= n ; i++){
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            for (int k = 1; k <= (n*2 - i*2); k++){
                System.out.print(" ");
            }
            for (int l = 0; l < i; l++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
        for (int m = n; m >= 1 ; m--){
            for (int j = 0; j < m; j++){
                System.out.print("*");
            }
            for (int k = 1; k <= (n*2 - m*2); k++){
                System.out.print(" ");
            }
            for (int l = 0; l < m; l++){
                System.out.print("*");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}

// Pattern 1:
// *      * 
// **    ** 
// ***  *** 
// ******** 
// ******** 
// ***  *** 
// **    ** 
// *      * 