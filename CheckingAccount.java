//child class

public class CheckingAccount extends Account {

    //default transaction fee
    private static double FEE = 2.5;
    

    //default constructor
    public CheckingAccount() {
        super();
    }


    /**
     * Parameter constructor to initialize CheckingAccount
     * with a custom account number and a customer transaction fee
     * @param accountNumber
     * @param fee
     */
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
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

        //first check amount
        if(amount > 0) {
            balance += amount;
            System.out.printf("Amount deposited: %.2f%n", amount);

            //apply transaction fee
            balance -= FEE;
            System.out.printf("Transaction fee: %.2f%n", FEE);
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
        if(amount > 0) {
            //check sufficient balance
            if(amount + FEE <= balance) {
                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -= FEE;
                System.out.printf("Fee of %.2f applied to Account%n", FEE);
                System.out.printf("Current Balance is %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn");
        }
    }

}
