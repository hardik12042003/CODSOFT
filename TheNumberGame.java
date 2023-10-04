import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRoundsWon = 0;

        System.out.println("Welcome to the Guess the Number game!");

        while (playAgain) {
            int lowerRange = 1;
            int upperRange = 100;
            int numberToGuess = random.nextInt(upperRange - lowerRange + 1) + lowerRange;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Enter a number between " + lowerRange + " and " + upperRange + ".");

            int maxAttempts = 5; // Set the maximum number of attempts to 5.

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number " + numberToGuess +
                            " in " + attempts + " attempts.");
                    correctGuess = true;
                    totalRoundsWon++;
                    totalAttempts += attempts;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        if (totalRoundsWon > 0) {
            double averageAttempts = (double) totalAttempts / totalRoundsWon;
            System.out.println("You won " + totalRoundsWon + " rounds with an average of " + averageAttempts + " attempts.");
        }

        System.out.println("Thanks for playing!");
    }
}

