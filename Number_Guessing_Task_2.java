import java.util.Scanner;
import java.util.Random;
// Creating the class called Guessgame
class Guessgame
{
    int sysInput;
    int userInput;
    int totalguesses= 0;
    // generating the random number
    Guessgame()
    {
        Random random = new Random();
        this.sysInput = random.nextInt(100) + 1;
    }
    // method to take user guesses
    public boolean takeUserInput() {
        if ( totalguesses < 10 ) {
            System.out.print("Guess the number : ");
            this.userInput = Number_Guessing_Task_2.takelimitInteger(100);
            totalguesses++;
            return false;
        }
        else {
            System.out.println("Number of attempts got ended...Good luck for next time\n");
            return true;
        }
    }
    //method to check user guess status
    public boolean Guesschecker() {
        if ( sysInput == userInput ) {
            System.out.println("Congratulations! you guessed the number correctly " + sysInput +
                    " in " + totalguesses + " guesses");
            switch(totalguesses) {
                case 1:
                    System.out.println("Your score is 100");
                    break;
                case 2:
                    System.out.println("Your score is 90");
                    break;
                case 3:
                    System.out.println("Your score is 80");
                    break;
                case 4:
                    System.out.println("Your score is 70");
                    break;
                case 5:
                    System.out.println("Your score is 60");
                    break;
                case 6:
                    System.out.println("Your score is 50");
                    break;
                case 7:
                    System.out.println("Your score is 40");
                    break;
                case 8:
                    System.out.println("Your score is 30");
                    break;
                case 9:
                    System.out.println("Your score is 20");
                    break;
                case 10:
                    System.out.println("Your score is 10");
                    break;
                default:
                    System.out.println("Oops! Better luck next time...");
            }
            System.out.println();
            return true;
        }
        else if ( totalguesses < 10 && userInput > sysInput ) {
            if ( (userInput - sysInput) > 10 ) {
                System.out.println("Your input is TOO HIGH");
            }
            else {
                System.out.println("Your input is LITTLE HIGH");
            }
        }
        else if ( totalguesses < 10 && userInput < sysInput ) {
            if ( (sysInput - userInput) > 10 ) {
                System.out.println("Your input is TOO LOW ");
            }
            else {
                System.out.println("Your input is LITTLE LOW");
            }
        }
        return false;
    }
}
// main class
public class Number_Guessing_Task_2 {
    // static method to take integer input without any limit and exception error
    // exception handling and input limit handling
    public static int takelimitInteger(int limit) {
      
 
        int input = 0;
        boolean flag = false;
        while ( !flag ) {
            try {
                Scanner sc = new Scanner(System.in);
                    input = sc.nextInt();
                
                flag = true;
                if ( flag && input > limit || input < 1 ) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e ) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        };
        return input;
    }
    // main method
    public static void main(String[] args) {
        

        System.out.println("Do you want to play a Number Guessing Game?");
        System.out.println("\n1. Press 1 for playing Game. \n2. Press 2 for Exit");
        System.out.print("\nEnter your choice here: \n\t");
        int choice = takelimitInteger(2);
        int nextRound = 1;
        int noOfRound = 0;
        if ( choice == 1 ) {
            // To confirm to go to next round
            while ( nextRound == 1 ) {
                // creating object of Game class
                Guessgame game = new Guessgame();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++noOfRound + " starts, Best of luck");
                // to check correct guess and limit cross
                while ( !isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.Guesschecker();
                }
                // input for next round
                System.out.println("1. Press 1 for Next Round \n2. For Exit");
                System.out.println("Enter your choice here : ");
                nextRound = takelimitInteger(2);
                if ( nextRound != 1 ) {
                    System.exit(0);
                }
            }
        }
        else {
            System.exit(0);
        }
    }
} 