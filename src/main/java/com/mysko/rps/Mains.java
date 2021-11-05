package main.java.com.mysko.rps;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Mains {

    public static ArrayList<String> gameArray = new ArrayList<>();
    ;
    private static Scanner sc = new Scanner(System.in);
    private static int playerChoice;

    public static void main(String[] args) throws  NoSuchAlgorithmException, InvalidKeyException {
        try {
            if (args.length % 2 == 0 || args.length < 3) {
                System.out.println("Incorrect input! Number of moves should be odd and >= 3!");
                throw new InterruptedException();
            }
            if (!((new LinkedHashSet<>(Arrays.asList(args))).size() == args.length)) {
                System.out.println("Not all values are unique!");
                throw new InterruptedException();
            }
        } catch (InterruptedException e) {
            System.exit(0);
        }
        for (int i = 0; i < args.length; i++) {
            gameArray.add(args[i]);
        }

        while (true) {
            Computer comp = new Computer();
            comp.computerMove();

            showStart();
            if (playerChoice == 0) {
                System.out.println("You quit game.");
                System.exit(0);
            }
            if (playerChoice == -1) {
                Rules r = new Rules();
                r.gameRules();
            } else {
                System.out.println("Your choice is " + gameArray.get(playerChoice - 1));
                System.out.println("Computer choice is " + gameArray.get(comp.getComputerMove()));

                Round r = new Round(comp.getComputerMove(), playerChoice - 1);
                r.round();
                comp.getKey();
                System.out.println("*****************************************************************\n\n\n");
            }
        }


    }


    private static void showStart() {
        System.out.println("Available moves:");
        for (int i = 1; i <= gameArray.size(); i++) {
            System.out.println(i + " - " + gameArray.get(i - 1));
        }
        System.out.println("0 - exit\n-1 - help");
        while (true) {
            try {
                System.out.println("Enter your move: ");
                playerChoice = Integer.parseInt(sc.nextLine());
                if (playerChoice < -1 || playerChoice > gameArray.size()) {
                    System.out.println("Wrong Choice! You must pick 1 - " + gameArray.size() + "! 0 - exit, -1 - help");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong Choice! You must pick 1 - " + gameArray.size() + "! 0 - exit, -1 - help");
            }
        }
    }
}
