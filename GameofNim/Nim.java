import java.util.Scanner;
import java.security.SecureRandom;

class Function {
    SecureRandom marbles = new SecureRandom();
    int amount = marbles.nextInt(100) + 1;
    SecureRandom mode = new SecureRandom();
    int difficulty = mode.nextInt(2) + 1;// This determines the computer's difficulty
    void difficulty() {
        if(difficulty == 1) {
            System.out.println("The computer is easy.");
        } else {
            System.out.println("The computer is smart.");
        }
    }
    void strat() {
        SecureRandom comp = new SecureRandom();
        int compNum = comp.nextInt(50) + 1;
        while (difficulty == 1) {
            if (compNum > amount/2) {
                compNum = comp.nextInt(50) + 1;
            } else {
                System.out.println("The computer takes " + compNum + " marbles");
                amount = amount - compNum;
                System.out.println("There are now " + amount + " marbles.");
                break;
            }
        }
        if (difficulty != 1) {
            if (amount > 64) {
                System.out.println("The computer takes " + (amount - 63) + "marbles. ");
                amount = 63;
                System.out.println("There are now " + amount + "marbles. ");
            } else if (amount > 32) {
                System.out.println("The computer takes " + (amount - 31) + "marbles. ");
                amount = 31;
                System.out.println("There are now " + amount + "marbles. ");
            } else if (amount > 16) {
                System.out.println("The computer takes " + (amount - 15) + "marbles. ");
                amount = 15;
                System.out.println("There are now " + amount + "marbles. ");
            } else if (amount > 8) {
                System.out.println("The computer takes " + (amount - 7) + "marbles. ");
                amount = 7;
                System.out.println("There are now " + amount + "marbles. ");
            } else if (amount > 4) {
                System.out.println("The computer takes " + (amount - 3) + "marbles. ");
                amount = 3;
                System.out.println("There are now " + amount + "marbles. ");
            } else if (amount > 2) {
                System.out.println("The computer takes " + (amount - 1) + "marble. ");
                amount = 1;
                System.out.println("There is now " + amount + "marble. ");
            }
        }
    }
    void player() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of marbles you want to take: ");
        int number = sc.nextInt();
        amount = amount - number;
        System.out.println("You took " + number + " marbles. There are now " + amount + " marbles.");
    }
}
public class Nim {
    public static void main(String[] args) {
        boolean turn = true;
        Function f = new Function();
        f.difficulty();
        System.out.println("There are " + f.amount + " marbles.");
        while (f.amount >= 1) {
            f.player();
            turn = true;
            System.out.println("Turn is now true" + f.amount);
            f.strat();
            turn = false;
            System.out.println("Turn is now false" + f.amount);
            if (f.amount == 1) {
                if(turn == true) {
                    System.out.println("The player loses. Computer wins.");
                } else {
                    System.out.println("The Computer loses. You win!");
                }
                break;
            }
        }
    }
}
