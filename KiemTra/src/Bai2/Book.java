package Bai2;

import java.util.Scanner;

public class Book extends Document{
    private int numberOfPage;
    private String author;

    public Book(){}

    public Book(int id, String name, String published, Double price, int numberOfPage, String author) {
        super(id, name, published, price);
        this.numberOfPage = numberOfPage;
        this.author = author;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "numberOfPage=" + numberOfPage +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", published='" + published + '\'' +
                ", price=" + price +
                '}';
    }
}
