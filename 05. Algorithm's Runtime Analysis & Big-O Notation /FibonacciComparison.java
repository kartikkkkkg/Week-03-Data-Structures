public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30;
        long start = System.nanoTime();
        fibonacciRecursive(n);
        System.out.println("Recursive Fibonacci Time: " + (System.nanoTime() - start));
        start = System.nanoTime();
        fibonacciIterative(n);
        System.out.println("Iterative Fibonacci Time: " + (System.nanoTime() - start));
    }
}