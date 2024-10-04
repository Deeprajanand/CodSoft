import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static int playRound(int lowerBound, int upperBound, int maxAttempts) {
        Random random = new Random();
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Guess the number between " + lowerBound + " and " + upperBound);

        while (attempts < maxAttempts) {
            attempts++;
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int guess = sc.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                return attempts;
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }
           // sc.close();
        }

        System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber);
        return maxAttempts;
        
    }

    // Main game loop for multiple rounds
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
        int round = 0;
        int maxAttempts = 5;  
        int lowerBound = 1;
        int upperBound = 100;

        System.out.println("Welcome to the Guess the Number game!");

        while (true) {
            round++;
            System.out.println("\nRound " + round + ":");

            int attemptsUsed = playRound(lowerBound, upperBound, maxAttempts);
            totalScore += (maxAttempts - attemptsUsed); 

            System.out.println("Your total score so far: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thank you for playing! Your final score: " + totalScore);
        sc.close();
    }
}
