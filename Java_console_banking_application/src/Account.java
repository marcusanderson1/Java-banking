public abstract class Account {

    protected String id;
    protected Double balance;

    public Account(String id, double balance){
        this.id = id;
        this.balance = balance;
    }


    public String getID(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public String toString(){
        return "Account: " + id + ", Balance: " + balance;
    }

    public abstract boolean withdraw(double amount);

    public abstract void deposit(double amount);


//    public abstract double addInterest(double savingsInterestRate);
}
