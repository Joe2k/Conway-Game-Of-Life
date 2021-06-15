package src;

import java.util.*;

public class Board {
    private boolean[][] board; /*!< The main 2D boolean board where all our methods will work with. */

    private int[][] neighbors = {
            {0,1},
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    }; /*!< 2D array to navigate to neighbouring cells. */

    /**
    * Constructor of the Board class which takes in the dimensions of the board.
    * @param i Number of rows.
    * @param j Number of columns.
    */
    public Board(int i, int j) {
        board = new boolean[i][j];
    }

    /**
    * Method to set new dimensions of the board.  
    * @param i Number of rows.
    * @param j Number of columns.
    */
    public void setDimensions(int i, int j) {
        board = new boolean[i][j];
    }
    
    /**
    * Helper Method to return the board.
    * @return board
    */
    public boolean[][] getBoard() {
        return board;
    }

    /**
    * Function to negate the cell's value according to the user.
    * @param i 1st Coordinate
    * @param j 2nd Coordinate
    */
    public void changeBoard(int i, int j) {
        board[i][j] = !board[i][j];
    }

    /**
    * Helper Method to return the size of the board.
    * @return size of the board
    */
    public int[] getSize() {
        int[] size = new int[2];

        size[0] = board.length;
        size[1] = board[0].length;

        return size;
    }
    
    /**
    * Helper Method to return if the board is empty or not.
    * @return boolean of the board's empty state
    */
    public boolean isEmpty() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == true) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
    * Helper Function to return if the two boards are equal or not.
    * @param board1 Board 1
    * @param board2 Board 2
    * @return true if they are equal, false otherwise
    */
    public static boolean isEqual(boolean[][] board1, boolean[][] board2) {
        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[0].length; j++) {
                if (board1[i][j] != board2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
    * Function to tell is the board will go out of bounds or not.
    * @return true if the edges of the board have 3 consequitive live cells.
    */
    public boolean isOutOfBounds() {
        for (int i = 1; i < board.length - 1; i++) {
            if ((board[i][0] && board[i - 1][0] && board[i + 1][0]) || (board[i][board[0].length - 1]
                    && board[i - 1][board[0].length - 1] && board[i + 1][board[0].length - 1])) {
                return true;
            }
        }

        for (int i = 1; i < board[0].length - 1; i++) {
            if ((board[0][i] && board[0][i - 1] && board[0][i + 1]) || (board[board.length - 1][i]
                    && board[board.length - 1][i - 1] && board[board.length - 1][i + 1])) {
                return true;
            }
        }

        return false;
    }
    
    /**
    * Function to add padding to all edges of the board.
    */
    public void addPadding() {
        boolean[][] newBoard = new boolean[board.length + 2][board[0].length + 2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        board = newBoard;
    }

    /**
    * Function which has the main logic and rules to calculate the next generation.
    * @return true if the resulting board was the same state as before.
    */
    public boolean nextGeneration() {
        if (isOutOfBounds()) {
            addPadding();
        }
        
        boolean[][] newBoard = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                int neighborLiveCells = 0;
                for (int k = 0; k < 8; k++) {
                    if (i + neighbors[k][0] >= 0 && i + neighbors[k][0] < board.length && j + neighbors[k][1] >= 0
                            && j + neighbors[k][1] < board[0].length) {
                        if (board[i + neighbors[k][0]][j + neighbors[k][1]]) {
                            neighborLiveCells++;
                        }
                    }
                }

                if (board[i][j]) {
                    if (neighborLiveCells < 2 || neighborLiveCells > 3) {
                        newBoard[i][j] = false;
                    } else {
                        newBoard[i][j] = true;
                    }
                } else {
                    if (neighborLiveCells == 3) {
                        newBoard[i][j] = true;
                    } else {
                        newBoard[i][j] = false;
                    }
                }
            }
        }
        boolean isSame = isEqual(board, newBoard);

        board = newBoard;

        return isSame;
    }

    /**
    * Helper Method to print the board
    */
    public void displayBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    System.out.print("O   ");
                } else {
                    System.out.print("X   ");
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
    * Helper Method to print the board with coordinate labels for easy read.
    */
    public void displayBoardWithLabels() {

        System.out.println("***** Current Board ***** \nO - Live Cell     X - Dead Cell \n");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    System.out.print("O (" + Integer.toString(i) + ", " + Integer.toString(j) + ")  ");
                } else {
                    System.out.print("X (" + Integer.toString(i) + ", " + Integer.toString(j) + ")  ");
                }

            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
    * Helper Method to display the final state of the game if it ends and gives a option for user to continue or not.
    * @return choice of the user to continue.
    */
    public int displayFinalState() {
        System.out.println("***** FINAL STATE ***** \n");
        displayBoard();
        System.out.println("Do you want to continue? \nPress 1 to continue \nAny other number to exit");

        Scanner myInput = new Scanner(System.in);
        int choice = myInput.nextInt();

        return choice;
    }
}
