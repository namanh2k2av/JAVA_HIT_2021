package Bai1;

import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so thu 1: ");
        int a = sc.nextInt();
        System.out.print("Nhap so thu 2: ");
        int b = sc.nextInt();
        System.out.print("Nhap so thu 3: ");
        int c = sc.nextInt();
        System.out.println("So lon nhat trong 3 so la: " + Math.max(Math.max(a,b),c));
    }
}
