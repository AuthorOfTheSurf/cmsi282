public class IterativeFib {

    public static void main (String[] args) {
        IterativeFib f = new IterativeFib();
        System.out.println(f.fib(Integer.parseInt(args[0])));
    }

    public int fib (int n) {
        int a = 0;
        int b = 1;
        int result = 0;
        
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) {
                result = a;
            }
            else if (i == 1) {
                result = b;
            }
            else if (i % 2 == 0) {
                result = a + b;
                a = result;
            }
            else {
                result = a + b;
                b = result;
            }
        }
        return result;
    }

}
