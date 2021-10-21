package Bai4;

import java.util.Locale;
import java.util.Scanner;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Chuoi s : ");
        String s = sc.nextLine();
        s = s.trim().toLowerCase(Locale.ROOT);
        s = s.replaceAll("[0-9]","");
        while(s.indexOf("  ") != -1)
            s = s.replaceAll("  "," ");
        char[] s1 = s.toCharArray();
        s1[0] = Character.toUpperCase(s1[0]);
        for (int i = 0; i < s1.length; i++)
            if(Character.isWhitespace(s1[i]) == true)
                s1[i+1] = Character.toUpperCase(s1[i+1]);
        System.out.println(s1);
    }
}
