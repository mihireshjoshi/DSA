package Java.problem_solving;

// Initial Logic solving 37/38 Test Cases: Time Limit Exceed

class RotateArrayInitial {
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5,6,7};
        int k = 3;
        int n = a.length;
        int i, j;
        for (i=0; i<k; i++){
            int b = a[n-1];
            System.out.println(b);
            for (j=n-1; j>0; j--){
                a[j] = a[j-1];
                System.out.print(a[j]);
            }
            System.out.println();
            a[j] = b;
            for (int x = 0; x<n; x++) {
                System.out.print(a[x]);
            }
            System.out.println();
        }
    }
}


// Optimal

class RotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int n = a.length;

        // Normalize k if it's greater than the length of the array
        k = k % n;

        // Rotate the array by reversing parts of it
        reverse(a, 0, n - 1);
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);

        // Print the rotated array
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}