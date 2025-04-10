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
public class UnoDeck extends GroupOfCards {

    public UnoDeck() {
        super(108); 
        ArrayList<Card> cards = new ArrayList<>();

        
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color == UnoCard.Color.BLACK) continue; 

            for (UnoCard.Value value : UnoCard.Value.values()) {
                if (value == UnoCard.Value.WILD || value == UnoCard.Value.WILD_DRAW_FOUR) {
                    continue; 
                }

                
                int copies = (value == UnoCard.Value.ZERO) ? 1 : 2;
                for (int i = 0; i < copies; i++) {
                    cards.add(new UnoCard(color, value));
                }
            }
        }

       
        for (int i = 0; i < 4; i++) {
            cards.add(new UnoCard(UnoCard.Color.BLACK, UnoCard.Value.WILD));
            cards.add(new UnoCard(UnoCard.Color.BLACK, UnoCard.Value.WILD_DRAW_FOUR));
        }

        setCards(cards);
        shuffle();
    }

    public UnoCard drawCard() {
        if (!getCards().isEmpty()) {
            return (UnoCard) getCards().remove(0);
        }
        return null;
    }

   
    private void setCards(ArrayList<Card> cards) {
        try {
            java.lang.reflect.Field field = GroupOfCards.class.getDeclaredField("cards");
            field.setAccessible(true);
            field.set(this, cards);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
