// 1518. Water Bottles
// There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.
// The operation of drinking a full water bottle turns it into an empty bottle.
// Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.


package Java.problem_solving;
import java.util.Scanner;

class BottleExchange {
    static int numWaterBottles(int numBottles, int numExchange) {
        int n = numBottles;
        int ret = n;
        while(n>=numExchange) {
            ret += n/numExchange;
            n = n/numExchange + n%numExchange;
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Num Bottles");
        int numBottles = sc.nextInt();
        System.out.println("Enter Exchange Rate");
        int numExchange = sc.nextInt();
        int result = numWaterBottles(numBottles, numExchange);
        System.out.println(result);
    }
}