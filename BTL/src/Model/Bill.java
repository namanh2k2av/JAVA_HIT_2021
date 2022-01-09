package Model;

public class Bill{
    private long billId;
    private long customerId;
    private long petId;
    private long totalMoney;
    private String dateOfPurchase;

    public Bill() {
    }

    public Bill(long billId, long customerId, long petId, long totalMoney, String dateOfPurchase) {
        this.billId = billId;
        this.customerId = customerId;
        this.petId = petId;
        this.totalMoney = totalMoney;
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

    public long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(long totalMoney) {
        this.totalMoney = totalMoney;
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
                ", totalMoney=" + totalMoney +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +
                '}';
    }
}
