package practiseJava;

import java.util.Arrays;
import java.util.Random;

public class UniformRandomNumber {
    static int zeroOneRandom() {
        Random gen = new Random();
        return gen.nextInt(2);
    }

    // @include
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1, result;
        do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
                // zeroOneRandom() is the provided random number generator.
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOutcomes);
        return result + lowerBound;
    }
    // @exclude

    public static void main(String[] args) {
        Random gen = new Random();
        int[] res = new int[6];
        for (int times = 0; times < 1000; ++times) {
            int a = 1, b = 6;
            int x = uniformRandom(a, b);
            res[x-1]++;
//            System.out.println(String.format("a = %d, b = %d", a, b));
            System.out.println(String.format("random result = %d", x));
            assert x >= a && x <= b;
        }
        System.out.println(Arrays.toString(res));
    }
}
