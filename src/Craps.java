import java.util.Scanner;
import java.util.Random;
public class Craps {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Random rng = new Random();
        String play = "Y";
        String trash = "";
        System.out.println("Ready to play?[Y/N]: ");

        trash = in.nextLine();
        if (trash.equalsIgnoreCase("y")) {
            play = trash;
        }
        else if (trash.equalsIgnoreCase("N")) {
            System.out.println("Good bye!");
            return;
        }
        else {
            System.out.println("Error: Terminating\nPlease try again.");
            return;
        }

        while (play.equalsIgnoreCase("y")) {
            int die1 = rng.nextInt(6) + 1;
            int die2 = rng.nextInt(6) + 1;
            int crapsRoll = die1 + die2;
            System.out.printf("You rolled: %d and %d totalling(%d)\n", die1, die2, crapsRoll);

            if ((crapsRoll == 2) || (crapsRoll == 3) || (crapsRoll == 12)) {
                System.out.printf("Game Over, you crapped out on the first turn with a roll of: %d\n", crapsRoll);
                System.out.println("Play again?[Y/N]: ");
                play = in.nextLine();
            } else if ((crapsRoll == 7) || (crapsRoll == 11)) {
                System.out.println("You Win! You got a natural roll of: " + crapsRoll);
                System.out.println("Play again?[Y/N]: ");
                play = in.nextLine();
            } else {
                System.out.println("The target point is now: " + crapsRoll);
                int crapsRoll1 = crapsRoll;
                while ((crapsRoll != 7)) {
                    die1 = rng.nextInt(6) + 1;
                    die2 = rng.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.printf("You rolled: %d and %d totalling(%d)\n", die1, die2, crapsRoll);
                    if (crapsRoll == crapsRoll1) {
                        System.out.println("You win! You made point with a roll of: " + crapsRoll);
                        break;
                    }
                    else if (crapsRoll == 7){
                        System.out.println("Game Over, you lose with a roll of: " + crapsRoll);
                        break;
                    }
                    else {
                        System.out.println("You rolled: " + crapsRoll + " Rolling again...");
                    }
                }
                System.out.println("Play again?[Y/N]: ");
                trash = in.nextLine();

                if (trash.equalsIgnoreCase("Y")) {
                    play = trash;
                }
                else if (trash.equalsIgnoreCase("N")) {
                    System.out.println("Good bye!");
                    return;
                }
                else {
                    System.out.println("Error: Terminating\nPlease try again.");
                    return;
                }
            }
        }
    }
}