package Bai1;

import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private String nhaXuatban;
    private int soTrang;
    private float giaTien;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach : ");
        maSach = sc.nextLine();
        System.out.print("Nhap ten sach : ");
        tenSach = sc.nextLine();
        System.out.print("Nhap nha xuat ban : ");
        nhaXuatban = sc.nextLine();
        System.out.print("Nhap so trang : ");
        soTrang = sc.nextInt();
        System.out.print("Nhap gia tien : ");
        giaTien = sc.nextFloat();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20s %-20d %-20f \n" , maSach, tenSach, nhaXuatban, soTrang, giaTien);
    }

}
