package ca.sheridancollege.project;
import java.util.Random;

public class UnoCard extends Card {
    private String color;
    private String value;

    // Possible colors and values
    private static final String[] COLORS = {"Red", "Blue", "Green", "Yellow"};
    private static final String[] VALUES = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "Skip", "Reverse", "Draw Two"};

    public UnoCard(String color, String value) {
        this.color = color;
        this.value = value;
    }

    // Generate a random Uno card
    public static UnoCard getRandomCard() {
        Random rand = new Random();
        String randomColor = COLORS[rand.nextInt(COLORS.length)];
        String randomValue = VALUES[rand.nextInt(VALUES.length)];
        return new UnoCard(randomColor, randomValue);
    }

    public String getColor() { return color; }
    public String getValue() { return value; }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
