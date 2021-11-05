package Bai4;

import java.util.Scanner;

public class May {
    private String maMay;
    private String kieuMay;
    private String tinhTrang;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma may : ");
        maMay = sc.nextLine();
        System.out.print("Nhap kieu may : ");
        kieuMay = sc.nextLine();
        System.out.print("Nhap tinh trang : ");
        tinhTrang = sc.nextLine();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20s\n", maMay, kieuMay, tinhTrang);
    }
}
