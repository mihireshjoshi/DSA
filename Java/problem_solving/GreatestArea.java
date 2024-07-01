package Java.problem_solving;

// Time Limit Exceed Problem with Bute Force
class GreatestAreaBasic {
    public static int main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int n = height.length;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j = i; j<n; j++) {
                int a = Math.min(height[i],height[j]) * (j-i);
                if (a>max) {
                    max = a;
                    System.out.println("For i: " + i + " and j: " + j);
                }
            }
        }
        System.out.print(max);
        return max;
    }
}

// Optimal as single loop required to iterate both pointers
class GreatestArea {
    public static int main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        int n = height.length;
        int max = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            int a = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(a, max);
            
            if(height[left] < height[right]) {
                left ++;
            }
            else {
                right --;
            }
        }
        return max;
    }
}