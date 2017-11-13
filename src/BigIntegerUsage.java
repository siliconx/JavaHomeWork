import java.math.BigInteger;

public class BigIntegerUsage {
    public static void main(String[] args) {
        BigInteger integer = BigInteger.valueOf(1);
        BigInteger one = BigInteger.valueOf(1);
        BigInteger two = BigInteger.valueOf(2);
        for (int i = 1; i <= 100; ++i) {
            integer = integer.multiply(two.pow(i).add(one));
        }

        System.out.println(integer);
    }
}
