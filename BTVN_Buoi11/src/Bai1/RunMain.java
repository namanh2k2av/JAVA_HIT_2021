package Bai1;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {
    static Scanner sc = new Scanner(System.in);
    static List<Account> accountList = new ArrayList<>();
    static FileController fileController = new FileController();
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int choice;
        while (true) {
            System.out.println("--------- MENU ------------");
            System.out.println("1. Create new account ");
            System.out.println("2. Login to an existing account ");
            System.out.println("3. Sort accounts by username ");
            System.out.println("4. Exit ");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    loginAccount();
                    break;
                case 3:
                    sortByUserName();
                    break;
                case 4:
                    System.out.println("Exit successful");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error!");
                    showMenu();
            }
        }
    }

    private static void createAccount() {
        String fullName, username, password, rePassword, email, phone, createAt;
        boolean checkUsername, checkExistUsername, checkPassword, checkEmail, checkPhone;
        Pattern regexUsername = Pattern.compile("^[a-zA-Z0-9]{6,}$");
        Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$");
        Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Pattern regexPhone = Pattern.compile("^[0-9\\-\\+]{9,15}$");
        //Id
        System.out.print("Enter id: ");
        long id = readNewId();
        //Fullname
        System.out.print("Enter fullName: ");
        fullName = sc.nextLine();
        //Username
        do {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            checkUsername = regexUsername.matcher(username).find();
            checkExistUsername = checkExistUsername(username);
            if (!checkUsername) {
                System.out.println("Invalid username!");
            } else {
                if (checkExistUsername) {
                    System.out.println("Username already exists");
                }
            }
        } while (checkExistUsername || !checkUsername);
        //Password
        do {
            System.out.print("Enter password: ");
            password = sc.nextLine();
            System.out.print("Enter confirm password: ");
            rePassword = sc.nextLine();
            checkPassword = regexPassword.matcher(password).find();
            if (!checkPassword) {
                System.out.println("Invalid password!");
            } else {
                if (password.compareTo(rePassword) != 0) {
                    System.out.println("Password and confirm password does not match!");
                }
            }
        } while (!checkPassword);
        //Email
        do {
            System.out.print("Enter email: ");
            email = sc.nextLine();
            checkEmail = regexEmail.matcher(email).find();
            if (!checkEmail) {
                System.out.println("Invalid email!");
            }
        } while (!checkEmail);
        //Phone
        do {
            System.out.print("Enter phone: ");
            phone = sc.nextLine();
            checkPhone = regexPhone.matcher(phone).find();
            if (!checkPhone) {
                System.out.println("Invalid email!");
            }
        } while (!checkPhone);
        //createAt
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        createAt = simpleDateFormat.format(date);

        Account account = new Account(id, fullName, username, password, email, phone, createAt);
        fileController.WriteAccountToFile("Account.DAT",account);
    }

    private static void loginAccount() {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        String username, password;
        System.out.print("Enter username: ");
        username = sc.nextLine();
        System.out.print("Enter password: ");
        password = sc.nextLine();
        if (checkExistAccount(username,password)) {
            Account account = new Account();
            for (int i = 0; i < accountList.size(); i++) {
                if(accountList.get(i).getUsername().compareTo(username) == 0){
                    account = accountList.get(i);
                }
            }
            do {
                System.out.println("1. Show info");
                System.out.println("2. Change password");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(account);
                        break;
                    case 2:
                        chancePassword(username, password, account);
                        break;
                    case 3:
                        return;
                }
            } while (true);
        }
    }

    private static boolean checkExistId(long id) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    private static long readNewId() {
        long id;
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

    private static boolean checkExistUsername(String username) {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getUsername().compareTo(username) == 0){
                return true;
            }
        }
        return false;
    }

    private static boolean checkExistAccount(String username, String password) {
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getUsername().compareTo(username) == 0 &&
                    accountList.get(i).getPassword().compareTo(password) == 0){
                return true;
            }
        }
        return false;
    }

    private static void chancePassword(String username, String oldPassword, Account account) {
        String reOldPassword, password, rePassword;
        boolean checkPassword;
        sc.nextLine();
        Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$");
        do {
            System.out.print("Enter old password: ");
            reOldPassword = sc.nextLine();
            System.out.print("Enter new password: ");
            password = sc.nextLine();
            System.out.print("Enter confirm new password: ");
            rePassword = sc.nextLine();
            checkPassword = regexPassword.matcher(password).find();
            if (reOldPassword.compareTo(oldPassword) != 0) {
                System.out.println("Old Password and password does not match!");
            } else {
                if (!checkPassword) {
                    System.out.println("Invalid password!");
                } else {
                    if (rePassword.compareTo(password) != 0) {
                        System.out.println("Password and confirm password does not match!");
                    } else {
                        account.setPassword(password);
                        fileController.UpdateAccountFile(accountList,"Account.DAT");
                        System.out.println("Change password sucssessful");
                        return;
                    }
                }
            }
        } while (!checkPassword || rePassword.compareTo(password) != 0);
    }

    private static void sortByUserName() {
        accountList = fileController.ReadAccountFromFile("Account.DAT");
        Collections.sort(accountList, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getUsername().compareTo(o2.getUsername());
            }
        });
        fileController.UpdateAccountFile(accountList,"Account.DAT");
        accountList.forEach(account -> System.out.println(account));
    }
}
