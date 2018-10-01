package pkg;

import java.util.Random;
import java.util.Scanner;

public class RyderGavinRockPaperScissors {
    private static int userChoice;
    private static int rounds;
    private static int AIchoice;
    private static int AIWin = 0;
    private static int playerWin = 0;
    private static Scanner in = new Scanner(System.in);

    private static int randomNumberInRange(int min, int max) { //generate a random int within a given int range
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static void AIMove() {
        AIchoice = randomNumberInRange(0, 2);
        //return AIchoice; //return move number.
    }

    private static String translateMove(int i) {
        if (i == 0) {
            return "Rock";
        } else if (i == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    private static boolean eval0() {
        boolean win;
        System.out.println("You chose: " + translateMove(userChoice));
        System.out.println("Computer chose: " + translateMove(AIchoice));
        if (AIchoice == 0) {
            System.out.println("Tie! Play again!");
            game();
        } else if (AIchoice == 1) {
            AIWin++;
            System.out.println("Computer wins this round! Computer has won " + AIWin + " rounds");
            win = false;
            return win;
        } else {
            playerWin++;
            System.out.println("You won this round! You've won " + playerWin + " rounds");

            win = true;
            return win;
        }
        return false;
    }

    private static boolean eval1() {
        boolean win;
        System.out.println("You chose: " + translateMove(userChoice));
        System.out.println("Computer chose: " + translateMove(AIchoice));
        if (AIchoice == 1) {
            System.out.println("Tie! Play again!");
            game();
        } else if (AIchoice == 2) {
            AIWin++;
            System.out.println("Computer wins this round! Computer has won " + AIWin + " rounds");
            win = false;
            return win;
        } else {
            playerWin++;
            System.out.println("You won this round! You've won " + playerWin + " rounds");
            win = true;
            return win;
        }
        return false;
    }

    private static boolean eval2() {
        boolean win;
        System.out.println("You chose: " + translateMove(userChoice));
        System.out.println("Computer chose: " + translateMove(AIchoice));
        if (AIchoice == 2) {
            System.out.println("Tie! Play again!");
            game();
        } else if (AIchoice == 0) {
            AIWin++;
            System.out.println("Computer wins this round! Computer has won " + AIWin + " rounds");
            win = false;
            return win;
        } else {
            playerWin++;
            System.out.println("You won this round! You've won " + playerWin + " rounds");
            win = true;
            return win;
        }
        return false;
    }

    private static void game() {
        while (playerWin < (rounds / 2 + 1) && AIWin < (rounds / 2 + 1)) {
            AIMove();
            System.out.println("");
            System.out.println("Enter your move. 0 for rock, 1 for paper, 2 for scissors");
            if (in.hasNextInt()) {
                userChoice = in.nextInt();
            } else {
                System.out.println("Invalid type!");
                in.nextLine(); //move to next line
                game();
            }
            if (userChoice != 0 && userChoice != 1 && userChoice != 2) {
                System.out.println("Not a valid input! Try again!");
                game();
            }
            switch (userChoice) { //will only run if input is valid, so use default for case 2
                case 0:
                    eval0();
                    break;
                case 1:
                    eval1();
                    break;
                default:
                    eval2();
                    break; //keep?
            }
        }
        if (playerWin >= (rounds / 2 + 1)) {
            System.out.println("***Game over! You won!***");
            System.exit(0);
        } else if (AIWin >= (rounds / 2 + 1)) {
            System.out.println("***Game over! Computer won!***");
            System.exit(0);
        } else {
            System.err.println("Error!!!");
            System.exit(1);
        }
    }

    private static void chooseRounds() {
        System.out.println("How many rounds would like to play?");
        rounds = 3;
        if (in.hasNextInt()) { //can also be done with a try catch
            rounds = in.nextInt();
            if (rounds <= 0) {
                System.out.println("Invalid input. Try again!");
                in.nextLine();
                chooseRounds();
            }
        } else {
            System.out.println("Invalid input! Try again!");
            in.nextLine(); //move to next line
            chooseRounds();

        }
    }

    public static void main(String[] args) {
        chooseRounds();
        game();
    }
}
