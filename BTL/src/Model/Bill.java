package Model;

import java.util.ArrayList;
import java.util.List;

public class Bill extends Customer{
    private long billId;
    private String dateOfPurchase;
    private List<Pet> pets = new ArrayList<>();

    public Bill() {
    }

    public Bill(long customerId, String customerName, int customerAge, String customerGender, String customerAddress, String customerPhone, long customerId1, String dateOfPurchase, List<Pet> pets) {
        super(customerId, customerName, customerAge, customerGender, customerAddress, customerPhone);
        this.customerId = customerId1;
        this.dateOfPurchase = dateOfPurchase;
        this.pets = pets;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", customerId=" + customerId +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", pets=" + pets +
                '}';
    }
}
