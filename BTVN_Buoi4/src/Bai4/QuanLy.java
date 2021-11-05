package Bai4;

import java.util.Scanner;

public class QuanLy {
    private String maQl;
    private String hoTen;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma quan ly : ");
        maQl = sc.nextLine();
        System.out.print("Nhap ho ten : ");
        hoTen = sc.nextLine();
    }

    public void Xuat(){
        System.out.println("Ma quan ly : " + maQl);
        System.out.println("Ho ten : " + hoTen);
    }
}
