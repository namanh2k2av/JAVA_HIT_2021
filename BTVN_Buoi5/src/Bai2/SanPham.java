package Bai2;

import java.util.Scanner;

public class SanPham {
    private String maSP;
    private String tenSP;
    private int soLuong;
    private float donGia;

    public void InputSP(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham : ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten san pham : ");
        tenSP = sc.nextLine();
        System.out.print("Nhap so luong : ");
        soLuong = sc.nextInt();
        System.out.print("Nhap don gia : ");
        donGia = sc.nextFloat();
    }

    public void OutputSP(){
        System.out.printf("%-20s %-20s %-20d %-20f %-20f\n", maSP, tenSP, soLuong, donGia, soLuong * donGia);
    }
}
