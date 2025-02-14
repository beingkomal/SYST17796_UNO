package ca.sheridancollege.project;
import java.util.ArrayList;

public abstract class Player {
    private final String name;
    protected ArrayList<UnoCard> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Draw a card
    public void drawCard(UnoCard card) {
        hand.add(card);
        System.out.println(name + " drew a card: " + card);
    }

    public abstract void play(); // Implemented in UnoPlayer

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public void showHand() {
        System.out.println(name + "'s hand: " + hand);
    }
}
