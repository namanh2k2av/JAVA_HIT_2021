package Model;

import java.util.ArrayList;
import java.util.List;

public class Bill{
    private long billId;
    private String dateOfPurchase;
    private long petId;

    public Bill() {
    }

    public Bill(long billId, String dateOfPurchase, long petId) {
        this.billId = billId;
        this.dateOfPurchase = dateOfPurchase;
        this.petId = petId;
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

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                ", petId=" + petId +
                '}';
    }
}
