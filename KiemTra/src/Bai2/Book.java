package Bai2;

import java.util.Scanner;

public class Book extends Document{
    private int numberOfPage;
    private String Author;

    public Book(){}

    public Book(String id, String name, String published, float price, int numberOfPage, String author) {
        super(id, name, published, price);
        this.numberOfPage = numberOfPage;
        Author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public void Nhap(){
        Scanner sc = new Scanner(System.in);
        super.Nhap();
        System.out.print("Import number of page: ");
        numberOfPage = sc.nextInt();
        System.out.print("Import author: ");
        Author = sc.nextLine();
    }
}
