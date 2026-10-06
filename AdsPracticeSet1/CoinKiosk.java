public class CoinKiosk {
    static void printWays(int amount, String coinsSoFar) {
        if (amount == 0) {
            System.out.println(coinsSoFar);
            return;
        }
        if (amount >= 1) printWays(amount - 1, coinsSoFar + "1");
        if (amount >= 2) printWays(amount - 2, coinsSoFar + "2");
    }

    static long countWays(int amount) {
        if (amount == 0 || amount == 1) return 1;
        return countWays(amount - 1) + countWays(amount - 2);
    }

    public static void main(String[] args) {
        System.out.println("Ways to make amount 3:");
        printWays(3, "");
        System.out.println("Total ways count: " + countWays(3));
    }
}