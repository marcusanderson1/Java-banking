public class BankTest {

    public static void main(String[] args){

        System.out.println("Account testing ------------------------------------------");

        SavingsAccount Saver = new SavingsAccount("65223", 1000.00);
        CheckingAccount Checking = new CheckingAccount("62234", 4000.00);

        System.out.println(" ");
        System.out.println("Withdrawal test 1..");
        Checking.withdraw(50.00);
        System.out.println("New balance is £ " + Checking.balance + "0.");
        System.out.println(" ");
        System.out.println("Withdrawal test 2..");
        Checking.withdraw(150.00);
        System.out.println("New balance is £ " + Checking.balance + "0.");
        System.out.println(" ");
        System.out.println("Withdrawal test 3 (large amount)..");
        Checking.withdraw(5000.00);
        System.out.println(" ");
        System.out.println("Withdrawal using check test 1 (large amount)..");
        Checking.withdrawUsingCheque(10000.00);
        System.out.println(" ");
        System.out.println("Withdrawal using check test 1..");
        Checking.withdrawUsingCheque(100);
        System.out.println(" ");
        System.out.println("Number of cheques used test 1..");
        System.out.println(Checking.getChequesUsed());
        System.out.println(" ");
        System.out.println("Withdrawal using check test 2..");
        Checking.withdrawUsingCheque(150);
        System.out.println(" ");
        System.out.println("Number of cheques used test 2..");
        System.out.println(Checking.getChequesUsed());
        System.out.println(" ");
        System.out.println("Withdrawal using check test 3..");
        Checking.withdrawUsingCheque(280);
        System.out.println(" ");
        System.out.println("Number of cheques used test 3..");
        System.out.println(Checking.getChequesUsed());
        System.out.println(" ");
        System.out.println("Withdrawal using check test 4..");
        Checking.withdrawUsingCheque(360);
        System.out.println(" ");
        System.out.println("Number of cheques used test 4..");
        System.out.println(Checking.getChequesUsed());
        Checking.resetChequesUsed();

        System.out.println("Incrementing cheques used for later testing..");
        Checking.withdrawUsingCheque(10);
        Checking.withdrawUsingCheque(10);
        Checking.withdrawUsingCheque(10);
        Checking.withdrawUsingCheque(10);

        System.out.println(" ");
        System.out.println("Saver withdraw test 1");
        Saver.withdraw(50.00);
        System.out.println(" ");
        System.out.println("Saver withdraw test 2");
        Saver.withdraw(10000.00);
        System.out.println(" ");
        System.out.println("Saver deposit test 1");
        Saver.deposit(4000.00);
        System.out.println(" ");
        System.out.println("Saver add interest test");
        System.out.println(Saver.getBalance());
        Saver.addInterest(25);
        System.out.println("Interest added");
        System.out.println(Saver.getBalance());

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Bank testing ------------------------------------------");
        Bank lloyds = new Bank();
        lloyds.addAccount(Saver);
        lloyds.addAccount(Checking);
        System.out.println("Added existing accounts to bank.");

        System.out.println(" ");
        System.out.println("getAccount test 1..");
        lloyds.getAccount("65223");
        lloyds.getAccount("65229");

        System.out.println(" ");
        System.out.println("Deposit test 1..");
        lloyds.deposit("65223", 2000.00);
        System.out.println("Deposit test 2..");
        lloyds.deposit("52443", 1000.00);

        System.out.println(" ");
        System.out.println("Withdrawal test 1..");
        lloyds.withdraw("65223", 1500.00);
        System.out.println("Withdrawal test 2..");
        lloyds.withdraw("52443", 400.00);


        System.out.println(" ");
        System.out.println("Transfer test (success)..");
        lloyds.transfer("65223", "62234", 1000.00);
        System.out.println(" ");
        System.out.println("Transfer test (fail)..");
        lloyds.transfer("62234", "49332", 10.00);

        System.out.println(" ");
        System.out.println("getAccount test..");
        System.out.println(lloyds.getAccount("65223"));


        System.out.println(" ");
        System.out.println("numOfAccounts test.. ");
        lloyds.numberOfAccounts();


        System.out.println(" ");
        System.out.println("Add interest test... ");
        System.out.println(lloyds.getAccount("65223").getBalance());
        System.out.println("Adding 33% interest gives a new balance of");
        lloyds.setSavingsInterest(33);
        lloyds.addInterest();
        System.out.println(lloyds.getAccount("65223").getBalance());


        System.out.println(" ");
        System.out.println("Reset cheque test... ");
        lloyds.getAccount("62234");
        lloyds.reset();
        Checking.getChequesUsed();



    }
}
