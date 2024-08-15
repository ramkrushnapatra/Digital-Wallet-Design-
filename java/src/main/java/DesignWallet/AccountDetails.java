package DesignWallet;

public class AccountDetails {
    private String accountId;
    private String userId;
    private Double totalAmount;

    public AccountDetails(String accountId, String userId, Double totalAmount) {
        this.accountId = accountId;
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
