/**
 * LeetCode 853: Car Fleet
 * 
 * Problem Description:
 * There are n cars going to the same destination along a one-lane road. The destination is target miles away.
 * You are given two integer arrays position and speed, both of length n, where position[i] is the position 
 * (in miles) of the ith car and speed[i] is the speed (in miles per hour) of the ith car.
 * 
 * A car can never pass another car ahead of it, but it can catch up to it and drive together at the speed 
 * of the slower car. When two cars meet, they form a car fleet. Note that a single car is also a car fleet.
 * 
 * Return the number of car fleets that will arrive at the destination.
 * 
 * Approach:
 * 1. Combine position and speed into pairs and sort by position in descending order (closest to target first)
 * 2. Calculate the time each car needs to reach the target: time = (target - position) / speed
 * 3. Use a stack to track fleets. A new fleet is formed when:
 *    - A car takes longer to reach the target than the car ahead of it (slower car catches up)
 *    - If a car reaches faster or at the same time, it joins the existing fleet
 * 4. The number of fleets equals the size of the stack
 * 
 * Time Complexity: O(n log n) - due to sorting
 * Space Complexity: O(n) - for the stack and pairs array
 */
import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> ms = new Stack<>();
        int[][] ps = new int[position.length][2];
        for(int i = 0; i < position.length; i++){
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        Arrays.sort(ps, (a, b) -> Integer.compare(b[0], a[0]));

        for(int[] p: ps){            
            float t = (float)(target - p[0]) / p[1];
            if(!ms.isEmpty() && ms.peek() < t){
                ms.push(t);
            } else if(ms.isEmpty()) {
                ms.push(t);
            }
        }
        return ms.size();

    }
    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        CarFleet cf = new CarFleet();
        int result = cf.carFleet(target, position, speed);
        System.out.println(result);
    }
}
