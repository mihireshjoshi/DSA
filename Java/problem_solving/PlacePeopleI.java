package Java.problem_solving;


// 3025. Find the Number of Ways to Place People I

//You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].
//
//        Count the number of pairs of points (A, B), where
//
//        A is on the upper left side of B, and
//        there are no other points in the rectangle (or line) they make (including the border).
//        Return the count.



import java.util.Arrays;

public class PlacePeopleI {

    public static void main(String[] args) {
        PlacePeopleI obj = new PlacePeopleI();

        int[][] points = {{6, 2},{4, 4},{2, 6}};
        System.out.println(obj.numberOfPairs(points));

        int[][] points2 = {{3, 1}, {1, 3}, {1, 1}};
        System.out.println(obj.numberOfPairs(points2));
    }

    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        int count = 0;
        for(int i = 0; i < points.length - 1; i++){
            int prev = Integer.MAX_VALUE;
            for(int j = i + 1; j < points.length; j++){
                if(points[i][1] <= points[j][1] && prev > points[j][1]){
                    count++;
                    prev = points[j][1];
                }
            }
        }
        return count;
    }
}
