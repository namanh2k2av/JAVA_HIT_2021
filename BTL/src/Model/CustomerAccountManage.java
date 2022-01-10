package Model;

public class CustomerAccountManage {
    private long accountId;
    private long customerId;

    public CustomerAccountManage() {
    }

    public CustomerAccountManage(long accountId, long customerId) {
        this.accountId = accountId;
        this.customerId = customerId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
