package Java.problem_solving;

import java.util.Scanner;

public class StarPattern {
    // Pattern 1
    // public static void main(String[] args) {
    //     Scanner sc =  new Scanner(System.in);
    //     System.out.println("Enter number of rows of upper half");
    //     int n = sc.nextInt();
    //     for (int i = 1; i <= n ; i++){
    //         for (int j = 0; j < i; j++){
    //             System.out.print("*");
    //         }
    //         for (int k = 1; k <= (n*2 - i*2); k++){
    //             System.out.print(" ");
    //         }
    //         for (int l = 0; l < i; l++){
    //             System.out.print("*");
    //         }
    //         System.out.println(" ");
    //     }
    //     for (int m = n; m >= 1 ; m--){
    //         for (int j = 0; j < m; j++){
    //             System.out.print("*");
    //         }
    //         for (int k = 1; k <= (n*2 - m*2); k++){
    //             System.out.print(" ");
    //         }
    //         for (int l = 0; l < m; l++){
    //             System.out.print("*");
    //         }
    //         System.out.println(" ");
    //     }
    //     sc.close();
    // }

    // Pattern 2
    // public static void main(String[] args) {
    //     int n = 5;
    //     for (int i = n; i>=1; i--){
    //         for(int j = 0; j<i; j++){
    //             System.out.print(" ");
    //         }
    //         for(int k = 0; k < n; k++){
    //             System.out.print("*");
    //         }
    //         System.out.println("");
    //     }
    // }

    // Pattern 3
    // public static void main(String[] args) {
    //     int n = 5;
    //     for (int i = 1; i<=n; i++){
    //         for(int j = 1; j<n-i; j++){
    //             System.out.print(" ");
    //         }
    //         for(int k = 0; k < i; k++){
    //             System.out.print(i + " ");
    //         }
    //         System.out.println("");
    //     }
    // }

    // Pattern 4
    // public static void main(String[] args) {
    //     int n = 5;
    //     for (int i = 1; i<=n; i++){
    //         for(int j = 0; j<n-i; j++){
    //             System.out.print(" ");
    //         }
    //         for(int k = i; k > 0; k--){
    //             System.out.print(k);
    //         }
    //         for(int m = 2; m <= i; m++){
    //             System.out.print(m);
    //         }
    //         System.out.println("");
    //     }
    // }
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

// Pattern 2:
//     *****
//    *****
//   *****
//  *****
// *****

// Pattern 3:
//     1 
//    2 2 
//   3 3 3 
//  4 4 4 4 
// 5 5 5 5 5 

// Pattern 4:
//     1
//    212
//   32123
//  4321234
// 543212345