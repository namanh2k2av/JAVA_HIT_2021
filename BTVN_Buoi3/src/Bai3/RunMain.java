package Bai3;

import java.util.Random;

public class RunMain {
    public static void main(String[] args) {
        Random rd = new Random();
        Guns DiepBeDe = new Guns("AK-47",100);
        Guns DoanXinhGai = new Guns("AK-47",100);
        while (true){
            DiepBeDe.Shoot(rd.nextInt(10)+1);
            DoanXinhGai.Shoot(rd.nextInt(10)+1);
            if (DiepBeDe.getAmmoNumber() == 0 && DoanXinhGai.getAmmoNumber() != 0){
                System.out.println("Anh DiepBeDe thua :v");
                break;
            } else if (DiepBeDe.getAmmoNumber() != 0 && DoanXinhGai.getAmmoNumber() == 0){
                System.out.println("Anh DoanXinhGai thua :v");
                break;
            } else {
                DiepBeDe.Load(rd.nextInt(10)+1);
                DoanXinhGai.Load(rd.nextInt(10)+1);
            }
        }
    }
}
