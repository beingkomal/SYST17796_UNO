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
        if (playedCard == null || topCard == null) {
            return false;
        }
        return playedCard.getColor() == topCard.getColor()
                || playedCard.getValue() == topCard.getValue()
                || playedCard.getColor() == UnoCard.Color.BLACK;
    }

    public UnoCard drawCard() {
        return deck.drawCard();
    }

    public boolean isClockwise() {
        return isClockwise;
    }

    public int applyCardEffect(UnoCard cardPlayed, List<UnoPlayer> players, int currentIndex) {
        switch (cardPlayed.getValue()) {
            case REVERSE:
                isClockwise = !isClockwise;
                System.out.println("Direction reversed!");
                break;

            case SKIP:
                System.out.println("Next player is skipped!");
                return 2;

            case DRAW_TWO:
                UnoPlayer next2 = players.get(getNextPlayerIndex(players.size(), currentIndex));
                next2.addCardToHand(drawCard());
                next2.addCardToHand(drawCard());
                System.out.println(next2.getName() + " draws two cards!");
                break;

            case WILD_DRAW_FOUR:
                UnoPlayer next4 = players.get(getNextPlayerIndex(players.size(), currentIndex));
                for (int i = 0; i < 4; i++) {
                    next4.addCardToHand(drawCard());
                }
                UnoCard.Color chosen4 = chooseRandomColor();
                cardPlayed.setColor(chosen4);
                System.out.println("Wild Draw Four! Color changed to: " + chosen4);
                break;

            case WILD:
                UnoCard.Color chosen = chooseRandomColor();
                cardPlayed.setColor(chosen);
                System.out.println("Wild! Color changed to: " + chosen);
                break;
        }
        return 1;
    }

    private UnoCard.Color chooseRandomColor() {
        UnoCard.Color[] colors = {
            UnoCard.Color.RED, UnoCard.Color.BLUE, UnoCard.Color.GREEN, UnoCard.Color.YELLOW
        };
        return colors[(int) (Math.random() * colors.length)];
    }

    public int getNextPlayerIndex(int totalPlayers, int currentIndex) {
        return isClockwise
                ? (currentIndex + 1) % totalPlayers
                : (currentIndex - 1 + totalPlayers) % totalPlayers;
    }
}
