package Java.problem_solving;

import java.util.Arrays;

public class PlusOne {
    static int[] fun(int n, int[] digits) {
        if (digits[n - 1] == 9) {
            digits[n - 1] = 0;
            if ((n - 1) >= 0) {
                fun(n - 1, digits);
            } else {
                // Create a new array with an extra space for the carry
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = 1; // Set the first element to 1 (carry)
                // Copy the rest of the digits
                System.arraycopy(digits, 0, newDigits, 1, digits.length);
                return newDigits;
            }
        } else {
            digits[n - 1]++;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {4, 3, 9, 9};
        int n = digits.length;
        int[] answer = fun(n, digits);
        System.out.println(Arrays.toString(answer));
    }
}
