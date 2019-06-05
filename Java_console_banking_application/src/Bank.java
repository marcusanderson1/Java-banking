import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private double savingsInterestRate;

    // Constructor
    public Bank() {
        accounts = new ArrayList<Account>();
    }
    // Sets the interest rate in percentage format
    public void setSavingsInterest(double rate) {
        savingsInterestRate = rate;
    }
    // Returns the number of accounts which the bank contains
    public int numberOfAccounts() {
        System.out.println("This bank holds "+ accounts.size() + " accounts.");
        return accounts.size();
    }
    // Adds an account to the accounts Arraylist within the bank, hence adding an account to the bank.
    public void addAccount(Account ac) {
        accounts.add(ac);
    }


    // Returns the account object if a match can be found for the provided accountID
    public Account getAccount(String accountID) {
        for (Account ac : accounts){
            if (ac.getID().equals(accountID))
                return ac;
        }
        // if no account can be found that matches the ID then will retun null.
        return null;
    }

    // This method will search for the account ID
    public boolean deposit(String accountID, double amount) {
        Account search = getAccount(accountID);
        // if the account is not found, the function called returns null
        if (search == null){
            return false;
        } else {
        // if account can be found then we can make the deposit
            System.out.println("-------- Deposit ---------");
            search.deposit(amount);
            System.out.println("-------- Deposit Complete ---------");
            return true;    
        }

        // WORKS also but it is better to use functions to call other functions to save rewriting code
        // for (int i = 0; i < accounts.size(); i++) {
        //     if (accountID == accounts.get(i).getID()) {
        //         accounts.get(i).deposit(amount);
        //         System.out.println("-------- Deposit ---------");
        //         System.out.println("Account: " + accounts.get(i).getID() + " now has a balance of £" + accounts.get(i).getBalance() + "0.");
        //         System.out.println("-------- Deposit Complete ---------");
        //         return true;

        //     } else {
        //         System.out.println("Deposit failed.");

        //         return false;
        //     }
        // }
        // return false;
    }

    public boolean withdraw(String accountID, double amount){
        // Retireve account with given id
        Account search = getAccount(accountID);
        // If the account cannot be found
        if (search == null){
            System.out.println("Account not found.");
            return false;
        } else {
            // make the withdrawal from the account
            search.withdraw(amount);
            // Then return true
            return true;
        }
    }


    public boolean transfer(String fromAccountID, String toAccountID, double amount) {
        //conduct a search for both from and to accounts
        Account from = getAccount(fromAccountID);
        Account to = getAccount(toAccountID);
        // if both accounts are found
        if (from != null && to != null) {
            System.out.println("-------- Initiating Transfer ---------");
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("-------- Transfer Complete ---------");
            return true;

        } else {
            // if one or both accounts cannot be found
            System.out.println("Transfer between " + from +" and " + to+ " for "+amount +" failed.");
            return false;
        }
        // CAN USE COMMENTED CODE BUT I CAN SAVE MYSELF TIME BY USING THE FUNCTIONS I HAVE ALREADY CREATED RATHER THAN REWRITING CODE
        // for (int i = 0; i < accounts.size(); i++) {
        //     if (fromAccountID == accounts.get(i).getID()) {
        //         // Now i must implement a check to see whether there is enough available funds here
        //         accounts.get(i).withdraw(amount);
        //         for (int j = 0; j < accounts.size(); j++) {
        //             if (toAccountID == accounts.get(j).getID()) {
        //                 accounts.get(j).deposit(amount);
        //                 System.out.println("-------- Initiating Transfer ---------");
        //                 System.out.println("Transfer from account: " + fromAccountID + " to account: " + toAccountID + " for the sum of £" + amount +"0.");
        //                 System.out.println("The recipient, Account " + toAccountID + " now has a balance of £" + accounts.get(j).getBalance() + "0.");
        //                 System.out.println("-------- Transfer Complete ---------");

        //                 return true;
        //             }

        //         }
        //     }
        //     else {
        //         System.out.println("Transfer Denied.");

        //         }


        // }

        // return false;
    }
    // This function will iterate through the accounts ArrayList in search for Savings Accounts in which interest will be added to them based on the rate
   public void addInterest() {
      for (Account acnt : accounts){
        if (acnt instanceof SavingsAccount) {
            ((SavingsAccount)acnt).addInterest(savingsInterestRate);
        }
      } 
    }  
     // This function will iterate through the accounts ArrayList in search for Checking Accounts in which the number of cheques used will be reset to zero.
       
   public void reset(){
       for(Account acnt : accounts) {
        if (acnt instanceof CheckingAccount) {
            ((CheckingAccount)acnt).resetChequesUsed();
        }
       }
    }


}





