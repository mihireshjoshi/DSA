package Java.problem_solving;

import java.util.HashMap;

public class LongestSubsequentString {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) {
            return s.length();
        }

        if(s.length() == 2) {
            if(s.charAt(0) == s.charAt(1)) {
                return 1;
            } else {
                return 2;
            }
        }

        int i = 0, j = 1, maxRet = 0;
        HashMap<Character, Integer> chars = new HashMap<>();

        while(j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                chars.put(s.charAt(j), j);
                maxRet = Math.max(maxRet, j - i);
                i++;
                j++;
            } 
            else if(chars.containsKey(s.charAt(j))){
                i = chars.get(s.charAt(j));
                final int threshold = i;
                chars.entrySet().removeIf(entry -> entry.getValue() < threshold);
            }
            else{
                chars.put(s.charAt(j), j);
                maxRet = Math.max(maxRet, j - i + 1);
                j++;
            }
        }

        return maxRet;

    }

    public static void main(String[] args) {
        String input = "abcabcbb";

        LongestSubsequentString longestSubsequentString = new LongestSubsequentString();
        int response = longestSubsequentString.lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + response);
    }
}

