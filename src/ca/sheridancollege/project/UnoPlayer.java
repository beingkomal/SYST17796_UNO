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
    protected ArrayList<UnoCard> hand = new ArrayList<>();

    public UnoPlayer(String name) {
        super(name);
    }

    /**
     * Plays a card at the given index if valid.
     * @param index the index of the card to play
     */
    public void playCard(int index) {
        if (isValidCardIndex(index)) {
            UnoCard playedCard = hand.remove(index);
            System.out.println(getName() + " played: " + playedCard);
        } else {
            System.out.println("Invalid move!");
        }
    }

    /**
     * Validate card index range.
     */
    private boolean isValidCardIndex(int index) {
        return index >= 0 && index < hand.size();
    }

    /**
     * Basic play behavior: plays the first card if available.
     */
    @Override
    public void play() {
        if (!hand.isEmpty()) {
            playCard(0); // Can later be replaced with more strategic selection.
        } else {
            System.out.println(getName() + " has no cards left!");
        }
    }
    
}
