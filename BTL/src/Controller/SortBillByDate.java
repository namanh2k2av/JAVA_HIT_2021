package Controller;

import Model.Bill;

import java.util.Comparator;

public class SortBillByDate implements Comparator<Bill> {
    @Override
    public int compare(Bill o1, Bill o2) {
        return o1.getDateOfPurchase().compareTo(o2.getDateOfPurchase());
    }
}
