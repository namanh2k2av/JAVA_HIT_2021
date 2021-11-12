package Bai3;

import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        LopHoc a = new LopHoc();
        System.out.print("Nhap ma lop hoc : ");
        a.setMaLH(sc.nextLine());
        System.out.print("Nhap ten lop hoc : ");
        a.setTenLH(sc.nextLine());
        System.out.print("Nhap ngay mo : ");
        a.setNgayMo(sc.nextLine());
        System.out.print("Nhap giao vien : ");
        a.setGiaoVien(sc.nextLine());
        System.out.print("Nhap so sinh vien trong lop : ");
        a.setN(Integer.parseInt(sc.nextLine()));
        for (int i=0; i< a.getN(); i++){
            System.out.println("\tNhap sinh vien thu " + (i+1) + " : ");
            SinhVien sv = new SinhVien();
            System.out.print("Nhap ma sinh vien : ");
            sv.setMaSV(sc.nextLine());
            System.out.print("Nhap nganh : ");
            sv.setNganh(sc.nextLine());
            System.out.print("Nhap khoa hoc : ");
            sv.setKhoaHoc(Integer.parseInt(sc.nextLine()));
            a.getX().add(sv);
        }
        System.out.println("\t\tThong tin lop hoc : ");
        Output(a);
        int dem = 0;
        for (int i=0; i< a.getN(); i++){
            if (a.getX().get(i).getKhoaHoc() == 15){
                dem++;
            }
        }
        System.out.println("Lop hoc co " + dem + " sinh vien khoa 15");
        for (int i=0; i< a.getN()-1; i++){
            for (int j=i+1; j< a.getN(); j++){
                if (a.getX().get(i).getKhoaHoc() > a.getX().get(j).getKhoaHoc()){
                    SinhVien temp = a.getX().get(i);
                    a.getX().set(i,a.getX().get(j));
                    a.getX().set(j,temp);
                }
            }
        }
        System.out.println("\t\tLop hoc sau khi sap xep : ");
        Output(a);
    }
    public static void Output(LopHoc a){
        System.out.println("Ma lop hoc : " + a.getMaLH());
        System.out.println("Ten lop hoc : " + a.getTenLH());
        System.out.println("Ngay mo : " + a.getNgayMo());
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n","HoTen", "NgaySinh", "QueQuan", "MaSV", "Nganh", "KhoaHoc");
        for (int i=0; i< a.getN(); i++){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20d\n", a.getX().get(i).hoTen, a.getX().get(i).ngaySinh, a.getX().get(i).queQuan, a.getX().get(i).getMaSV(), a.getX().get(i).getNganh(), a.getX().get(i).getKhoaHoc());
        }
        System.out.println("Giao vien : " + a.getGiaoVien());
    }
}
