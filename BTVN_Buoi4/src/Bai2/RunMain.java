package Bai2;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        NhanSu x = new NhanSu();
        x.Nhap();
        System.out.printf("%-20s %-20s %-20s \n", "MaNhanSu", "HoTen", "NgaySinh");
        x.Xuat();
    }
}
