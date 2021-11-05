package Bai3;

import java.util.Scanner;

public class Hang {
    private String maHang;
    private String tenHang;
    private float donGia;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hang : ");
        maHang = sc.nextLine();
        System.out.print("Nhap ten hang : ");
        tenHang = sc.nextLine();
        System.out.print("Nhap don gia : ");
        donGia = sc.nextFloat();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20f\n" , maHang, tenHang, donGia);
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}
