public class RecursiveFib {

    public static void main (String[] args) {
        RecursiveFib r = new RecursiveFib();
        System.out.println(r.fib(Integer.parseInt(args[0])));
    }

    public int fib (int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (n > 1) {
            return fib(n-1) + fib(n-2);
        }
        else {
            throw new IllegalArgumentException("Positive ints only");
        }
    }

}
