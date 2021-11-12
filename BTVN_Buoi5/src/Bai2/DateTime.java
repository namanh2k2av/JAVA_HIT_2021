package Bai2;

import java.util.Scanner;

public class DateTime {
    private int Ngay;
    private int Thang;
    private int Nam;

    public void InputDate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ngay : ");
        Ngay = sc.nextInt();
        System.out.print("Nhap thang : ");
        Thang = sc.nextInt();
        System.out.print("Nhap nam : ");
        Nam = sc.nextInt();
    }

    public void OutputDate(){
        System.out.println(Ngay + "/" + Thang + "/" + Nam);
    }
}
