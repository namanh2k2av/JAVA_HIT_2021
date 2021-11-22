package Bai1;

import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String s = sc.nextLine();
        int dem = 0,sum = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                dem++;
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
        }
        int tich = 1;
        System.out.println("Co " + dem + " ki tu so");
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                if(sum % Integer.parseInt(String.valueOf(s.charAt(i)))== 0){
                    tich*=Integer.parseInt(String.valueOf(s.charAt(i)));
                }
            }
        }
        System.out.println("Tich: " + tich);
    }
}
