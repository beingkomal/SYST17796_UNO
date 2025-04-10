/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import static ca.sheridancollege.project.UnoCard.Value.DRAW_TWO;
import static ca.sheridancollege.project.UnoCard.Value.REVERSE;
import static ca.sheridancollege.project.UnoCard.Value.SKIP;
import static ca.sheridancollege.project.UnoCard.Value.WILD;
import static ca.sheridancollege.project.UnoCard.Value.WILD_DRAW_FOUR;
import java.util.List;

/**
 *
 * @author Komal
 */
public class UnoGameManager {
    private UnoDeck deck;
    private UnoCard topCard;
    private boolean isClockwise = true;

    public UnoGameManager(UnoDeck deck) {
        this.deck = deck;
        this.topCard = deck.drawCard(); 
    }

    public UnoCard getTopCard() {
        return topCard;
    }

    public void setTopCard(UnoCard card) {
        this.topCard = card;
    }

    public boolean isCardPlayable(UnoCard playedCard) {
        return playedCard.getColor() == topCard.getColor() ||
               playedCard.getValue() == topCard.getValue() ||
               playedCard.getColor() == UnoCard.Color.BLACK;
    }

    public UnoCard drawCard() {
        return deck.drawCard();
    }

    public boolean isClockwise() {
        return isClockwise;
    }

    public void applyCardEffect(UnoCard cardPlayed, List<UnoPlayer> players, int currentIndex) {
        switch (cardPlayed.getValue()) {
            case REVERSE:
                isClockwise = !isClockwise;
                System.out.println("Direction reversed!");
                break;
            case SKIP:
                System.out.println("Next player is skipped!");
                break;
            case DRAW_TWO:
                int nextIndex = getNextPlayerIndex(players.size(), currentIndex);
                UnoPlayer nextPlayer = players.get(nextIndex);
//                nextPlayer.drawCard(deck.drawCard());
//                nextPlayer.drawCard(deck.drawCard());
                System.out.println(nextPlayer.getName() + " draws two cards!");
                break;
            case WILD:
                // Color will be set manually by user or randomly in MVP
                System.out.println("Wild card played!");
                break;
            case WILD_DRAW_FOUR:
                nextIndex = getNextPlayerIndex(players.size(), currentIndex);
                nextPlayer = players.get(nextIndex);
//                for (int i = 0; i < 4; i++) nextPlayer.drawCard(deck.drawCard());
                System.out.println(nextPlayer.getName() + " draws four cards!");
                break;
        }
    }

    public int getNextPlayerIndex(int totalPlayers, int currentIndex) {
        return isClockwise ?
                (currentIndex + 1) % totalPlayers :
                (currentIndex - 1 + totalPlayers) % totalPlayers;
    }
}
