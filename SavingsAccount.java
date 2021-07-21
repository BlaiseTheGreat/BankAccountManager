//savings account child class
// has an interest rate
// a method to apply interest - profit

public class SavingsAccount extends Account{

    // private double interest rate
    private double interestRate;

    // default constructor
    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize SavingsAccount with a custom account
     * number and an interest rate
     * 
     */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }


    //getter function
    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n");
        deposit(interest);
    }

    // Abstract
    /**
     * Function to deposit funds into the account as long as the amount parameter is
     * > 0
     * 
     * Apply transaction fee for the checking account
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {

        // first check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Updated balance: %.2f%n", balance);
        } else {
            System.out.println("A negative amount can not be deposited");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as 1. amount ot withdraw
     * > 0 2 amount to withdraw <= balance
     * 
     * @param amount value to be withdrawn
     */

    public void withdraw(double amount) {
        if (amount > 0) {
            // check sufficient balance
            if (amount <= balance) {
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current Balance is %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }
}
