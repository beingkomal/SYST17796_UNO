/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Komal
 */
public class UnoGame extends Game {

    private UnoGameManager manager;
    protected int currentPlayerIndex = 0;

    public UnoGame(String name, UnoDeck deck) {
        super(name);
        this.manager = new UnoGameManager(deck);
        UnoGameManagerHolder.setInstance(manager);
    }

    @Override
public void play() {
    System.out.println("Starting the UNO game...");

    ArrayList<Player> playerList = getPlayers();
    Collections.shuffle(playerList);

    System.out.println("Shuffled player order:");
    for (Player p : playerList) {
        System.out.println(p.getName());
    }

    while (true) {
        UnoPlayer currentPlayer = (UnoPlayer) playerList.get(currentPlayerIndex);
        currentPlayer.setGameContext(currentPlayerIndex, getCastedUnoPlayers());

        UnoCard topBefore = manager.getTopCard();
        currentPlayer.play();
        UnoCard topAfter = manager.getTopCard();

        if (currentPlayer.hasWon()) {
            System.out.println(currentPlayer.getName() + " wins the game!");
            return;
        }

        int step = topAfter.equals(topBefore)
                ? 1
                : manager.applyCardEffect(topAfter, getCastedUnoPlayers(), currentPlayerIndex);

        currentPlayerIndex = manager.isClockwise()
                ? (currentPlayerIndex + step) % playerList.size()
                : (currentPlayerIndex - step + playerList.size()) % playerList.size();
    }
}


    @Override
    public void declareWinner() {
        for (Player p : getPlayers()) {
            if (p instanceof UnoPlayer) {
                UnoPlayer unoPlayer = (UnoPlayer) p;
                if (unoPlayer.hasWon()) {
                    System.out.println("Winner is: " + unoPlayer.getName());
                    return;
                }
            }

        }
        System.out.println("No winner yet!");
    }

    private ArrayList<UnoPlayer> getCastedUnoPlayers() {
        ArrayList<UnoPlayer> result = new ArrayList<>();
        for (Player p : getPlayers()) {
            if (p instanceof UnoPlayer) {
                result.add((UnoPlayer) p);
            }

        }
        return result;
    }
}
