package Bai3;

public class Nguoi {
    protected String hoTen;
    protected String ngaySinh;
    protected String queQuan;

    public void Nhap(){
        System.out.print("Nhap ho ten : ");
        hoTen = RunMain.sc.nextLine();
        System.out.print("Nhap ngay sinh : ");
        ngaySinh = RunMain.sc.nextLine();
        System.out.print("Nhap que quan : ");
        queQuan = RunMain.sc.nextLine();
    }

    public void Xuat(){
        System.out.printf("%-20s %-20s %-20s", hoTen, ngaySinh, queQuan);
    }
}
