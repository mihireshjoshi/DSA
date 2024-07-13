// 2751. Robot Collisions:

// There are n 1-indexed robots, each having a position on a line, health, and movement direction.
// You are given 0-indexed integer arrays positions, healths, and a string directions (directions[i] is either 'L' for left or 'R' for right). All integers in positions are unique.
// All robots start moving on the line simultaneously at the same speed in their given directions. If two robots ever share the same position while moving, they will collide.
// If two robots collide, the robot with lower health is removed from the line, and the health of the other robot decreases by one. The surviving robot continues in the same direction it was going. If both robots have the same health, they are both removed from the line.
// Your task is to determine the health of the robots that survive the collisions, in the same order that the robots were given, i.e. final heath of robot 1 (if survived), final health of robot 2 (if survived), and so on. If there are no survivors, return an empty array.
// Return an array containing the health of the remaining robots (in the order they were given in the input), after no further collisions can occur.
// Note: The positions may be unsorted

// Input: positions = [5,4,3,2,1], healths = [2,17,9,15,10], directions = "RRRRR"
// Output: [2,17,9,15,10]
// Explanation: No collision occurs in this example, since all robots are moving in the same direction. So, the health of the robots in order from the first robot is returned, [2, 17, 9, 15, 10].

// link: https://leetcode.com/problems/robot-collisions/

package Java.problem_solving;

import java.util.*;

public class RobotCollision {
    class Robot {
        int position;
        int health;
        char direction;
        int index;
        
        Robot(int position, int health, char direction, int index){
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robo = new ArrayList<>();
        int n = positions.length;
        for (int i=0; i<n; i++){
            robo.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        robo.sort((a, b) -> a.position - b.position);
        
        List<Robot> stk = new ArrayList<>();
        
        for(Robot ele : robo){
            if(ele.direction == 'R'){
                stk.add(ele);
                continue;
            }
            boolean g = false;
            
            while(!stk.isEmpty() && stk.get(stk.size() - 1).health <= ele.health && stk.get(stk.size() - 1).direction == 'R'){
                if(stk.get(stk.size() - 1).health == ele.health){
                    stk.remove(stk.size() - 1);
                    g = true;
                    break;
                }
                ele.health --;
                stk.remove(stk.size() - 1);
            }
            
            if (!g && !stk.isEmpty() && stk.get(stk.size() - 1).health > ele.health && stk.get(stk.size() - 1).direction == 'R') {
                stk.get(stk.size() - 1).health --;
                g = true;
            }
            
            if(!g){
                stk.add(ele);
            }
        }
        
        stk.sort((a, b) -> a.index - b.index);
        List<Integer> ret = new ArrayList<>();
        for(Robot rete : stk){
            ret.add(rete.health);
        }
        return ret;
    }
}