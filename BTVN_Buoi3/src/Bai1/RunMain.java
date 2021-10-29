package Bai1;

public class RunMain {
    public static void main(String[] args) {
        Person a = new Person("Nam Anh", 19, "Nam", "Code and Game");
        System.out.println(a.toString());
        Person b = new Person();
        b.setName("Nguoi Yeu");
        b.setAge(19);
        b.setGender("Nu");
        b.setHobby("Love<3");
        System.out.println("Name : " + b.getName());
        System.out.println("Age : " + b.getAge());
        System.out.println("Gender : " + b.getGender());
        System.out.println("Hobby : " + b.getHobby());
    }
}
