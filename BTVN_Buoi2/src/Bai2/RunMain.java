package Bai2;

import java.util.Arrays;
import java.util.Scanner;

public class RunMain {
    static int n;
    static int[] a;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int chon;
        do{
            System.out.println("\t===== * MENU * =====");
            System.out.println("1.Nhap mang voi n so nguyen");
            System.out.println("2.Hien thi mang vua khoi tao");
            System.out.println("3.Them 1 phan tu vao vi tri k bat ky");
            System.out.println("4.Xoa 1 phan tu tai vi tri k bat ky");
            System.out.println("5.Dao nguoc mang");
            System.out.println("6.Hien thi phan tu a[1] va cac so chia het cho a[1]");
            System.out.println("7.Xuat ra man hinh tong cac so nguyen to trong mang");
            System.out.println("8.Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            switch (chon){
                case 1:
                    NhapMang();
                    break;
                case 2:
                    if(n==0){
                        System.out.println("Chua tao mang");
                        break;
                    }else{
                        System.out.print("Mang vua nhap la: ");
                        XuatMang(a,n);
                        break;
                    }
                case 3:
                    ThemPT();
                    break;
                case 4:
                    XoaPT();
                    break;
                case 5:
                    DaoMang();
                    break;
                case 6:
                    ChiaA1();
                    break;
                case 7:
                    System.out.println("Tong cac so nguyen to trong mang: " + SumSNT());
                    break;
                case 8:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Yeu cau nhap lai");
            }
        }while (true);
    }
    public static void NhapMang(){
        System.out.print("Nhap n: ");
        do{
            n = sc.nextInt();
            if(n<=0)
                System.out.print("Nhap lai n: ");
        }while (n <= 0);
        a = new int[n];
        for (int i = 0 ; i < n ; i++) {
            System.out.print("Nhap a[" + (i + 1) + "]: ");
            a[i] = sc.nextInt();
        }
    }
    public static void XuatMang(int[] a,int n){
        for(int i = 0 ; i < n ; i++){
            System.out.print(" "+a[i]);
        }
        System.out.println();
    }
    public static void ThemPT(){
        System.out.print("Nhap phan tu can them: ");
        int them = sc.nextInt();
        System.out.print("Nhap vi tri can them: ");
        int k = sc.nextInt();
        int newIndex = a.length + 1;
        int[] newArray = Arrays.copyOf(a,newIndex);
        for(int i = newIndex - 1 ; i >= k - 1 ; i--)
            newArray[i]=newArray[i-1];
        newArray[k - 1]=them;
        System.out.print("Mang sau khi them: ");
        XuatMang(newArray,newIndex);
    }
    public static void XoaPT(){
        System.out.print("Nhap vi tri can xoa: ");
        int k = sc.nextInt();
        for (int i = k - 1 ; i < n - 1 ; i++)
            a[i] = a[i+1];
        n--;
        System.out.print("Mang sau khi xoa: ");
        XuatMang(a,n);
    }
    public static void DaoMang(){
        int[] newArr = new int[n];
        int x = 0;
        for(int i = n - 1 ; i >= 0 ; i--)
            newArr[x++] = a[i];
        System.out.print("Mang sau khi dao la: ");
        XuatMang(newArr,n);
    }
    public static void ChiaA1(){
        System.out.println("Phan tu a[1]: " + a[0]);
        System.out.print("Cac phan tu chia het cho a[1] : ");
        for(int i = 1;i < n;i++)
            if(a[i] % a[0] == 0)
                System.out.print(a[i] + " ");
        System.out.println();
    }
    public static boolean SNT(int n){
        for(int i = 2; i * i <= n; i++)
            if(n % i ==0)
                return false;
        return n>1;
    }
    public static int SumSNT(){
        int sum=0;
        for(int i=0;i<n;i++)
            if(SNT(a[i]))
                sum+=a[i];
        return sum;
    }
}
