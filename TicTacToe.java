/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

 import java.util.Scanner;

 public class TicTacToe {
     private GameBoard gameBoard;
     private Player player1;
     private Player player2;
     private Player currentPlayer;
     private Scanner myScanner;
 
     public TicTacToe() {
         gameBoard = new GameBoard();
         // TODO: read player names
         // player1 starts the game
         gameBoard = new GameBoard();
         myScanner = new Scanner(System.in);
         System.out.println("Enter name for Player 1 (X):");
         String player1Name = myScanner.nextLine();
         player1 = new Player(player1Name, 'X');
         System.out.println("Enter name of Player 2 (0):");
         String player2Name = myScanner.nextLine();
         player2 = new Player(player2Name, '0');
 
         currentPlayer = player1;
 
     }
 
     // NO NEED TO TOUCH startGame()
     public void startGame() {
         boolean gameEnded = false;
         while (!gameEnded) {
             gameBoard.printBoard();
             promptPlayerMove();
             if (gameBoard.checkWin()) {
                 gameBoard.printBoard();
                 System.out.println(currentPlayer.getPlayerName() + " wins!");
                 gameEnded = true;
             } else if (gameBoard.isFull()) {
                 gameBoard.printBoard();
                 System.out.println("The game ended in a tie!");
                 gameEnded = true;
             } else {
                 switchPlayers();
             }
         }
         myScanner.close();
     }
 
     // Prompts the player to place a move and checks for its validity
     private void promptPlayerMove() {
         boolean validMove = false;
         // TODO: ask the player to place a move
         // Check whether the move is valid, if not, ask the player to place a move again
         // If the player's move is valid, the move is placed on the gameBoard
 
         while (!validMove) {
             System.out.printf("%s (%c), enter your move(in the form of A1, B1,C2,A4): ", currentPlayer.getPlayerName(),
                     currentPlayer.getSymbol());
             String userInput = myScanner.next().toUpperCase();
             // Check if the user enter only two character
             if (userInput.length() == 2) {
                 // Extract the second character of the user input as row
                 char row = userInput.charAt(1);
                 // Extract the first character of the user input as column
                 char column = userInput.charAt(0);
                 // substract 1 from the user input because we are counting the row index from 0
                 int rowIndex = row - '1';
                 // substract 1 from the user input because we are counting the column index from
                 // 0
                 int columnIndex = column - 'A';
                 // Check if we are still in the valid range of the game board 3x3
                 if (rowIndex >= 0 && rowIndex < gameBoard.GAMEBOARDSIZE && columnIndex >= 0
                         && columnIndex < gameBoard.GAMEBOARDSIZE) {
                     // Place the player symbol on the board
                     validMove = gameBoard.makeMove(rowIndex, columnIndex, currentPlayer.getSymbol());
                     // and then Check if the cell where the player is placing it symbol is empty
                     if (!validMove) {
                         System.out.println("Invalid move the cell is not empty, try again.");
 
                     }
 
                 } else {
                     System.out.println(
                             "You need to enter a letter that is either A, B or C followed by a number between 1-3");
                 }
 
             } else {
                 System.out.println(
                         "You need to enter a letter that is either A, B or C followed by a number between 1-3");
             }
 
         }
     }
 
     // Switch players
     // Sets the player that is not the currentPlayer as currentPlayer
     private void switchPlayers() {
         // TODO implement
         if (currentPlayer == player1) {
             currentPlayer = player2;
         } else {
             currentPlayer = player1;
         }
     }
 }
 