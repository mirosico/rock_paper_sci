package main.java.com.mysko.rps;

import static main.java.com.mysko.rps.Mains.gameArray;

public class Round {

    private final int computerMove;
    private final int playerMove;

    public Round(final int computerMove, final int playerMove) {
        this.computerMove = computerMove;
        this.playerMove = playerMove;
    }

    private int n = gameArray.size();


    public void messageWhenPlayerWin() {
        System.out.println("You win!\n");
    }

    public void messageWhenComputerWin() {
        System.out.println("Computer win!\n");
    }

    public void messageWhenDraw() {
        System.out.println("DRAW!\n");
    }

    public void round() {
        if (computerMove == playerMove) {
            messageWhenDraw();
        } else if (computerMove > playerMove) {
            if ((computerMove - playerMove) > (n - 1) / 2) messageWhenPlayerWin();
            else messageWhenComputerWin();
        } else if (computerMove < playerMove) {
            if ((playerMove - computerMove) > (n - 1) / 2) messageWhenComputerWin();
            else messageWhenPlayerWin();
        }
    }

}
