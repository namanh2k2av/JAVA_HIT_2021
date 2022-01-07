package Controller;

import Model.Account;

import java.util.Comparator;

public class SortAccByFullname implements Comparator<Account> {
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
