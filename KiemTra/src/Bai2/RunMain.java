package Bai2;

import java.util.Scanner;

public class RunMain {
    public static Scanner sc = new Scanner(System.in);
    public static BookManager bookManager = new BookManager();

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int choice;
        while (true) {
            System.out.println("---------- MENU ----------");
            System.out.println("1. Add book ");
            System.out.println("2. Edit book by id ");
            System.out.println("3. Delete book by id ");
            System.out.println("4. Sort books by name (ascending) ");
            System.out.println("5. Sort books by price (descending) ");
            System.out.println("6. Show all books");
            System.out.println("7. Exit.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    sortBookByName();
                    break;
                case 5:
                    sortBookByPrice();
                    break;
                case 6:
                    showBooks();
                    break;
                case 7:
                    System.out.println("Exit successful!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error!");
                    showMenu();
            }
        }
    }

    public static void addBook() {
        System.out.print("Enter id: ");
        int id = bookManager.readNewId();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();

        System.out.print("Enter price: ");
        Double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter number of page: ");
        int numberOfPage = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        Book book = new Book(id, name, publisher, price, numberOfPage, author);
        bookManager.addNewBook(book);
    }

    public static void editBook() {
        System.out.print("Enter the book id to edit: ");
        int id = bookManager.readId();
        bookManager.editBook(id);
    }

    public static void deleteBook() {
        System.out.print("Enter the book id to delete: ");
        int id = bookManager.readId();
        bookManager.deleteBook(id);
    }

    public static void sortBookByName() {
        bookManager.sortByName();
    }

    public static void sortBookByPrice() {
        bookManager.sortByPrice();
    }

    public static void showBooks() {
        bookManager.showListBook();
    }
}
