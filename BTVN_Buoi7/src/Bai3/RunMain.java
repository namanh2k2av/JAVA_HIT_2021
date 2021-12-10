package Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<News> newsList = new ArrayList<>();
        int choose;
        while (true) {
            System.out.println("--------- MENU ---------");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");

            System.out.print("Enter your choose: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    insertNews(newsList);
                    break;
                case 2:
                    viewListNews(newsList);
                    break;
                case 3:
                    everageRare(newsList);
                    break;
                case 4:
                    System.out.println("Exit!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your choice is not valid!");
            }
        }
    }

    public static void insertNews(List<News> newsList) {
        News news = new News();
        System.out.print("Input id: ");
        news.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Input title: ");
        news.setTitle(sc.nextLine());
        System.out.print("Input publish date: ");
        news.setPublishDate(sc.nextLine());
        System.out.print("Input author: ");
        news.setAuthor(sc.nextLine());
        System.out.print("Input content: ");
        news.setContent(sc.nextLine());
        System.out.println("Input 3 rate: ");
        news.inputRateList();
        newsList.add(news);
    }

    public static void viewListNews(List<News> newsList) {
        for (News i: newsList) {
            i.Display();
        }
    }

    public static void everageRare(List<News> newsList) {
        for (News i: newsList) {
            i.Calculate();
            i.Display();
        }
    }
}
