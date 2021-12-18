package Bai1;

import java.sql.SQLOutput;
import java.text.CollationElementIterator;
import java.util.*;

public class RunMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        try {
            System.out.print("Enter number of people: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                Person person = new Person();
                System.out.print("Enter id: ");
                person.setId(sc.nextLine());
                System.out.print("Enter name: ");
                person.setName(sc.nextLine());
                System.out.print("Enter address:");
                person.setAddress(sc.nextLine());
                personList.add(person);
            }
        } catch (Exception ex) {
            System.out.println("Wrong data input !");
        }
        System.out.println("Sort id ascending:");
        Collections.sort(personList);
        personList.forEach(person -> System.out.println(person));
        System.out.println();
        System.out.println("Sort names alphabetically (address descending alphabetically): ");
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getName().compareTo(o2.getName()) == 0) {
                    return o2.getAddress().compareTo(o1.getAddress());
                }
                return o1.getName().compareTo(o2.getName());
            }
        });
        personList.forEach(person -> System.out.println(person));
    }
}
