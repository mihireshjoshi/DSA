package Java.problem_solving;


import java.util.*;

public class MinRemovalOps {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 3, 4, 7};
        System.out.println(sol.minOperation(arr, 1));
    }
}

class Solution {
    public static int minOperation(int[] arr, int k) {
        int steps = 0;
        Map<Integer, List<Integer>> diff = new TreeMap<>();
        int sum = 0;


        for (int num : arr) {
            sum += num;
        }
        sum = sum / arr.length;

        for (int i = 0; i < arr.length; i++) {
            int diffValue = Math.abs(sum - arr[i]);
            diff.putIfAbsent(diffValue, new ArrayList<>());
            diff.get(diffValue).add(i);
        }

        while (k > 0 && !diff.isEmpty()) {
            int key = ((TreeMap<Integer, List<Integer>>) diff).lastKey();
            List<Integer> indices = diff.get(key);

            while (!indices.isEmpty() && k > 0) {
                indices.remove(indices.size() - 1);
                k--;
            }

            if (indices.isEmpty()) {
                diff.remove(key);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (List<Integer> indexList : diff.values()) {
            pq.addAll(indexList);
        }

        while(!pq.isEmpty()){
            steps++;
            int div = pq.peek()/2;
            pq.removeIf(num->num>=div);
        }

        return steps;

    }
}
