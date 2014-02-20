import java.util.Date;

public class FibTester {

    public static void main (String[] args) {
        FibTester t = new FibTester();
        System.out.println("Tester initialized");
        long it_times = t.test_iterative();
        System.out.println("it test done...");
        long re_times = t.test_recursive();
        System.out.println("it test done...");
        System.out.println("Iterative fib test took " + it_times + " ms");
        System.out.println("Recursive fib test took " + re_times + " ms");
        //sysln the averages for each group.
    }

    public long test_iterative () {
        IterativeFib f = new IterativeFib();
        Date start = new Date();
        f.fib(10);
        f.fib(25);
        f.fib(44);
        Date done = new Date();
        return done.getTime() - start.getTime();
    }

    public long test_recursive () {  
        RecursiveFib f = new RecursiveFib();
        Date start = new Date();
        f.fib(10);
        f.fib(25);
        f.fib(44);
        Date done = new Date();
        return done.getTime() - start.getTime();
    }

}
