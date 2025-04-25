import java.util.Scanner;
import java.util.Random;

public class UserInterface{
    private Scanner scanner;
    private Random rand;
    private int attempts;
    private int num;
    private String difficulty;

    
    public UserInterface(Scanner scanner){
        this.scanner = scanner;
        this.rand = new Random();
        this.attempts = 0;
        this.difficulty = "";
        this.num = 0;
    }

    public void start(){
        System.out.println("\nWelcome to the Number Guessing Game.");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 5 chances to guess the correct number.");

        System.out.println("\nPlease select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");

        System.out.print("\nEnter your choice:");
        int diff = Integer.valueOf(scanner.nextLine());
        if (diff > 3 || diff < 1){
            System.out.println("Invalid input");
            return;
        }
        this.setDiff(diff);
        System.out.println("\nGreat! You have selected the " + this.difficulty + " difficulty level.");
        System.out.println("Let's start the game!");
        this.num = rand.nextInt(1,101);
        this.guess();
    }

    public void guess(){
        int attempt = 0;
        int guess = 0;
        boolean success = false;
        while (attempt < this.attempts){
            System.out.print("\nEnter your guess: ");
            guess = Integer.valueOf(scanner.nextLine());
            if (guess == this.num){
                success = true;
                break;
            } else {
                this.incorrect(guess);
            }
            attempt++;
        }

        if (success){
            System.out.println("Congratulations! You guessed the correct number in " + (attempt + 1) + " attempts.");
        } else {
            System.out.println("Failed! You ran out of attempts. The number is " + this.num);
        }
        this.end();
    }

    public void end( ){
        System.out.println("\nDo you want to play again? (Y/N)");
        String response = scanner.nextLine();
        if (response.equals("Y")){
            this.start();
        }
    }

    public void setDiff(int diff){
        if (diff == 1){
            this.attempts = 10;
            this.difficulty = "Easy";
        } else if (diff == 2){
            this.attempts = 5;
            this.difficulty = "Medium";
        } else if (diff == 3){
            this.attempts = 3;
            this.difficulty = "Hard";
        }
    }

    public void incorrect(int guess){
        if (guess > this.num){
            System.out.println("Incorrect! The number is less than " + guess);
        } else {
            System.out.println("Incorrect! The number is greater than " + guess);
        }
    }
}