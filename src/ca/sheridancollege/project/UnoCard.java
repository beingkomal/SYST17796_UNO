/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Komal
 */
public class UnoCard extends Card {

    public enum Color {
        RED, BLUE, GREEN, YELLOW, BLACK
    }

    public enum Value {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
        SKIP, REVERSE, DRAW_TWO, WILD, WILD_DRAW_FOUR
    }

    private Color color;
    private Value value;

    public UnoCard(Color color, Value value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }

    public boolean isWildCard() {
        return value == Value.WILD || value == Value.WILD_DRAW_FOUR;
    }

    public boolean isActionCard() {
    switch (value) {
        case SKIP:
        case REVERSE:
        case DRAW_TWO:
        case WILD:
        case WILD_DRAW_FOUR:
            return true;
        default:
            return false;
    }
}


}
