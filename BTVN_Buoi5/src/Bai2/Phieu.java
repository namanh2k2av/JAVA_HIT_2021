package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Phieu {
    private String maPhieu;
    private String tenPhieu;
    private DateTime a;
    private ArrayList<SanPham> x = new ArrayList<>();
    private int n;

    public void InputPhieu(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phieu : ");
        maPhieu = sc.nextLine();
        System.out.print("Nhap ten phieu : ");
        tenPhieu = sc.nextLine();
        a = new DateTime();
        a.InputDate();
        System.out.print("Nhap so san pham : ");
        n = sc.nextInt();
        for (int i=0; i<n; i++){
            System.out.println("Nhap san pham thu " + (i+1) + " : ");
            SanPham sp = new SanPham();
            sp.InputSP();
            x.add(sp);
        }
    }

    public void OutputPhieu(){
        System.out.println("Ma phieu : " + maPhieu);
        System.out.println("Ten phieu : " + tenPhieu);
        System.out.print("Ngay nhap : "); a.OutputDate();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "MaSP", "TenSP", "SoLuong", "DonGia", "ThanhTien");
        for (int i=0; i<n; i++){
            x.get(i).OutputSP();
        }
    }
}
