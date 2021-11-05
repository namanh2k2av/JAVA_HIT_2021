package Bai2;

import java.util.Scanner;

public class Date {
    private int D;
    private int M;
    private int Y;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay : ");
        D = sc.nextInt();
        System.out.print("Nhap thang : ");
        M = sc.nextInt();
        System.out.print("Nhap nam : ");
        Y = sc.nextInt();
    }

    public String Xuat(){
        return D + "/" + M + "/" + Y;
    }
}
