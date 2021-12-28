package Bai2;

import java.util.Scanner;

public class Document {
    protected int id;
    protected String name;
    protected String published;
    protected Double price;

    public Document(){}

    public Document(int id, String name, String published, Double price) {
        this.id = id;
        this.name = name;
        this.published = published;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
