public class SavingsAccount extends Account {
private final double minBalance = 10.00;
private final double withdrawalFee = 3.0;
private double interest;
// Constructor
    SavingsAccount(String id, double initialDeposit){
        super(id, initialDeposit);
        // If the initial deposit is equal or greater than 1000.00, credit account with an extra 10.00
        if (initialDeposit >= 1000){
            System.out.println("Because your initial deposit met our reward threshold, an extra 10.00 has been credited to your account.");
            deposit(10.00);

        }
        


    }

    // This function will deduct the amount from the balance
    public boolean withdraw(double amount) {
        if (balance - amount - withdrawalFee < minBalance){
            //if balance drops below zero
            System.out.println("Sorry, but you have insufficient funds to make this withdrawal");
            return false;

        } else {
            balance = balance - amount - withdrawalFee;
            System.out.println("You have withdrawn £" + amount + "0. Your new balance is £" + balance +"0.");
            return true;
        }
    }

    // This function will add the amount to the account balance
    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("You have deposited £" + amount + "0. Your new balance is £" + balance +"0.");
    }


    public double addInterest(double rate){
        // calculate interest based on given rate and account balance
        interest = balance * rate/100;
        // adds interest to balance
        balance += interest;
        return interest;
    }



}
