package Java.problem_solving;

public class TrappingRainWater {

    public int trap(int[] hs, boolean flag) {
        int n = hs.length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] f = new int[n];

        int mx = 0;
        for(int i = n-1; i >= 0; i--){
            mx = Math.max(mx, hs[i]);
            r[i] = mx;
        }

        mx = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            mx = Math.max(mx, hs[i]);
            l[i] = mx;
            f[i] = Math.abs(hs[i] - Math.min(l[i], r[i]));
            sum += f[i];
        }

        mx = 0;
        int mx_b = 0;
        for(int i = 0; i < n; i++){
            if(f[i] != 0){
                mx += f[i];
            } else{
                mx_b = Math.max(mx_b, mx);
                mx = 0;
            }
        }

        return flag ? mx_b : sum;
    }

    public static void main(String[] args) {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int response = trappingRainWater.trap(input, false);
        System.out.println("Total water trapped is: " + response);

        response = trappingRainWater.trap(input, true);
        System.out.println("Maximum accumulated water is: " + response);
    }

}
