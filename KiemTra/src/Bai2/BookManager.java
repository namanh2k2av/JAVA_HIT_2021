package Bai2;

import java.util.*;

public class BookManager {
    public Scanner sc = new Scanner(System.in);
    private List<Book> bookList = new ArrayList<>();

    private boolean checkExistId(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int readNewId() {
        int id;
        while (true) {
            try {
                do {
                    id = Integer.parseInt(sc.nextLine());
                    if (checkExistId(id)) {
                        System.out.print("Id does not exist! Rewrite your ID: ");
                    }
                } while (checkExistId(id));
                return id;
            } catch (NumberFormatException e) {
                System.out.print("Rewrite your ID: ");
            }
        }
    }

    public int readId() {
        int id;
        while (true) {
            try {
                do {
                    id = Integer.parseInt(sc.nextLine());
                    if (!checkExistId(id)) {
                        System.out.println("ID không tồn tại! Nhập lại ID: ");
                    }
                } while (!checkExistId(id));
                return id;
            } catch (NumberFormatException e) {
                System.out.println("ID phải là dạng số! Nhập lại ID: ");
            }
        }
    }

    public void addNewBook(Book book) {
        bookList.add(book);
        System.out.println("Add successful!");
    }

    public void editBook(int id) {
        int choice;
        System.out.println("----------CHỌN THUỘC TÍNH----------");
        System.out.println("1. Name");
        System.out.println("2. Publisher");
        System.out.println("3. Price");
        System.out.println("4. Number of page");
        System.out.println("5. Author");
        System.out.println("Enter your choice: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the new name to edit: ");
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookList.get(i).setName(sc.nextLine());
                    }
                }
                break;
            case 2:
                System.out.print("Enter the new publisher to edit: ");
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookList.get(i).setPublished(sc.nextLine());
                    }
                }
                break;
            case 3:
                System.out.print("Enter the new price to edit: ");
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookList.get(i).setPrice(sc.nextDouble());
                    }
                }
                break;
            case 4:
                System.out.print("Enter the new number of page to edit: ");
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookList.get(i).setNumberOfPage(sc.nextInt());
                    }
                }
                break;
            case 5:
                System.out.print("Enter the new author to edit: ");
                for (int i = 0; i < bookList.size(); i++) {
                    if (bookList.get(i).getId() == id) {
                        bookList.get(i).setAuthor(sc.nextLine());
                    }
                }
                break;
            default:
                break;
        }
        System.out.println("Edit Successfully!");
    }

    public void deleteBook(int id) {
        for (int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i).getId() == id)
            {
                bookList.remove(bookList.get(i));
            }
        }
        System.out.println("Delete successfully!");
    }

    public void sortByName() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Sort successfully!");
    }

    public void sortByPrice() {
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPrice().compareTo(o1.getPrice());
            }
        });
        System.out.println("Sort successfully!");
    }

    public void showListBook() {
        for (Book item : bookList) {
            System.out.println(item.toString());
        }
    }
}
