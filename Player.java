/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

 public class Player {
    // TODO: implement.
    private String name;
    private char symbol;

    // Parameterize constructor
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;

    }

    // Getters
    public String getPlayerName() {
        return name;

    }

    public char getSymbol() {
        return symbol;

    }

    public void playerInformation() {
        System.out.println("Player " + name + "is palying with symbol " + symbol);
    }

}
