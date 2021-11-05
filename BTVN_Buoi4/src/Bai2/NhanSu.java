package Bai2;

import java.util.Scanner;

public class NhanSu {
    private String maNhansu;
    private String hoTen;
    private Date NS;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma nhan su : ");
        maNhansu = sc.nextLine();
        System.out.print("Nhap ho ten : ");
        hoTen = sc.nextLine();
        NS = new Date();
        NS.Nhap();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20s \n", maNhansu, hoTen, NS.Xuat());
    }
}
