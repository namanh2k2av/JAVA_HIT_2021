package Model;

public class Customer {
    private long customerId;
    private String customerName;
    private int customerAge;
    private String customerGender;
    private String customerAddress;
    private String customerPhone;

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

    public void outputCustomer() {
        System.out.printf("%-10d %-30s %-20d %-20s %-20s %-20s \n", customerId, customerName, customerAge, customerGender, customerAddress, customerPhone);
    }
}
