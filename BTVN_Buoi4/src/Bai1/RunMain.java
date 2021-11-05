package Bai1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n : ");
        int n = sc.nextInt();
        Sach[] a = new Sach[n];
        for (int i=0; i<n; i++){
            System.out.println("Nhap thong tin sach thu " + (i+1) + " : ");
            a[i] = new Sach();
            a[i].Nhap();
        }
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n" , "MaSach" , "TenSach" , "NhaXuatBan" , "SoTrang" , "GiaTien");
        for (int i=0; i<n; i++)
            a[i].Xuat();
    }
}
