package Java.problem_solving;

class LeftRotateArray {
    public static void main(String[] args) {

        // The Array to be Rotated
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // The number of rotations to be performed
        int d = 3;

        // Consider Actual Displacement by Removing complete cycles
        d = d % arr.length;

        // Define a temp array of the length of remaining number of rotations
        int[] temp = new int [d];

        // Copy the first(as Left Rotation) d elements to be rotated
        for (int i = 0; i < d; i ++){
            temp[i] = arr[i];
        }

        int j = 0;

        // Shift the last (Array Length - d) elements to the start of the array
        for (int i = d; i < arr.length; i++) {
            arr[j] = arr[i];
            j ++;
        }

        // Attach the first d elements to the end of the Array
        for (int i = 0; i < d; i++) {
            arr[j] = temp[i];
            j ++;
        }
    }
}