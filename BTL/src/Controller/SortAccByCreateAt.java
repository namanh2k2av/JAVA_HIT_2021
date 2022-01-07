package Controller;

import Model.Account;

import java.util.Comparator;

public class SortAccByCreateAt implements Comparator<Account> {

    @Override
    public int compare(Account o1, Account o2) {
        return o1.getCreateAt().compareTo(o2.getCreateAt());
    }
}
