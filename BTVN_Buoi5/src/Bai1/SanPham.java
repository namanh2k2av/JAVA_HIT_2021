package Bai1;

import java.util.Scanner;

public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected String tenHangsx;
    protected String ngayNhap;

    public SanPham(){
    }

    public SanPham(String maSP, String tenSP, String tenHangsx, String ngayNhap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.tenHangsx = tenHangsx;
        this.ngayNhap = ngayNhap;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma san pham : ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten san pham : ");
        tenSP = sc.nextLine();
        System.out.print("Nhap ten hang san xuat : ");
        tenHangsx = sc.nextLine();
        System.out.print("Nhap ngay nhap : ");
        ngayNhap = sc.nextLine();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20s %-20s", maSP, tenSP, tenHangsx, ngayNhap);
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenHangsx() {
        return tenHangsx;
    }

    public void setTenHangsx(String tenHangsx) {
        this.tenHangsx = tenHangsx;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
