package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Collections;

public class UnoGame extends Game {
    public UnoGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Starting the UNO game...");

        // Shuffle players so Alice doesn't always go first
        Collections.shuffle(players);
        System.out.println("Shuffled player order: ");
        for (UnoPlayer player : players) {
            System.out.println(player.getName());
        }

        while (true) { // Keep playing until someone wins
            for (UnoPlayer player : players) {
                if (!player.hand.isEmpty()) {
                    player.playCard(0); // Play first available card
                }

                // Check if this player has won
                if (player.hasWon()) {
                    System.out.println(player.getName() + " wins the game!");
                    return; // End the game
                }
            }
        }
    }

    @Override
    public void declareWinner() {
        for (UnoPlayer player : players) {
            if (player.hasWon()) {
                System.out.println(player.getName() + " wins the game!");
                return;
            }
        }
        System.out.println("No winner yet!");
    }

    public static void main(String[] args) {
        UnoGame game = new UnoGame("UNO");

        // Adding players
        UnoPlayer player1 = new UnoPlayer("Alice");
        UnoPlayer player2 = new UnoPlayer("Bob");
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Start the game
        game.startGame();
        game.play();
    }
}
