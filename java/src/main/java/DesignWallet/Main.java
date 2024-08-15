package DesignWallet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DigitalWallet digitalWallet = new DigitalWallet();
        AccountDetails user1 = new AccountDetails("account1","userId1",120.0);
        AccountDetails user2 = new AccountDetails("account2","userId2",120.0);
        digitalWallet.createDigitalWallet(user1);
        digitalWallet.createDigitalWallet(user2);
        digitalWallet.transferMoney(10.0,  user2.getUserId(), user1.getUserId());
        digitalWallet.accountStatementForUser(user1.getUserId());
        digitalWallet.accountStatementForUser(user2.getUserId());
        digitalWallet.checkAllAccountsDetails();
        digitalWallet.paymentHistory(user1.getUserId());
        digitalWallet.existSystem();
    }
}