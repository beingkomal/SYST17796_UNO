package ca.sheridancollege.project;
import java.util.ArrayList;

public class UnoPlayer extends Player {
    public UnoPlayer(String name) {
        super(name);
    }

    // Simulating drawing a card
    public void drawCard(UnoCard card) {
        super.drawCard(card);
    }

    // Play a card from hand
    public void playCard(int index) {
        if (index >= 0 && index < hand.size()) {
            System.out.println(getName() + " played: " + hand.remove(index));
        } else {
            System.out.println("Invalid move!");
        }
    }

    @Override
    public void play() {
        if (!hand.isEmpty()) {
            playCard(0); // Simulate playing first card
        } else {
            System.out.println(getName() + " has no cards left!");
        }
    }
}
