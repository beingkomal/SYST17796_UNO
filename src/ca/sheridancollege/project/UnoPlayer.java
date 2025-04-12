/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Komal
 */
public class UnoPlayer extends Player {

    private int currentIndex;
    private ArrayList<UnoPlayer> allPlayers;
    protected ArrayList<UnoCard> hand = new ArrayList<>();

    public UnoPlayer(String name) {
        super(name);
    }

    public void setGameContext(int currentIndex, ArrayList<UnoPlayer> allPlayers) {
        this.currentIndex = currentIndex;
        this.allPlayers = allPlayers;
    }

    public void addCardToHand(UnoCard card) {
        hand.add(card);
    }

    public ArrayList<UnoCard> getHand() {
        return hand;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    @Override
    public void play() {
        UnoGameManager manager = UnoGameManagerHolder.getInstance();
        UnoCard topCard = manager.getTopCard();

        for (int i = 0; i < hand.size(); i++) {
            UnoCard card = hand.get(i);
            if (manager.isCardPlayable(card)) {
                hand.remove(i);
                System.out.println(getName() + " played: " + card);
                manager.setTopCard(card);

                checkUNO(manager);
                return;
            }
        }
        UnoCard drawn = manager.drawCard();
        if (drawn == null) {
            System.out.println(getName() + " tried to draw a card, but the deck is empty.");
            return;
        }
        addCardToHand(drawn);
        System.out.println(getName() + " drew: " + drawn);
        if (manager.isCardPlayable(drawn)) {
            hand.remove(hand.size() - 1);
            System.out.println(getName() + " played drawn card: " + drawn);
            manager.setTopCard(drawn);
            checkUNO(manager);
        }
    }
    private void checkUNO(UnoGameManager manager) {
    if (hand.size() == 1) {
        boolean saidUNO = Math.random() < 0.8;
        if (saidUNO) {
            System.out.println(getName() + " says UNO!");
        } else {
            System.out.println(getName() + " forgot to say UNO! Draw 2 penalty cards.");
            hand.add(manager.drawCard());
            hand.add(manager.drawCard());
        }
    }
}


}
