import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(12345, 67890);
                data.put(10293, 81723);

                System.out.println("----------------------------------------Welcome to the ATM!----------------------------------------");
                System.out.print("Enter your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter your PIN: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\nInvalid Character(s). Only Numbers.\n");
                menuInput.nextLine(); // clear buffer
                continue;
            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
                x = 2;
            } else {
                System.out.println("Wrong Customer Number or PIN. Please try again.\n");
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Select the Account you want to access:");
        System.out.println("1. Checking Account.");
        System.out.println("2. Savings Account.");
        System.out.println("3. Exit.");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSavings();
                break;
            case 3:
                System.out.println("Thank you for using our ATM!\n");
                break;
            default:
                System.out.println("\nInvalid selection. Please try again.\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Checking Account: ");
        System.out.println("1. View Balance.");
        System.out.println("2. Withdraw Funds.");
        System.out.println("3. Deposit Funds.");
        System.out.println("4. Exit.");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using our ATM!\n");
                break;
            default:
                System.out.println("\nInvalid selection. Please try again.\n");
                getChecking();
        }
    }

    public void getSavings() {
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Savings Account: ");
        System.out.println("1. View Balance.");
        System.out.println("2. Withdraw Funds.");
        System.out.println("3. Deposit Funds.");
        System.out.println("4. Exit.");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;
            case 2:
                getSavingsWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingsDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using our ATM!\n");
                break;
            default:
                System.out.println("\nInvalid selection. Please try again.\n");
                getSavings();
        }
    }
}
