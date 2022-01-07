package Controller;

import Model.Account;
import Model.Pet;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileController {
    public FileWriter fileWriter;
    public BufferedWriter bufferedWriter;
    public PrintWriter printWriter;
    public Scanner scanner;

    //File
    public Scanner getScanner(){
        return this.scanner;
    }

    public void OpenFileToWrite(String fileName){
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterWrite() {
        try {
            printWriter.close();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OpenFileToRead(String fileName) {
        try {
            scanner = new Scanner(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CloseFileAfterRead() {
        scanner.close();
    }

    //Account
    public void WriteAccountToFile(String fileName, Account acc) {
        OpenFileToWrite(fileName);
        printWriter.println(
                acc.getId() + "|" + acc.getFullName() + "|" + acc.getUsername() + "|" +
                acc.getPassword() + "|" + acc.getEmail() + "|" + acc.getPhone() + "|" +
                acc.getCreateAt()
        );
        CloseFileAfterWrite();
    }

    public Account CreateAccountFromData(String data) {
        String[] datas = data.split("\\|");
        Account acc = new Account(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
        return acc;
    }

    public List<Account> ReadAccountFromFile(String fileName) {
        OpenFileToRead(fileName);
        List<Account> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Account acc = CreateAccountFromData(data);
            list.add(acc);
        }
        CloseFileAfterRead();
        return list;
    }

    public void UpdateAccountFile(List<Account> list, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (Account acc : list) {
            printWriter.println(
                    acc.getId() + "|" + acc.getFullName() + "|" + acc.getUsername() + "|" +
                    acc.getPassword() + "|" + acc.getEmail() + "|" + acc.getPhone() + "|" +
                    acc.getCreateAt()
            );
        }
        CloseFileAfterWrite();
    }

    //Pet
    public void WritePetToFile(String fileName, Pet pet) {
        OpenFileToWrite(fileName);
        printWriter.println(
                pet.getPetId() + "|" + pet.getPetName() + "|" + pet.getSpecies() + "|" +
                pet.getPetGender() + "|" + pet.getPetAge() + "|" + pet.getFeatherColor() + "|" +
                pet.getPetPrice()
        );
        CloseFileAfterWrite();
    }

    public Pet CreatePetFromData(String data) {
        String[] datas = data.split("\\|");
        Pet pet = new Pet(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4], datas[5], Integer.parseInt(datas[6]));
        return pet;
    }

    public List<Pet> ReadPetFromFile(String fileName) {
        OpenFileToRead(fileName);
        List<Pet> petList = new ArrayList<>();
        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            Pet pet = CreatePetFromData(data);
            petList.add(pet);
        }
        CloseFileAfterRead();
        return petList;
    }

    public void UpdatePetFile(List<Pet> petList, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        OpenFileToWrite(fileName);
        for (Pet pet : petList) {
            printWriter.println(
                    pet.getPetId() + "|" + pet.getPetName() + "|" + pet.getSpecies() + "|" +
                    pet.getPetGender() + "|" + pet.getPetAge() + "|" + pet.getFeatherColor() + "|" +
                    pet.getPetPrice()
            );
        }
        CloseFileAfterWrite();
    }
}
