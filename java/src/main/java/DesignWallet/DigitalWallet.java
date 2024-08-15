package DesignWallet;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DigitalWallet {
    private Map<String,AccountDetails> digitalWallet;
    private Map<String, PaymentDetails>paymentDetailsMap;

    public DigitalWallet(){
        this.digitalWallet = new HashMap<>();
        this.paymentDetailsMap = new HashMap<>();
    }


    public void createDigitalWallet(AccountDetails accountDetails) {
        digitalWallet.put(accountDetails.getUserId(), accountDetails);
        System.out.println("Your Account SuccessFully Created");
    }

    public void checkAllAccountsDetails() {
        if(digitalWallet.isEmpty()){
            System.out.println("there is no account in digital wallet");
            return;
        }
        for(Map.Entry<String, AccountDetails>account: digitalWallet.entrySet())
        {
            System.out.println("UserId is "+account.getKey()+ "accountId is " + account.getValue().getAccountId() + "balance is "+ account.getValue().getTotalAmount());
        }
    }

    public void accountStatementForUser(String userName) {
        if(!digitalWallet.containsKey(userName)) {
            System.out.println("User does not exist"+userName);
            return;
        }
        AccountDetails accountDetails = digitalWallet.get(userName);
        System.out.println("user Account Details");
        System.out.println("userName is "+accountDetails.getUserId() +"accountId is "+ accountDetails.getAccountId() + "amount is " + accountDetails.getTotalAmount());
    }

    public void transferMoney(Double amount, String receiver, String sender) {
        AccountDetails senderAccount = digitalWallet.get(sender);
        AccountDetails receiverAccounts = digitalWallet.get(receiver);
        checkBalanceAndAddOffer(senderAccount, receiverAccounts , amount);
        senderAccount.setTotalAmount(senderAccount.getTotalAmount() - amount);
        receiverAccounts.setTotalAmount(receiverAccounts.getTotalAmount() + amount);
        addPaymentsDetails(amount, sender, receiver);

    }

    public void addPaymentsDetails(Double amount, String receiver, String sender) {
        Random random = new Random();
        String paymentId= random.toString();
        PaymentDetails paymentDetailsForSender = new PaymentDetails(paymentId, amount, sender, receiver,true, false);
        PaymentDetails paymentDetailsForReceiver = new PaymentDetails(paymentId, amount, sender, receiver,false, true);

        paymentDetailsMap.put(sender, paymentDetailsForSender);
        paymentDetailsMap.put(receiver, paymentDetailsForReceiver);
    }

    public void paymentHistory(String userName){
        if(!paymentDetailsMap.containsKey(userName)){
            System.out.println("User does not Exist");
            return;
        }
        for(Map.Entry<String, PaymentDetails>payment: paymentDetailsMap.entrySet()){
            System.out.println("paymentId "+payment.getValue().getPaymentId() + "receive "+payment.getValue().isReceive() + "amount "+payment.getValue().getTransferAmount());
        }
    }
    public void checkBalanceAndAddOffer(AccountDetails sender, AccountDetails receiver, Double sendingAmount) {
        if(sender.getTotalAmount() == 0.0 ) {
            throw new RuntimeException("Your Account Balance is zero");
        }
        if(sender.getTotalAmount() - sendingAmount <0.0) {
            throw new RuntimeException("you have inSufficient Balance");
        }
        if(sendingAmount <0.0001){
            throw new RuntimeException("smallest amount can be transfered is 0.0001");
        }
        if (sender.getTotalAmount().equals(receiver.getTotalAmount()))
        {
            sender.setTotalAmount(sender.getTotalAmount() + 10);
            receiver.setTotalAmount(receiver.getTotalAmount() + 10);
        }

    }

    public void existSystem(){
        System.out.println("exit");
    }
}
