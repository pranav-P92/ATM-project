import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private float balance;
     private double depositAmount;
     private double withdrawAmount;
     static float amount;
     //int login;
    
    public static void main(String[] args) {
            ATM atm=new ATM();
        int atmnumber=12345;
        int atmpin=1234;
    
        
        Scanner sc=new Scanner(System.in);
        System.out.println("------------Welcome------------");
        System.out.print("Please enter 5-digit ATM Number:");
        int atmNumber=sc.nextInt();
        System.out.print("Please enter 4-digit ATM Pin:");
        int atmPin=sc.nextInt();
        if ((atmnumber==atmNumber) && (atmpin==atmPin)){
            while (true){
                System.out.println("1.View balance");
                System.out.println("2.Deposit Money");
                System.out.println("3.Withdraw Money");
                System.out.println("4.Exit");
                System.out.println("Enter choice(1-4): ");
                int choice=sc.nextInt();
                if (choice==1){
                    atm.balance();
                    }
                 else if(choice==2){
                    System.out.print("Enter amount to deposit in the account "+atmNumber+": ");
                    amount=sc.nextFloat();
                    atm.depositAmount();
                    //System.out.println("Deposited Successfully");
                }
                else if(choice==3){
                    System.out.println("Enter amount to withdraw in the account:");
                    amount =sc.nextFloat();
                    atm.withdrawAmount();
                }
                else if(choice==4){
                
                        System.out.println("Thank you!");
                        break;
                }
                else{
                    System.out.println("Invalid input!.\n enter (1-4):");
                }
                }
            }
        else{
            System.out.println("Re-enter pin:");

        }
            }

    
     public float balance() {
        System.out.println("BALANCE: "+balance);
        return balance;
    }
     public float depositAmount(){
        
        balance+=amount;
        System.out.println("Deposited successfully");
        System.out.println("AVAILABLE BALANCE: "+balance);
        return balance;
    }
     public float withdrawAmount(){
        if (amount<500){
            System.out.println("Minimum withdrawal is 500.0");
        }
        else{
             if(amount%500==0){
                if(balance<amount){
                    System.out.println("Insufficient balance!");
                    return balance;
                }   
                else  if (amount<0){
                    System.out.println("Invalid input!");
                } 
                else{
                    balance-=amount;
                    System.out.println("Available balance: "+balance);
                    System.out.println("Withdrawal Successful");
                }
            }
            else{
                System.out.println("Enter multiples of 500!");
            }
        }
        return amount;
    }
    
    
}
