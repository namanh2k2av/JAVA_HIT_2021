package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Nhap so luong dieu trong hoa danh sach : ");
        n = sc.nextInt();
        ArrayList <DieuHoa> dieuHoas = new ArrayList<>();
        for (int i=0; i<n; i++){
            DieuHoa dh = new DieuHoa();
            System.out.println("Nhap dieu hoa thu " + (i + 1) + " : ");
            dh.Nhap();
            dieuHoas.add(dh);
        }
        int dem = 0;
        for (int i=0; i<n; i++){
            if(dieuHoas.get(i).getTenHangsx().compareToIgnoreCase("Electrolux") == 0){
                dem++;
            }
        }
        if (dem > 0){
            System.out.println("Danh sach dieu hoa co hang san xuat Electrolux : ");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaSP", "TenSP", "TenHangSX", "NgayNhap", "CongXuat", "GiaBan");
            for (int i=0; i<n; i++){
                if (dieuHoas.get(i).getTenHangsx().compareToIgnoreCase("Electrolux") == 0){
                    dieuHoas.get(i).Xuat();
                }
            }
        } else {
            System.out.println("Trong danh sach khong co hang Electrolux");
        }
        DieuHoa giaMin = dieuHoas.get(0);
        for (int i=0; i<n; i++){
            if (dieuHoas.get(i).getGiaBan() < giaMin.getGiaBan()){
                giaMin = dieuHoas.get(i);
            }
        }
        System.out.println("Cac san pham co gia ban thap nhat : ");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "MaSP", "TenSP", "TenHangSX", "NgayNhap", "CongXuat", "GiaBan");
        giaMin.Xuat();
    }
}
