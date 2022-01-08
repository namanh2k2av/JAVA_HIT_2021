package Model;

public class Bill{
    private long billId;
    private long customerId;
    private long petId;
    private String dateOfPurchase;

    public Bill() {
    }

    public Bill(long billId, long customerId, long petId, String dateOfPurchase) {
        this.billId = billId;
        this.customerId = customerId;
        this.petId = petId;
        this.dateOfPurchase = dateOfPurchase;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", customerId=" + customerId +
                ", petId=" + petId +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                '}';
    }
}
