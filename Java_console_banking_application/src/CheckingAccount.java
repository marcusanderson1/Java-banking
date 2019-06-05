public class CheckingAccount extends Account {
    private int numberOfChequesUsed; // Stores number of cheques used every month
    private final double fee = 1.00; // Stores transaction fee
    private final double checkFee = 2.00; // Stores the additional fee of 2.00 for transactions using cheques 
    private final double minimumATMBalance = 0; // Stores the minimum balance whilst using an ATM to perhaps make a withdrawal
    private final double minimumDeposit = 1; // Stores the minimum deposit
    private final double minimumChequeBalance = -10.00; // Stores the minimum balance for cheque transactions

    // Constructor function

    public CheckingAccount(String id, double initialBalance){
        super(id, initialBalance);
    }

    // Methods

    // ATM withdrawal
    public boolean withdraw(double amount) {
        // if the balacne minus fees drops below zero, then the withdrawal cannot happen
        if (balance - amount - fee < minimumATMBalance){
            System.out.println("You have insufficient funds to make this withdrawal");
            return false;
        } else {
        // Otherwise, the withdrawal will commence and the balance will now change.
            balance = balance - amount - fee;
//            System.out.println("Withdrawn " + amount +" from account " + id + ", your new balance is now £" + balance +"0.");
            return true;
        }
    }

    // ATM deposit
    public void deposit(double amount){
        if (amount >= minimumDeposit){
            balance += amount - fee;
//            System.out.println("You have deposited £" + amount + "0. Your new balance is £" + balance +"0.");
        } else {
            System.out.println("Sorry, the minimum ATM deposit is £1.00");
        }
    

    }
    // Resets number of cheques to zero
    public void resetChequesUsed(){
        numberOfChequesUsed = 0;
        System.out.println("Cheque usage reset, the number of cheques used is now "+ numberOfChequesUsed +".");

    }
    // Returns the numberOfChequesUsed
    public int getChequesUsed(){
        return this.numberOfChequesUsed;
    }

    public boolean withdrawUsingCheque(double amount){
        
        if(numberOfChequesUsed <= 3){
        // if you use 3 or below cheques in a month then you pay no fees    
            
            

            if (balance - amount < minimumChequeBalance){
                System.out.println("You have insufficient funds to make this withdrawal.");
                return false;
            } else {
                // withdrawal is successful and the balance is updated as a result
                balance = balance - amount;
                numberOfChequesUsed++;
                System.out.println("Cheque withdrawal of £" + amount + "0 Successful, the new balance is £" + balance + "0." );
                return true;
            }
        } else {
             if (balance - amount - fee - checkFee < minimumChequeBalance) {
                 // withdrawal cannot happen as balance falls below threshold.

                 System.out.println("You have insufficient funds to make this withdrawal.");
                 return false;

             } else {

                // the withdrawal is successful, resulting in  updating the balance

                    balance = balance - amount - checkFee;
                 // The number of checks used is also incremented
                    numberOfChequesUsed++;

                    System.out.println("Successfully withdrew " + amount + "!");

                    return true;
            }    
            }
    }

}

