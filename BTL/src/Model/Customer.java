package Model;

public class Customer {
    protected long customerId;
    protected String customerName;
    protected int customerAge;
    protected String customerGender;
    protected String customerAddress;
    protected String customerPhone;

    public Customer() {
    }

    public Customer(long customerId, String customerName, int customerAge, String customerGender, String customerAddress, String customerPhone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerGender = customerGender;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", customerGender='" + customerGender + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                '}';
    }
}
