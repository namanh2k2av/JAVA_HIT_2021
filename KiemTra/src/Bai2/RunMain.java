package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        int chon;
        do{
            System.out.println("\t===== * MENU * =====");
            System.out.println("1.Add book");
            System.out.println("2.Edit book by id");
            System.out.println("3.Delete book by id");
            System.out.println("4.Sort books by name (ascending)");
            System.out.println("5.Sort books by price (descending)");
            System.out.println("6.Show all books");
            System.out.println("7.Exit");
            chon = sc.nextInt();
            switch (chon){
                case 1:
                    Book addBook = new Book();
                    addBook.Nhap();
                    books.add(addBook);
                    break;
            }
        }while (true);
    }
}
