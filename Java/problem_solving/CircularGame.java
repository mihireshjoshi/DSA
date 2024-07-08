// 1823. Find the Winner of the Circular Game
// There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
// The rules of the game are as follows:

// Start at the 1st friend.
// Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
// The last friend you counted leaves the circle and loses the game.
// If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
// Else, the last friend in the circle wins the game.
// Given the number of friends, n, and an integer k, return the winner of the game.


package Java.problem_solving;

import java.util.*;
class CircularGame {
    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        List<Integer> l = new ArrayList<Integer>();
        for(int i =1; i<=n; i++){
            l.add(i);
        }
        int j = 0;
        int cn = 1;
        while(l.size()!=1){
            if(cn==k){
                l.remove(j);
                if (j==l.size()-1){
                    cn = 2;
                    j = 0;
                    System.out.println("A J is " + j + " cn is " + cn + " and list is " + l.toString());
                    continue;
                }
                else if(j>l.size()-1){
                    cn = 1;
                    j = 0;
                }
                else{
                    cn = 1;
                    System.out.println("B J is " + j + " cn is " + cn + " and list is " + l.toString());
                }
            }
            else{
                cn++;
                if (j>=l.size()-1){
                    j = 0;
                    System.out.println("C J is " + j + " cn is " + cn + " and list is " + l.toString());
                }
                else{
                    j++;
                    System.out.println("D J is " + j + " cn is " + cn + " and list is " + l.toString());
                }
            }
        }
        System.out.println(l.toString());
    }
}