package ca.sheridancollege.project;
import java.util.ArrayList;

public abstract class Game {
    private final String name;
    protected ArrayList<UnoPlayer> players = new ArrayList<>();

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Add a player to the game
    public void addPlayer(UnoPlayer player) {
        players.add(player);
    }

    // Start the UNO game
    public void startGame() {
        System.out.println("UNO Game Started!");
        dealInitialCards();
        play();
    }

    // Deal random cards to each player
    private void dealInitialCards() {
        System.out.println("Dealing random cards to players...");
        for (UnoPlayer player : players) {
            for (int i = 0; i < 7; i++) { // Each player gets 7 random cards
                player.drawCard(UnoCard.getRandomCard());
            }
        }
    }

    public abstract void play();
    public abstract void declareWinner();
}
