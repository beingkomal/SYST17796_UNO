/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Komal
 */
public class UnoGameLauncher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            UnoDeck deck = new UnoDeck();
            UnoGame game = new UnoGame("UNO Showdown", deck);
            int numPlayers = 0;
            System.out.print("Enter number of players (2–4): ");
            while (numPlayers < 2 || numPlayers > 4) {
                try {
                    numPlayers = Integer.parseInt(scanner.nextLine());
                    if (numPlayers < 2 || numPlayers > 4) {
                        System.out.print("Invalid. Please enter 2–4 players: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid. Please enter a number: ");
                }
            }
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter name for Player " + i + ": ");
                String name = scanner.nextLine().trim();
                UnoPlayer player = new UnoPlayer(name);
                for (int j = 0; j < 7; j++) {
                    player.addCardToHand(deck.drawCard());
                }
                players.add(player);
            }
            game.setPlayers(players);
            game.play();
            game.declareWinner();
            System.out.print("\nWould you like to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                System.out.println("Thanks for playing UNO!");
                break;
            }
            System.out.println("\n--- Starting New Game ---\n");
        }
        scanner.close();
    }
}
