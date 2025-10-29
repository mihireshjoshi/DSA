package Java.problem_solving;

public class MinimumCostStringMatch {

    public int minimumCost(String s, String t) {
        int t_len = t.length();
        int s_len = s.length();
        if(t_len == 0 || s_len == 0 || t_len > s_len) return -1;

        int ret = 0;
        int i = t_len - 1, j = s_len - 1;
        while(i >= 0) {
            while(j >= 0 && t.charAt(i) != s.charAt(j)) {
                System.out.println( "i: " + i + " j: " + j + " s: " + s.charAt(j) + " t: " + t.charAt(i));
                ret += j + 1;
                j--;
            }
            if(j == -1) return -1;
            System.out.println( "i: " + i + " j: " + j + " s: " + s.charAt(j) + " t: " + t.charAt(i));
            i--;
            j--;
        }
        return ret;
    }

    public static void main(String args[]) {
        MinimumCostStringMatch minimumCostStringMatch = new MinimumCostStringMatch();
        System.out.println(minimumCostStringMatch.minimumCost("afghkill", "eb") );
    }

}
