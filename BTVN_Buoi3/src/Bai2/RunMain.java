package Bai2;

public class RunMain {
    public static void main(String[] args) {
        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println("Nhap arr1 : ");
        arr1.inputData();
        System.out.println("Nhap arr2 : ");
        arr2.inputData();
        float tbc1 = arr1.Sum() / arr1.getN();
        float tbc2 = arr2.Sum() / arr2.getN();
        if (tbc1 > tbc2){
            System.out.print("Trung binh cong: arr1 > arr2");
        } else if (tbc1 < tbc2){
            System.out.print("Trung binh cong: arr1 < arr2");
        } else {
            System.out.print("Bye");
        }
    }
}
