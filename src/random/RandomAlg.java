package random;

import java.util.stream.Stream;

public class RandomAlg {

    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11L;
        /*описати 2 у ступені 48 можемо як long m = (long) Math.pow(2, 48),
        але використаю цикл, тому що не зрозуміла по завданню можно цю формулу
        використати чи ні
         */
        long m = 1L;
        int exponent = 48;
        for (int i = 0; i < exponent; i++) {
            m *= 2;
        }

        Stream<Long> randomStream = generateRandomStream(a, c, m, 42L);
        randomStream.limit(10).forEach(System.out::println);
    }

    public static Stream<Long> generateRandomStream(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
