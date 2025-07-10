import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 0;

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean isGuessed = false;

            System.out.println("\n Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between 1 and 100");
            round++;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (" + (maxAttempts - attempts) + " attempts left): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + attempts + " attempts.");
                    totalScore += (maxAttempts - attempts + 1); // Score logic: more points for fewer attempts
                    isGuessed = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!isGuessed) {
                System.out.println("You've used all your attempts! The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            sc.nextLine(); // Consume newline
            String choice = sc.nextLine().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! You played " + round + " round(s).");
        System.out.println("Total Score: " + totalScore);
        sc.close();
    }
}
