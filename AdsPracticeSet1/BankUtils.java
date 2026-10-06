public class BankUtils {
    static int countDigits(long n) {
        if (n == 0) return 0;
        return 1 + countDigits(n / 10);
    }

    static int sumDigits(long n) {
        if (n == 0) return 0;
        return (int)(n % 10) + sumDigits(n / 10);
    }

    static int digitalRoot(long n) {
        int sum = sumDigits(n);
        if (sum < 10) return sum;
        return digitalRoot(sum);
    }

    static String mask(String acc) {
        if (acc.length() <= 4) return acc;
        return "X" + mask(acc.substring(1));
    }

    static double amount(double p, double r, int years) {
        if (years == 0) return p;
        return amount(p, r, years - 1) * (1 + r / 100.0);
    }

    public static void main(String[] args) {
        System.out.println("Digits: " + countDigits(98765));
        System.out.println("Sum of Digits: " + sumDigits(98765));
        System.out.println("Masked Account: " + mask("1234567890"));
    }
}
