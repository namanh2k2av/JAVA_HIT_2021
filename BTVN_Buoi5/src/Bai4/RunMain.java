package Bai4;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Sum<Integer> integerSum = new Sum<>(1,2);
        System.out.println("Sum Integer : " + (integerSum.getSoA() + integerSum.getSoB()));

        Sum<Long> longSum = new Sum<>(11L,22L);
        System.out.println("Sum Long : " + (longSum.getSoA() + longSum.getSoB()));

        Sum<Float> floatSum = new Sum<>(1.2f, 3.4f);
        System.out.println("Sum Float : " + (floatSum.getSoA() + floatSum.getSoB()));

        Sum<Double> doubleSum = new Sum<>(1.2, 3.4);
        System.out.println("Sum Double : " + (doubleSum.getSoA() + doubleSum.getSoB()));
    }
}
