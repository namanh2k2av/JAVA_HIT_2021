package Bai2;

import java.util.Scanner;

public class Document {
    protected String Id;
    protected String Name;
    protected String Published;
    protected float Price;

    public Document(){}

    public Document(String id, String name, String published, float price) {
        Id = id;
        Name = name;
        Published = published;
        Price = price;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPublished() {
        return Published;
    }

    public void setPublished(String published) {
        Published = published;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Inport id: ");
        Id = sc.nextLine();
        System.out.print("Import name: ");
        Name = sc.nextLine();
        System.out.print("Import publisher: ");
        Published = sc.nextLine();
        System.out.print("Import price: ");
        Price = sc.nextFloat();
    }
}
