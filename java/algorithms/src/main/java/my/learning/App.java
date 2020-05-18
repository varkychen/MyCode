package my.learning;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final int p = sc.nextInt();

            Pair[] pairs = new Pair[p];

            for (int i = 0; i < p; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                pairs[i] = new Pair(a, b);
            }

            System.out.println("Number of pairs : " + pairs.length);
        }
    }
}

class Pair {
    int one;
    int two;

    Pair(int one, int two) {
        this.one = one;
        this.two = two;
    }
}