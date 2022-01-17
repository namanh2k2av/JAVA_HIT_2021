package View;

import Controller.*;
import Model.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class RunMain {

    static Scanner sc = new Scanner(System.in);
    static List<Account> accountList = new ArrayList<>();
    static List<Pet> petList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Bill> billList = new ArrayList<>();
    static List<CustomerAccountManage> customerAccountManageList = new ArrayList<>();
    static FileController fileController = new FileController();

    public static void main(String[] args) {
        userAccuracy();
    }

    private static void userAccuracy() {
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*----------- Chức năng ------------*");
            System.out.println("|      1. Dành cho admin           |");
            System.out.println("|      2. Dành cho khách hàng      |");
            System.out.println("|      0. Thoát                    |");
            System.out.println("|__________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    accAdmin();
                    break;
                case 2:
                    accCustomer();
                    break;
                case 0:
                    System.out.println("Thoát thành công!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn sai chức năng!");
                    userAccuracy();
            }
        }
    }

    private static void accAdmin() {
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*----------- Tài Khoản -----------*");
            System.out.println("|        1. Đăng nhập             |");
            System.out.println("|        0. Thoát                 |");
            System.out.println("|_________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    loginAddmin();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng!");
                    accAdmin();
            }
        }
    }

    private static void createAccount(String fileName) {
        String fullName, username, password, rePassword, email, phone, createAt;
        boolean checkUsername, checkExistUsername, checkPassword, checkEmail, checkPhone;
        Pattern regexUsername = Pattern.compile("^[a-zA-Z0-9]{6,}$");
        Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$");
        Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Pattern regexPhone = Pattern.compile("^[0-9\\-\\+]{9,15}$");
        //Id
        long id = autoInputAccountId(fileName);
        //Fullname
        System.out.print("Nhập fullName: ");
        fullName = sc.nextLine();
        //Username
        do {
            System.out.print("Nhập username: ");
            username = sc.nextLine();
            checkUsername = regexUsername.matcher(username).find();
            checkExistUsername = checkExistUsername(username, fileName);
            if (!checkUsername) {
                System.out.println("Username không có kí tự đặc biệt và phải lớn hơn 5 kí tự!");
            } else {
                if (checkExistUsername) {
                    System.out.println("Username đã tồn tại!");
                }
            }
        } while (checkExistUsername || !checkUsername);
        //Password
        do {
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            System.out.print("Nhập lại password: ");
            rePassword = sc.nextLine();
            checkPassword = regexPassword.matcher(password).find();
            if (!checkPassword) {
                System.out.println("Password phải có kí tự chữ cái in hoa, chữ thường, số và kí tự đặc biệt!");
            } else {
                if (password.compareTo(rePassword) != 0) {
                    System.out.println("Password không khớp với nhau!");
                }
            }
        } while (!checkPassword);
        //Email
        do {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            checkEmail = regexEmail.matcher(email).find();
            if (!checkEmail) {
                System.out.println("Email không hợp lệ!");
            }
        } while (!checkEmail);
        //Phone
        do {
            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine();
            checkPhone = regexPhone.matcher(phone).find();
            if (!checkPhone) {
                System.out.println("Số điện thoại không hợp lệ!");
            }
        } while (!checkPhone);
        //createAt
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        createAt = simpleDateFormat.format(date);

        Account account = new Account(id, fullName, username, password, email, phone, createAt);
        fileController.WriteAccountToFile(fileName,account);

        System.out.println("Tạo tài khoản thành công!");
    }

    private static boolean checkExistUsername(String username, String fileName) {
        accountList = fileController.ReadAccountFromFile(fileName);
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getUsername().compareTo(username) == 0){
                return true;
            }
        }
        return false;
    }

    private static void loginAddmin() {
        accountList = fileController.ReadAccountFromFile("AccountAdmin.DAT");
        String username, password;
        System.out.print("Nhập username: ");
        username = sc.nextLine();
        System.out.print("Nhập password: ");
        password = sc.nextLine();
        if (checkExistAccount(username,password)) {
            Account account = new Account();
            for (int i = 0; i < accountList.size(); i++) {
                if(accountList.get(i).getUsername().compareTo(username) == 0){
                    account = accountList.get(i);
                }
            }
            do {
                System.out.println();
                System.out.println("*----------- Chức năng -----------*");
                System.out.println("|    1. Quản lý danh sách Pet     |");
                System.out.println("|    2. Quản lý hóa đơn           |");
                System.out.println("|    3. Quản lý tài khoản         |");
                System.out.println("|    0. Quay lại                  |");
                System.out.println("|_________________________________|");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        petManagement();
                        break;
                    case 2:
                        billManagement();
                        break;
                    case 3:
                        accountManagement(account);
                        break;
                    case 0:
                        return;
                }
            } while (true);
        } else {
            System.out.println("Tài khoản hoặc mật khẩu không tồn tại!");
        }
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

    private static void accountManagement(Account account) {
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*--------------- Chức năng --------------*");
            System.out.println("|     1. Thông tin tài khoản             |");
            System.out.println("|     2. Thay đổi thông tin tài khoản    |");
            System.out.println("|     3. Danh sách tài khoản             |");
            System.out.println("|     4. Săp xếp danh sách tài khoản     |");
            System.out.println("|     0. Quay lại                        |");
            System.out.println("|________________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "Id", "FullName", "Username", "Email", "Phone", "CreateAt");
                    account.outputAccount();
                    break;
                case 2:
                    changeAccount(account, "AccountAdmin.DAT");
                    break;
                case 3:
                    accountList = fileController.ReadAccountFromFile("AccountAdmin.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "Id", "FullName", "Username", "Email", "Phone", "CreateAt");
                    accountList.forEach(accounts -> accounts.outputAccount());
                    break;
                case 4:
                    sortAccount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng!");
            }
        }
    }

    private static void changeAccount(Account account, String fileName) {
        do {
            System.out.println();
            System.out.println("*--------- Thay đổi ---------*");
            System.out.println("|        1. Fullname         |");
            System.out.println("|        2. Password         |");
            System.out.println("|        3. Phonenumber      |");
            System.out.println("|        4. Email            |");
            System.out.println("|        0. Quay lại         |");
            System.out.println("|____________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    changeFullname(account,fileName);
                    break;
                case 2:
                    changePassword(account,fileName);
                    break;
                case 3:
                    changePhone(account,fileName);
                    break;
                case 4:
                    changeEmail(account,fileName);
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static void changeFullname(Account account, String fileName) {
        String fullName;
        sc.nextLine();
        System.out.print("Nhập fullname: ");
        fullName = sc.nextLine();
        account.setFullName(fullName);
        fileController.UpdateAccountFile(accountList,fileName);
        System.out.println("Thay đổi fullname thành công");
    }

    private static void changePassword(Account account, String fileName) {
        String oldPassword = account.getPassword(), reOldPassword, password, rePassword;
        boolean checkPassword;
        sc.nextLine();
        Pattern regexPassword = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,}$");
        do {
            System.out.print("Nhập password cũ: ");
            reOldPassword = sc.nextLine();
            System.out.print("Nhập password mới: ");
            password = sc.nextLine();
            System.out.print("Nhập lại password mới: ");
            rePassword = sc.nextLine();
            checkPassword = regexPassword.matcher(password).find();
            if (reOldPassword.compareTo(oldPassword) != 0) {
                System.out.println("Password cũ không chính sác!");
            } else {
                if (!checkPassword) {
                    System.out.println("Password không hợp lệ!");
                } else {
                    if (rePassword.compareTo(password) != 0) {
                        System.out.println("Password không khớp với nhau!");
                    } else {
                        account.setPassword(password);
                        fileController.UpdateAccountFile(accountList,fileName);
                        System.out.println("Thay đổi password thành công!");
                        return;
                    }
                }
            }
        } while (!checkPassword || rePassword.compareTo(password) != 0);
    }

    private static void changePhone(Account account, String fileName) {
        String phone;
        boolean checkPhone;
        sc.nextLine();
        Pattern regexPhone = Pattern.compile("^[0-9\\-\\+]{9,15}$");
        do {
            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine();
            checkPhone = regexPhone.matcher(phone).find();
            if (!checkPhone) {
                System.out.println("Số điện thoại không hợp lệ!");
            } else {
                account.setPhone(phone);
                fileController.UpdateAccountFile(accountList,fileName);
                System.out.println("Thay đổi số điện thoại thành công!");
            }
        } while (!checkPhone);
    }

    private static void changeEmail(Account account, String fileName) {
        String email;
        boolean checkEmail;
        sc.nextLine();
        Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        do {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            checkEmail = regexEmail.matcher(email).find();
            if (!checkEmail) {
                System.out.println("Email không hợp lệ!");
            } else {
                account.setEmail(email);
                fileController.UpdateAccountFile(accountList,fileName);
                System.out.println("Thay đổi email thành công!");
            }
        } while (!checkEmail);
    }
    private static void sortAccount() {
        do {
            System.out.println();
            System.out.println("*--------------------- Chức năng---------------------*");
            System.out.println("|    1. Sắp xếp danh sách tài khoản theo họ và tên   |");
            System.out.println("|    2. Sắp xếp danh sách tài khoản theo username    |");
            System.out.println("|    3. Sắp xếp danh sách tài khoản theo ngày tạo    |");
            System.out.println("|    0. Quay lại                                     |");
            System.out.println("|____________________________________________________|");
            System.out.print("Chọn chức năng: ");
            int sortAccount = sc.nextInt();
            switch (sortAccount) {
                case 1:
                    accountList = fileController.ReadAccountFromFile("AccountAdmin.DAT");
                    Collections.sort(accountList, new SortAccByFullname());
                    fileController.UpdateAccountFile(accountList,"AccountAdmin.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "Id", "FullName", "Username", "Email", "Phone", "CreateAt");
                    accountList.forEach(account -> account.outputAccount());
                    break;
                case 2:
                    accountList = fileController.ReadAccountFromFile("AccountAdmin.DAT");
                    Collections.sort(accountList, new SortAccByUsername());
                    fileController.UpdateAccountFile(accountList,"AccountAdmin.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "Id", "FullName", "Username", "Email", "Phone", "CreateAt");
                    accountList.forEach(account -> account.outputAccount());
                    break;
                case 3:
                    accountList = fileController.ReadAccountFromFile("AccountAdmin.DAT");
                    Collections.sort(accountList, new SortAccByCreateAt());
                    fileController.UpdateAccountFile(accountList,"AccountAdmin.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "Id", "FullName", "Username", "Email", "Phone", "CreateAt");
                    accountList.forEach(account -> account.outputAccount());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static void petManagement(){
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*----------------- Chức năng -----------------*");
            System.out.println("|      1. Xem danh sách Pet                   |");
            System.out.println("|      2. Thêm Pet vào danh sách              |");
            System.out.println("|      3. Xóa Pet trong danh sách             |");
            System.out.println("|      4. Sửa thông tin Pet trong danh sách   |");
            System.out.println("|      5. Sắp xếp danh sách Pet               |");
            System.out.println("|      6. Tìm kiếm Pet                        |");
            System.out.println("|      0. Quay lại                            |");
            System.out.println("|_____________________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    petList.forEach(pet -> pet.outputPet());
                    break;
                case 2:
                    addPet();
                    break;
                case 3:
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    petList.forEach(pet -> pet.outputPet());
                    deletePet();
                    break;
                case 4:
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    petList.forEach(pet -> pet.outputPet());
                    changePet();
                    break;
                case 5:
                    sortPet();
                    break;
                case 6:
                    searchPet();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng!");
            }
        }
    }

    private static void addPet() {
        //Id
        long id = autoInputPetId();
        //petName
        System.out.print("Nhập tên thú nuôi: ");
        String petName = sc.nextLine();
        //species
        System.out.print("Nhập giống loài thú nuôi: ");
        String species = sc.nextLine();
        //petGender
        System.out.print("Nhập giới tính thú nuôi: ");
        String petGender = sc.nextLine();
        //petAge
        System.out.print("Nhập tuổi thú nuôi: ");
        String petAge = sc.nextLine();
        //featherColor
        System.out.print("Nhập màu lông thú nuôi: ");
        String featherColor = sc.nextLine();
        //petPrice
        System.out.print("Nhập giá thú nuôi: ");
        long petPrice = sc.nextLong();

        Pet pet = new Pet(id, petName, species, petGender, petAge, featherColor, petPrice);
        fileController.WritePetToFile("PetStore.DAT",pet);
        System.out.println("Thêm pet vào danh sách thành công!");
    }

    private static boolean checkExistPetId(long id) {
        petList = fileController.ReadPetFromFile("PetStore.DAT");
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getPetId() == id) {
                return true;
            }
        }
        return false;
    }

    private static long readOldIdPet() {
        long id;
        while (true) {
            try {
                do {
                    id = Integer.parseInt(sc.nextLine());
                    if (!checkExistPetId(id)) {
                        System.out.print("Id không tồn tại! Nhập lại ID: ");
                    }
                } while (!checkExistPetId(id));
                return id;
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại ID: ");
            }
        }
    }

    private static void deletePet() {
        petList = fileController.ReadPetFromFile("PetStore.DAT");
        long id;
        System.out.print("Nhập id của Pet cần xóa khỏi danh sách: ");
        do {
            id = sc.nextInt();
            if (!checkExistPetId(id)) {
                System.out.print("Id không tồn tại! Nhập lại id Pet cần xóa: ");
            }
        } while (!checkExistPetId(id));
        for (int i = 0; i < petList.size(); i++) {
            if (petList.get(i).getPetId() == id) {
                petList.remove(i);
            }
        }
        fileController.UpdatePetFile(petList,"PetStore.DAT");
        System.out.println("Xóa thành công!");
    }

    private static void changePet() {
        do {
            System.out.println();
            System.out.println("*-------------- Sửa --------------*");
            System.out.println("|    1. Toàn bộ thông tin Pet     |");
            System.out.println("|    2. Từng thông tin Pet        |");
            System.out.println("|    0. Quay lại                  |");
            System.out.println("|_________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    long id1;
                    System.out.print("Nhập id của Pet cần sửa trong danh sách: ");
                    do {
                        id1 = sc.nextInt();
                        if (!checkExistPetId(id1)) {
                            System.out.print("Id không tồn tại! Nhập lại id Pet cần sửa: ");
                        }
                    } while (!checkExistPetId(id1));
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getPetId() == id1) {
                            sc.nextLine();
                            System.out.print("Nhập tên thú nuôi: ");
                            String petName = sc.nextLine();
                            petList.get(i).setPetName(petName);
                            System.out.print("Nhập giống loài thú nuôi: ");
                            String species = sc.nextLine();
                            petList.get(i).setSpecies(species);
                            System.out.print("Nhập giới tính thú nuôi: ");
                            String petGender = sc.nextLine();
                            petList.get(i).setPetGender(petGender);
                            System.out.print("Nhập tuổi thú nuôi: ");
                            String petAge = sc.nextLine();
                            petList.get(i).setPetAge(petAge);
                            System.out.print("Nhập màu lông thú nuôi: ");
                            String featherColor = sc.nextLine();
                            petList.get(i).setFeatherColor(featherColor);
                            System.out.print("Nhập giá thú nuôi: ");
                            long petPrice = sc.nextLong();
                            petList.get(i).setPetPrice(petPrice);
                            fileController.UpdatePetFile(petList, "PetStore.DAT");
                            System.out.println("Sửa thông tin Pet thành công!");
                        }
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("*-------------- Sửa --------------*");
                    System.out.println("|     1. Tên thú nuôi             |");
                    System.out.println("|     2. Giống loài thú nuôi      |");
                    System.out.println("|     3. Giới tính thú nuôi       |");
                    System.out.println("|     4. Tuổi thú nuôi            |");
                    System.out.println("|     5. Màu lông thú nuôi        |");
                    System.out.println("|     6. Giá thú nuôi             |");
                    System.out.println("|     0. Quay lại                 |");
                    System.out.println("|_________________________________|");
                    System.out.print("Chọn chức năng: ");
                    int choiceP = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập id của Pet cần sửa trong danh sách: ");
                    long id2 = readOldIdPet();
                    switch (choiceP) {
                        case 1:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập tên thú nuôi: ");
                                    String petName = sc.nextLine();
                                    petList.get(i).setPetName(petName);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 2:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập giống loài thú nuôi: ");
                                    String species = sc.nextLine();
                                    petList.get(i).setSpecies(species);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 3:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập giới tính thú nuôi: ");
                                    String petGender = sc.nextLine();
                                    petList.get(i).setPetGender(petGender);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 4:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập tuổi thú nuôi: ");
                                    String petAge = sc.nextLine();
                                    petList.get(i).setPetAge(petAge);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 5:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập màu lông thú nuôi: ");
                                    String featherColor = sc.nextLine();
                                    petList.get(i).setFeatherColor(featherColor);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 6:
                            petList = fileController.ReadPetFromFile("PetStore.DAT");
                            for (int i = 0; i < petList.size(); i++) {
                                if (petList.get(i).getPetId() == id2) {
                                    System.out.print("Nhập giá thú nuôi: ");
                                    long petPrice = sc.nextLong();
                                    petList.get(i).setPetPrice(petPrice);
                                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                                    System.out.println("Sửa thông tin Pet thành công!");
                                }
                            }
                            break;
                        case 0:
                            return;
                    }
                case 0:
                    return;
            }
        } while (true) ;
    }

    private static void sortPet() {
        do {
            System.out.println("----------------- Chức năng -----------------");
            System.out.println("|   1. Sắp xếp danh sách Pet theo tên Pet   |");
            System.out.println("|   2. Sắp xếp danh sách Pet theo giá       |");
            System.out.println("|   0. Quay lại                             |");
            System.out.println("|___________________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    Collections.sort(petList, new SortPetByNamePet());
                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    petList.forEach(pet -> pet.outputPet());
                    break;
                case 2:
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    for (int i = 0; i < petList.size(); i++) {
                        for (int j = i + 1; j < petList.size(); j++) {
                            if (petList.get(i).getPetPrice() > petList.get(j).getPetPrice()) {
                                Pet temp = petList.get(i);
                                petList.set(i, petList.get(j));
                                petList.set(j, temp);
                            }
                        }
                    }
                    fileController.UpdatePetFile(petList, "PetStore.DAT");
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    petList.forEach(pet -> pet.outputPet());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static void searchPet() {
        do {
            System.out.println();
            System.out.println("*------------ Chức năng ------------*");
            System.out.println("|    1. Tìm kiếm Pet theo tên       |");
            System.out.println("|    2. Tìm kiếm Pet theo loài      |");
            System.out.println("|    3. Tìm kiếm Pet theo màu lông  |");
            System.out.println("|    4. Tìm kiếm Pet theo giá       |");
            System.out.println("|    0. Quay lại                    |");
            System.out.println("|___________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            petList = fileController.ReadPetFromFile("PetStore.DAT");
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên thú nuôi cần tìm: ");
                    sc.nextLine();
                    String namePet = sc.nextLine();
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getPetName().contains(namePet)) {
                            petList.get(i).outputPet();
                        }
                    }
                    break;
                case 2:
                    System.out.print("Nhập loài thú nuôi cần tìm: ");
                    sc.nextLine();
                    String species = sc.nextLine();
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getSpecies().contains(species)) {
                            petList.get(i).outputPet();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập màu lông thú nuôi cần tìm: ");
                    sc.nextLine();
                    String featherColor = sc.nextLine();
                    System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getFeatherColor().contains(featherColor)) {
                            petList.get(i).outputPet();
                        }
                    }
                    break;
                case 4:
                    do {
                        System.out.println();
                        System.out.println("*------------------ Giá ------------------*");
                        System.out.println("|   1. Nhỏ hơn 5.000.000 VND              |");
                        System.out.println("|   2. 5.000.000 VND đến 10.000.000 VND   |");
                        System.out.println("|   3. 10.000.000 VND đến 20.000.000 VND  |");
                        System.out.println("|   4. Lớn hơn 20.000.000 VND             |");
                        System.out.println("|   0. Quay lại                           |");
                        System.out.println("|_________________________________________|");
                        System.out.print("Chọn chức năng: ");
                        int find = sc.nextInt();
                        switch (find) {
                            case 1:
                                System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                                for (int i = 0; i < petList.size(); i++) {
                                    if (petList.get(i).getPetPrice() < 5000000) {
                                        petList.get(i).outputPet();
                                    }
                                }
                                break;
                            case 2:
                                System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                                for (int i = 0; i < petList.size(); i++) {
                                    if (petList.get(i).getPetPrice() >= 5000000 && petList.get(i).getPetPrice() < 10000000) {
                                        petList.get(i).outputPet();
                                    }
                                }
                                break;
                            case 3:
                                System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                                for (int i = 0; i < petList.size(); i++) {
                                    if (petList.get(i).getPetPrice() >= 10000000 && petList.get(i).getPetPrice() < 20000000) {
                                        petList.get(i).outputPet();
                                    }
                                }
                                break;
                            case 4:
                                System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "Id", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                                for (int i = 0; i < petList.size(); i++) {
                                    if (petList.get(i).getPetPrice() > 20000000) {
                                        petList.get(i).outputPet();
                                    }
                                }
                                break;
                            case 0:
                                return;
                        }
                    } while (true);
                case 0:
                    return;
            }
        } while (true);
    }

    private static void billManagement() {
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*--------------- Chức năng ---------------*");
            System.out.println("|    1. Xem danh sách các hóa đơn         |");
            System.out.println("|    2. Tạo hóa đơn                       |");
            System.out.println("|    3. Sắp xếp hóa đơn trong danh sách   |");
            System.out.println("|    4. Xem danh sách khách hàng          |");
            System.out.println("|    5. Sửa thông tin khách hàng          |");
            System.out.println("|    0. Quay lại                          |");
            System.out.println("|_________________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    billList = fileController.ReadBillFromFile("Bill.DAT");
                    System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                    billList.forEach(bill -> bill.outputBill());
                    break;
                case 2:
                    createBill();
                    break;
                case 3:
                    sortBill();
                    break;
                case 4:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "customerId", "customerName", "customerAge", "customerGender", "customerAddress", "customerPhone");
                    customerList.forEach(customer -> customer.outputCustomer());
                    break;
                case 5:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "customerId", "customerName", "customerAge", "customerGender", "customerAddress", "customerPhone");
                    customerList.forEach(customer -> customer.outputCustomer());
                    System.out.print("Nhập id cần sửa: ");
                    long id = readOldCustomerId();
                    changeCustomer(id);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng!");
            }
        }
    }

    private static void createBill() {
        do {
            System.out.println();
            System.out.println("*------------- Khách hàng -------------*");
            System.out.println("|        1. Đã có thông tin            |");
            System.out.println("|        2. Chưa có thông tin          |");
            System.out.println("|        0. Quay lại                   |");
            System.out.println("|______________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    long billId = autoInputBillId();
                    System.out.print("Nhập id khách hàng: ");
                    long customerId = readOldCustomerId();
                    // Xóa Pet trong file PetStore, Thêm Pet vào file PetBill
                    System.out.print("Nhập id pet: ");
                    long petId = readOldIdPet();
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    long totalMoney = 0;
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getPetId() == petId) {
                            Pet pet = new Pet(petList.get(i).getPetId(), petList.get(i).getPetName(),
                                    petList.get(i).getSpecies(), petList.get(i).getPetGender(),
                                    petList.get(i).getPetAge(), petList.get(i).getFeatherColor(),
                                    petList.get(i).getPetPrice());
                            totalMoney = petList.get(i).getPetPrice();
                            fileController.WritePetToFile("PetBill.DAT", pet);
                            petList.remove(i);
                        }
                    }
                    fileController.UpdatePetFile(petList,"PetStore.DAT");

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dateOfPurchase = simpleDateFormat.format(date);

                    Bill bill = new Bill(billId, customerId, petId, totalMoney, dateOfPurchase);
                    fileController.WriteBillToFile("Bill.DAT", bill);

                    System.out.println("Tạo hóa đơn thành công!");
                    break;
                }
                case 2: {
                    System.out.println("Nhập thông tin khách hàng:");
                    System.out.print("Nhập id khách hàng: ");
                    long customerId = readNewCustomerId();
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = sc.nextLine();
                    System.out.print("Nhập tuổi khách hàng: ");
                    int customerAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập giới tính khách hàng: ");
                    String customerGender = sc.nextLine();
                    System.out.print("Nhập địa chỉ khách hàng: ");
                    String customerAddress = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String customerPhone = sc.nextLine();

                    Customer customer = new Customer(customerId, customerName, customerAge, customerGender, customerAddress, customerPhone);
                    fileController.WriteCustomerToFile("Customer.DAT", customer);
                    System.out.println("Thêm khách hàng vào danh sách thành công!");

                    long billId =autoInputBillId();

                    // Xóa Pet trong file PetStore, Thêm Pet vào file PetBill.DAT
                    System.out.print("Nhập id pet: ");
                    long petId = readOldIdPet();
                    petList = fileController.ReadPetFromFile("PetStore.DAT");
                    long totalMoney = 0;
                    for (int i = 0; i < petList.size(); i++) {
                        if (petList.get(i).getPetId() == petId) {
                            Pet pet = new Pet(petList.get(i).getPetId(), petList.get(i).getPetName(),
                                    petList.get(i).getSpecies(), petList.get(i).getPetGender(),
                                    petList.get(i).getPetAge(), petList.get(i).getFeatherColor(),
                                    petList.get(i).getPetPrice());
                            totalMoney = petList.get(i).getPetPrice();
                            fileController.WritePetToFile("PetBill.DAT", pet);
                            petList.remove(i);
                        }
                    }
                    fileController.UpdatePetFile(petList,"PetStore.DAT");

                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    String dateOfPurchase = simpleDateFormat.format(date);

                    Bill bill = new Bill(billId, customerId, petId, totalMoney, dateOfPurchase);
                    fileController.WriteBillToFile("Bill.DAT", bill);

                    System.out.println("Tạo hóa đơn thành công!");
                    break;
                }
                case 0:
                    return;
            }
        } while (true);
    }

    private static boolean checkExistCustomerId(long id) {
        customerList = fileController.ReadCustomerFromFile("Customer.DAT");
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCustomerId() == id) {
                return true;
            }
        }
        return false;
    }

    private static long readNewCustomerId() {
        long id;
        while (true) {
            try {
                do {
                    id = Integer.parseInt(sc.nextLine());
                    if (checkExistCustomerId(id)) {
                        System.out.print("Id tồn tại! Nhập lại ID: ");
                    }
                } while (checkExistCustomerId(id));
                return id;
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại ID: ");
            }
        }
    }

    private static long readOldCustomerId() {
        long id;
        while (true) {
            try {
                do {
                    id = Integer.parseInt(sc.nextLine());
                    if (!checkExistCustomerId(id)) {
                        System.out.print("Id không tồn tại! Nhập lại ID: ");
                    }
                } while (!checkExistCustomerId(id));
                return id;
            } catch (NumberFormatException e) {
                System.out.print("Nhập lại ID: ");
            }
        }
    }

    private static void sortBill() {
        do {
            System.out.println();
            System.out.println("*-------------- Chức năng --------------*");
            System.out.println("|     1. Sắp xếp theo id khách hàng     |");
            System.out.println("|     2. Sắp xếp theo id pet            |");
            System.out.println("|     3. Sắp xếp theo thành tiền        |");
            System.out.println("|     4. sắp xếp theo ngày tạo          |");
            System.out.println("|     0. Quay lại                       |");
            System.out.println("|_______________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            billList = fileController.ReadBillFromFile("Bill.DAT");
            switch (choice) {
                case 1:
                    for (int i = 0; i < billList.size(); i++) {
                        for (int j = i + 1; j < billList.size(); j++) {
                            if (billList.get(i).getCustomerId() > billList.get(j).getCustomerId()) {
                                Bill temp = billList.get(i);
                                billList.set(i, billList.get(j));
                                billList.set(j, temp);
                            }
                        }
                    }
                    fileController.UpdateBillFile(billList, "Bill.DAT");
                    System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                    billList.forEach(bill -> bill.outputBill());
                    break;
                case 2:
                    for (int i = 0; i < billList.size(); i++) {
                        for (int j = i + 1; j < billList.size(); j++) {
                            if (billList.get(i).getPetId() > billList.get(j).getPetId()) {
                                Bill temp = billList.get(i);
                                billList.set(i, billList.get(j));
                                billList.set(j, temp);
                            }
                        }
                    }
                    fileController.UpdateBillFile(billList, "Bill.DAT");
                    System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                    billList.forEach(bill -> bill.outputBill());
                    break;
                case 3:
                    for (int i = 0; i < billList.size(); i++) {
                        for (int j = i + 1; j < billList.size(); j++) {
                            if (billList.get(i).getTotalMoney() > billList.get(j).getTotalMoney()) {
                                Bill temp = billList.get(i);
                                billList.set(i, billList.get(j));
                                billList.set(j, temp);
                            }
                        }
                    }
                    fileController.UpdateBillFile(billList, "Bill.DAT");
                    System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                    billList.forEach(bill -> bill.outputBill());
                    break;
                case 4:
                    Collections.sort(billList, new SortBillByDate());
                    fileController.UpdateBillFile(billList, "Bill.DAT");
                    System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                    billList.forEach(bill -> bill.outputBill());
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static void changeCustomer(long id) {
        do {
            System.out.println();
            System.out.println("*--------- Thay đổi ---------*");
            System.out.println("|      1. Tên                |");
            System.out.println("|      2. Tuổi               |");
            System.out.println("|      3. Giới tính          |");
            System.out.println("|      4. Địa chỉ            |");
            System.out.println("|      5. Số điện thoại      |");
            System.out.println("|      0. Quay lại           |");
            System.out.println("|____________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    for (int i = 0; i < customerList.size(); i++) {
                        if (customerList.get(i).getCustomerId() == id) {
                            System.out.print("Nhập tên: ");
                            String customerName = sc.nextLine();
                            customerList.get(i).setCustomerName(customerName);
                            fileController.UpdateCustomerFile(customerList, "Customer.DAT");
                            System.out.println("Thay đổi thông tin thành công!");
                        }
                    }
                    break;
                case 2:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    for (int i = 0; i < customerList.size(); i++) {
                        if (customerList.get(i).getCustomerId() == id) {
                            System.out.print("Nhập tuổi: ");
                            int customerAge = sc.nextInt();
                            customerList.get(i).setCustomerAge(customerAge);
                            fileController.UpdateCustomerFile(customerList, "Customer.DAT");
                            System.out.println("Thay đổi thông tin thành công!");
                        }
                    }
                    break;
                case 3:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    for (int i = 0; i < customerList.size(); i++) {
                        if (customerList.get(i).getCustomerId() == id) {
                            System.out.print("Nhập giới tính: ");
                            String customerGender = sc.nextLine();
                            customerList.get(i).setCustomerGender(customerGender);
                            fileController.UpdateCustomerFile(customerList, "Customer.DAT");
                            System.out.println("Thay đổi thông tin thành công!");
                        }
                    }
                    break;
                case 4:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    for (int i = 0; i < customerList.size(); i++) {
                        if (customerList.get(i).getCustomerId() == id) {
                            System.out.print("Nhập địa chỉ: ");
                            String customerAddress = sc.nextLine();
                            customerList.get(i).setCustomerAddress(customerAddress);
                            fileController.UpdateCustomerFile(customerList, "Customer.DAT");
                            System.out.println("Thay đổi thông tin thành công!");
                        }
                    }
                    break;
                case 5:
                    customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                    for (int i = 0; i < customerList.size(); i++) {
                        if (customerList.get(i).getCustomerId() == id) {
                            System.out.print("Nhập số điện thoại: ");
                            String customerPhone = sc.nextLine();
                            customerList.get(i).setCustomerPhone(customerPhone);
                            fileController.UpdateCustomerFile(customerList, "Customer.DAT");
                            System.out.println("Thay đổi thông tin thành công!");
                        }
                    }
                    break;
                case 0:
                    return;
            }
        } while (true);
    }

    private static void accCustomer() {
        int choice;
        while (true) {
            System.out.println();
            System.out.println("*----------- Tài Khoản -----------*");
            System.out.println("|        1. Tạo tài khoản         |");
            System.out.println("|        2. Đăng nhập             |");
            System.out.println("|        0. Thoát                 |");
            System.out.println("|_________________________________|");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    createAccount("AccountCustomer.DAT");
                    break;
                case 2:
                    loginCustomer();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chọn sai chức năng!");
                    accAdmin();
            }
        }
    }

    private static void loginCustomer() {
        accountList = fileController.ReadAccountFromFile("AccountCustomer.DAT");
        String username, password;
        System.out.print("Nhập username: ");
        username = sc.nextLine();
        System.out.print("Nhập password: ");
        password = sc.nextLine();
        if (checkExistAccount(username,password)) {
            Account account = new Account();
            for (int i = 0; i < accountList.size(); i++) {
                if(accountList.get(i).getUsername().compareTo(username) == 0){
                    account = accountList.get(i);
                }
            }
            do {
                System.out.println();
                System.out.println("*--------------- Chức năng ---------------*");
                System.out.println("|   1. Xem danh sách Pet trong cửa hàng   |");
                System.out.println("|   2. Mua Pet trong cửa hàng             |");
                System.out.println("|   3. Tìm kiếm Pet                       |");
                System.out.println("|   4. Xem hóa đơn                        |");
                System.out.println("|   5. Thông tin cá nhân                  |");
                System.out.println("|   6. Thay đổi thông tin cá nhân         |");
                System.out.println("|   7. Thông tin tài khoản                |");
                System.out.println("|   8. Thay đổi thông tin tài khoản       |");
                System.out.println("|   0. Quay lại                           |");
                System.out.println("|_________________________________________|");
                System.out.print("Chọn chức năng: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        petList = fileController.ReadPetFromFile("PetStore.DAT");
                        System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "petId", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                        petList.forEach(pet -> pet.outputPet());
                        break;
                    case 2:
                        petList = fileController.ReadPetFromFile("PetStore.DAT");
                        System.out.printf("%-10s %-30s %-10s %-10s %-20s %-20s %-20s \n", "petId", "petName", "species", "petGender", "petAge", "featherColor", "petPrice");
                        petList.forEach(pet -> pet.outputPet());
                        buyPet(account);
                        break;
                    case 3:
                        searchPet();
                        break;
                    case 4:
                        billList = fileController.ReadBillFromFile("Bill.DAT");
                        int dem = 0;
                        System.out.printf("%-10s %-10s %-10s %-20s %-20s \n", "billId", "customerId", "petId", "totalMoney", "dateOfPurchase");
                        for (int i = 0; i < billList.size(); i++) {
                            if (billList.get(i).getCustomerId() == checkCusAccId(account)) {
                                billList.get(i).outputBill();
                                dem++;
                            }
                        }
                        if (dem == 0) {
                            System.out.println("Khách hàng chưa mua hàng!");
                        }
                        break;
                    case 5:
                        customerList = fileController.ReadCustomerFromFile("Customer.DAT");
                        if (checkExistCusAccId(account)) {
                            for (int i = 0;i < customerList.size(); i++) {
                                System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "customerId", "customerName", "customerAge", "customerGender", "customerAddress", "customerPhone");
                                if (customerList.get(i).getCustomerId() == checkCusAccId(account)) {
                                    customerList.get(i).outputCustomer();
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Chưa có thông tin cá nhân!");
                            System.out.println("1. Cập nhật thông tin");
                            System.out.println("0. Quay lại");
                            System.out.print("Chọn chức năng: ");
                            int upd = sc.nextInt();
                            switch (upd) {
                                case 1:
                                    System.out.println("*---- Cập nhật thông tin ----*");
                                    long customerId = autoInputCustomerId();
                                    sc.nextLine();
                                    System.out.print("Nhập tên: ");
                                    String customerName = sc.nextLine();
                                    System.out.print("Nhập tuổi: ");
                                    int customerAge = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Nhập giới tính: ");
                                    String customerGender = sc.nextLine();
                                    System.out.print("Nhập địa chỉ: ");
                                    String customerAddress = sc.nextLine();
                                    System.out.print("Nhập số điện thoại: ");
                                    String customerPhone = sc.nextLine();

                                    Customer customer = new Customer(customerId, customerName, customerAge, customerGender, customerAddress, customerPhone);
                                    fileController.WriteCustomerToFile("Customer.DAT", customer);

                                    CustomerAccountManage customerAccountManage = new CustomerAccountManage(account.getId(), customerId);
                                    fileController.WriteCusAccToFile("CusAcc.DAT", customerAccountManage);
                                    System.out.println("Cập nhật thông tin thành công!");
                                    break;
                                case 0:
                                    return;
                            }
                        }
                        break;
                    case 6:
                        changeCustomer(checkCusAccId(account));
                        break;
                    case 7:
                        System.out.printf("%-10s %-30s %-20s %-20s %-20s %-20s \n", "id", "fullName", "username", "email", "phone", "createAt");
                        account.outputAccount();
                        break;
                    case 8:
                        changeAccount(account,"AccountCustomer.DAT");
                        break;
                    case 0:
                        return;
                }
            } while (true);
        } else {
            System.out.println("Tài khoản hoặc mật khẩu không tồn tại!");
        }
    }

    private static void buyPet(Account account) {
        do {
            System.out.println();
            System.out.println("*---------- Tài khoản khách hàng ----------*");
            System.out.println("|     1. Đã có thông tin khách hàng        |");
            System.out.println("|     2. Chưa có thông tin khách hàng      |");
            System.out.println("|     0. Quay lại                          |");
            System.out.println("|__________________________________________|");
            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    if (checkExistCusAccId(account)) {
                        long billId = autoInputBillId();
                        long customerId = checkCusAccId(account);
                        // Xóa Pet trong file PetStore, Thêm Pet vào file PetBill.DAT
                        System.out.print("Nhập id pet: ");
                        long petId = readOldIdPet();
                        petList = fileController.ReadPetFromFile("PetStore.DAT");
                        long totalMoney = 0;
                        for (int i = 0; i < petList.size(); i++) {
                            if (petList.get(i).getPetId() == petId) {
                                Pet pet = new Pet(petList.get(i).getPetId(), petList.get(i).getPetName(),
                                        petList.get(i).getSpecies(), petList.get(i).getPetGender(),
                                        petList.get(i).getPetAge(), petList.get(i).getFeatherColor(),
                                        petList.get(i).getPetPrice());
                                totalMoney = petList.get(i).getPetPrice();
                                fileController.WritePetToFile("PetBill.DAT", pet);
                                petList.remove(i);
                            }
                        }
                        fileController.UpdatePetFile(petList,"PetStore.DAT");

                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String dateOfPurchase = simpleDateFormat.format(date);

                        Bill bill = new Bill(billId, customerId, petId, totalMoney, dateOfPurchase);
                        fileController.WriteBillToFile("Bill.DAT", bill);

                        System.out.println("Tạo hóa đơn thành công!");
                        break;
                    } else {
                        System.out.println("Tài khoản chưa có thông tin khách hàng");
                        break;
                    }
                }
                case 2: {
                    if (!checkExistCusAccId(account)) {
                        System.out.println("*---- Nhập thông tin khách hàng ----*");
                        long customerId = autoInputCustomerId();
                        System.out.print("Nhập tên khách hàng: ");
                        String customerName = sc.nextLine();
                        System.out.print("Nhập tuổi khách hàng: ");
                        int customerAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nhập giới tính khách hàng: ");
                        String customerGender = sc.nextLine();
                        System.out.print("Nhập địa chỉ khách hàng: ");
                        String customerAddress = sc.nextLine();
                        System.out.print("Nhập số điện thoại: ");
                        String customerPhone = sc.nextLine();

                        Customer customer = new Customer(customerId, customerName, customerAge, customerGender, customerAddress, customerPhone);
                        fileController.WriteCustomerToFile("Customer.DAT", customer);
                        System.out.println("Thêm khách hàng vào danh sách thành công!");

                        long billId = autoInputBillId();

                        // Xóa Pet trong file PetStore, Thêm Pet vào file PetBill.DAT
                        System.out.print("Nhập id pet: ");
                        long petId = readOldIdPet();
                        petList = fileController.ReadPetFromFile("PetStore.DAT");
                        long totalMoney = 0;
                        for (int i = 0; i < petList.size(); i++) {
                            if (petList.get(i).getPetId() == petId) {
                                Pet pet = new Pet(petList.get(i).getPetId(), petList.get(i).getPetName(),
                                        petList.get(i).getSpecies(), petList.get(i).getPetGender(),
                                        petList.get(i).getPetAge(), petList.get(i).getFeatherColor(),
                                        petList.get(i).getPetPrice());
                                totalMoney = petList.get(i).getPetPrice();
                                fileController.WritePetToFile("PetBill.DAT", pet);
                                petList.remove(i);
                            }
                        }
                        fileController.UpdatePetFile(petList,"PetStore.DAT");

                        Date date = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String dateOfPurchase = simpleDateFormat.format(date);

                        Bill bill = new Bill(billId, customerId, petId, totalMoney, dateOfPurchase);
                        fileController.WriteBillToFile("Bill.DAT", bill);

                        CustomerAccountManage customerAccountManage = new CustomerAccountManage(account.getId() ,customerId);
                        fileController.WriteCusAccToFile("CusAcc.DAT", customerAccountManage);

                        System.out.println("Tạo hóa đơn thành công!");
                        break;
                    } else {
                        System.out.println("Tài khoản đã có thông tin khách hàng!");
                        break;
                    }
                }
                case 0:
                    return;
            }
        } while (true);
    }

    private static long autoInputAccountId(String fileName) {
        accountList = fileController.ReadAccountFromFile(fileName);
        Account maxId = accountList.stream()
                .max(Comparator.comparing(Account::getId))
                .get();
        return maxId.getId() + 1;
    }

    private static long autoInputBillId() {
        billList = fileController.ReadBillFromFile("Bill.DAT");
        Bill maxId = billList.stream()
                .max(Comparator.comparing(Bill::getBillId))
                .get();
        return maxId.getBillId() + 1;
    }

    private static long autoInputCustomerId() {
        customerList = fileController.ReadCustomerFromFile("Customer.DAT");
        Customer maxId = customerList.stream()
                .max(Comparator.comparing(Customer::getCustomerId))
                .get();
        return maxId.getCustomerId() + 1;
    }

    private static long autoInputPetId() {
        List<Pet> petList1 = new ArrayList<>();
        List<Pet> petList2 = new ArrayList<>();
        petList1 = fileController.ReadPetFromFile("PetStore.DAT");
        petList2 = fileController.ReadPetFromFile("PetBill.DAT");
        Pet maxId1 = petList1.stream()
                .max(Comparator.comparing(Pet::getPetId))
                .get();
        Pet maxId2 = petList2.stream()
                .max(Comparator.comparing(Pet::getPetId))
                .get();
        if (maxId1.getPetId() > maxId2.getPetId()) {
            return maxId1.getPetId() + 1;
        } else {
            return maxId2.getPetId() + 1;
        }
    }

    private static boolean checkExistCusAccId(Account account) {
        customerAccountManageList = fileController.ReadCusAccFromFile("CusAcc.DAT");
        for (int i = 0; i < customerAccountManageList.size(); i++) {
            if (customerAccountManageList.get(i).getAccountId() == account.getId()) {
                return true;
            }
        }
        return false;
    }

    private static long checkCusAccId(Account account) {
        customerAccountManageList = fileController.ReadCusAccFromFile("CusAcc.DAT");
        for (int i = 0; i < customerAccountManageList.size(); i++) {
            if (customerAccountManageList.get(i).getAccountId() == account.getId()) {
                return customerAccountManageList.get(i).getCustomerId();
            }
        }
        return 0;
    }
}