package Bai3;

import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private Hang[] x;
    private int n;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu : ");
        maPhieu = sc.nextLine();
        System.out.print("Nhap so hang : ");
        n = sc.nextInt();
        x = new Hang[n];
        for (int i=0; i<n; i++){
            System.out.println("Nhap hang thu " + (i+1) + " : ");
            x[i] = new Hang();
            x[i].Nhap();
        }
    }

    public void Xuat(){
        float sum = 0;
        System.out.printf("Ma phieu : %s\n",maPhieu);
        System.out.println("Thong tin hang:");
        System.out.printf("%-20s %-20s %-20s\n", "MaHang", "TenHang", "DonGia");
        for (int i=0; i<n; i++){
            sum += x[i].getDonGia();
            x[i].Xuat();
        }
        System.out.print("Tong so tien cua phieu : " + sum);
    }
}
