/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Komal
 */

public class UnoGameManagerHolder {
    private static UnoGameManager instance;

    private UnoGameManagerHolder() {
    }

    public static void setInstance(UnoGameManager manager) {
        instance = manager;
    }

    public static UnoGameManager getInstance() {
        return instance;
    }
}
