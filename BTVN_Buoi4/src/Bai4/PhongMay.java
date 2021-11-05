package Bai4;

import java.util.Scanner;

public class PhongMay {
    private String maPhong;
    private String tenPhong;
    private float dienTich;
    private QuanLy x;
    private May[] y;
    private int n;

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma phong : ");
        maPhong = sc.nextLine();
        System.out.print("Nhap ten phong : ");
        tenPhong = sc.nextLine();
        System.out.print("Nhap dien tich : ");
        dienTich = sc.nextFloat();
        x = new QuanLy();
        x.Nhap();
        System.out.print("Nhap so luong may : ");
        n = sc.nextInt();
        y = new May[n];
        for (int i=0; i<n; i++){
            System.out.println("Nhap may thu " + (i+1) + " : ");
            y[i] = new May();
            y[i].Nhap();
        }
    }

    public void Xuat(){
        System.out.println("Ma phong : " + maPhong);
        System.out.println("Ten phong : " + tenPhong);
        System.out.println("Dien tich : " + dienTich + " m2");
        x.Xuat();
        System.out.printf("%-20s %-20s %-20s \n", "Ma May", "Kieu May", "Tinh Trang");
        for (int i=0; i<n; i++)
            y[i].Xuat();
    }
}
