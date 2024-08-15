package DesignWallet;

public class PaymentDetails {
    private String paymentId;
    private Double transferAmount;
    private String senderId;
    private String receiverId;
    private boolean isReceive;
    private boolean isSender;

    public PaymentDetails(String paymentId, Double transferAmount, String senderId, String receiverId, boolean isReceive, boolean isSender) {
        this.paymentId = paymentId;
        this.transferAmount = transferAmount;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.isReceive = isReceive;
        this.isSender = isSender;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public boolean isReceive() {
        return isReceive;
    }

    public void setReceive(boolean receive) {
        isReceive = receive;
    }

    public boolean isSender() {
        return isSender;
    }

    public void setSender(boolean sender) {
        isSender = sender;
    }
}
