/*
 * Created on 2024-10-01
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

 public class GameBoard {
    /* TODO type of gameboard */

    // 2D array for gameboard
    private char[][] board;

    // 'final' means that SIZE is a constant and cannot be changed after
    // initialization
    // Java convention: Constants in Java are written in all upper-case letters
    // The size indicates the gameboard size (3x3)
    public static final int GAMEBOARDSIZE = 3;

    // Default constructor
    public GameBoard() {
        // TODO: The constructor should initialize the board
        // and set an empty space character, e.g., '-'

        board = new char[GAMEBOARDSIZE][GAMEBOARDSIZE];
        for (int i = 0; i < GAMEBOARDSIZE; i++) {
            for (int j = 0; j < GAMEBOARDSIZE; j++) {
                board[i][j] = '-';

            }
        }

    }

    // makeMove marks a non-empty cell with the respective symbol
    public boolean makeMove(int row, int col, char symbol) {
        // TODO: place symbol (check if cell is occupied)
        if (row >= 0 && row < GAMEBOARDSIZE && col >= 0 && col < GAMEBOARDSIZE && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;

        }
        // Only occurs when the move is invalid because the cell is occupied
        return false;
    }

    // Checks if a player has placed three symbols in a row, column, or diagonal
    // If yes, that player has won

    public boolean checkWin() {
        // Hint: Define additional methods to keep your code organized and readable!
        // TODO: Check rows

        // TODO: Check columns

        // TODO: Check diagonals

        return checkrows() || checkcolumns() || checkdiagonals();
    }

    // Check if the one of the row won
    private boolean checkrows() {
        for (int i = 0; i < GAMEBOARDSIZE; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }

        }
        return false;
    }

    // Check if one of the colum won
    private boolean checkcolumns() {
        for (int i = 0; i < GAMEBOARDSIZE; i++) {
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }

        }
        return false;
    }

    // Check if any of the diagonal won
    private boolean checkdiagonals() {
        return (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]);
    }

    // Checks if the gameboard is full but no player won
    public boolean isFull() {
        // TODO

        for (int i = 0; i < GAMEBOARDSIZE; i++) {
            for (int j = 0; j < GAMEBOARDSIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }

            }
        }
        return true;
    }

    public void printBoard() {
        // TODO: implement
        System.out.println("   A   B   C");
        for (int i = 0; i < GAMEBOARDSIZE; i++) {
            System.out.printf("%d ", i + 1);
            for (int j = 0; j < GAMEBOARDSIZE; j++) {
                System.out.printf(" %c ", board[i][j]);
                if (j < GAMEBOARDSIZE - 1) {
                    System.out.print("|");

                }
            }
            System.out.println();
            if (i < GAMEBOARDSIZE - 1) {

                System.out.println("  ---|---|---");
            }

        }

    }

}