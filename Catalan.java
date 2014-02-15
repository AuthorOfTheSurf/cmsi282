import java.math.BigInteger;

public class Catalan {

    public static void main (String[] args) {
        Catalan c = new Catalan();
        if (args.length == 1) {
            System.out.println(c.catalan(Integer.parseInt(args[0])));
        }
        else {
            
            System.out.println("Factorials [4]");
            System.out.println("Factorials [4]");
            System.out.println(c.factorial(1));
            System.out.println(c.factorial(3));
            System.out.println(c.factorial(5));
            System.out.println(c.factorial(6));
            System.out.println("Catalan [4]");
            System.out.println(c.catalan(0));
            System.out.println(c.catalan(1));
            System.out.println(c.catalan(2));
            System.out.println(c.catalan(3));
            System.out.println(c.catalan(4));
            System.out.println(c.catalan(5));
            System.out.println(c.catalan(8));
            System.out.println(c.catalan(15));
            System.out.println(c.catalan(100));
        }
    }

    private BigInteger catalan (int i) {
        return factorial(2 * i).divide((factorial(i + 1).multiply(factorial(i))));
    }

    private BigInteger factorial (int i) {
        BigInteger n = BigInteger.valueOf(i);
        if (i == 0) {
            return new BigInteger("1");
        }
        while (--i > 0) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        return n;
    }

}