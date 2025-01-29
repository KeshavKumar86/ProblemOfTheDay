package year2025.january;

public class ImplementPow {
    public static void main(String[] args) {

        double b = 3;
        int e = 5;
        double result = power(b, e);
        System.out.println("Result: " + result);

    }

    static double power(double b, int e) {
        double result = 1.0;
        int n = e;
        n = n > 0 ? n : -n;
        while (n > 0) {
            if (n % 2 == 0) {
                n = n / 2;
                b = b * b;
            } else {
                result = result * b;
                n--;
            }
        }
        if (e < 0) {
            return 1.0 / result;
        }
        //result = new BigDecimal(result).setScale(5, RoundingMode.HALF_UP).doubleValue();
        return result;
    }
}
/*
Solution1: Brute Force Solution
Multiply the base with itself as many times as e.
Time Complexity: O(n)
Space Complexity: O(1)

Solution2: Optimal Solution
Intuition: when power is even take the square of base and divide the power by 2.
Time Complexity: O(logn)
Space Complexity: O(1)
 */