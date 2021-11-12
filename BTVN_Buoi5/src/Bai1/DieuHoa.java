package Bai1;

import java.util.Scanner;

public class DieuHoa extends SanPham{
    private float congSuat;
    private long giaBan;

    public DieuHoa(){
    }

    @Override
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.print("Nhap cong suat : ");
        congSuat = sc.nextFloat();
        System.out.print("Nhap gia ban : ");
        giaBan = sc.nextLong();
    }

    @Override
    public void Xuat(){
        super.Xuat();
        System.out.printf("%-20f %-20d \n", congSuat, giaBan);
    }
    public DieuHoa(String maSP, String tenSP, String tenHangsx, String ngayNhap, float congSuat, long giaBan) {
        super(maSP, tenSP, tenHangsx, ngayNhap);
        this.congSuat = congSuat;
        this.giaBan = giaBan;
    }

    public float getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(float congSuat) {
        this.congSuat = congSuat;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

}
