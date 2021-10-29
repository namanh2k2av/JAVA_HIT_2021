package Bai2;

import java.util.Scanner;

public class Array {
    private int n;
    private int[] a;
    Scanner sc = new Scanner(System.in);

    public Array(){
        this.n = 0;
        this.a = null;
    }

    public Array(int n, int[] a){
        this.n = n;
        this.a = a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void inputData(){
        System.out.print("Nhap n : ");
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("a[" + i + "] : ");
            a[i] = sc.nextInt();
        }
    }

    public void Show(){
        for(int i:a)
            System.out.print(i + " ");
        System.out.println();
    }

    public int Sum(){
        int sum = 0;
        for(int i = 0; i < n; i++)
            sum += a[i];
        return sum;
    }

    public void Filter(boolean flag){
        if(flag){
            System.out.print("Mang chan : ");
            for(int i = 0; i < n; i++){
                if(a[i] % 2 == 0)
                    System.out.print(a[i] + " ");
            }
        }else{
            System.out.print("Mang le : ");
            for(int i = 0; i < n; i++){
                if(a[i] % 2 == 1)
                    System.out.print(a[i] + " ");
            }
        }
    }
}
