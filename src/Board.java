package src;

import java.util.*;

public class Board {
    private boolean[][] board;

    private int[][] neighbors = {
            {0,1},
            { 0, -1 },
            { 1, 0 },
            { -1, 0 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 }
    };

    public Board(int i, int j) {
        board = new boolean[i][j];
    }

    public void setDimensions(int i, int j){
        board = new boolean[i][j];
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void changeBoard(int i, int j) {
        board[i][j] = !board[i][j];
    }

    public int[] getSize() {
        int[] size = new int[2];

        size[0] = board.length;
        size[1] = board[0].length;

        return size;
    }
    
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

    public boolean isOutOfBounds() {
        for (int i = 1; i < board.length - 1; i++) {
            if ((board[i][0] && board[i - 1][0] && board[i + 1][0]) || (board[i][board[0].length - 1]
                    && board[i - 1][board[0].length - 1] && board[i + 1][board[0].length - 1])) {
                return true;
            }
        }

        for (int i = 1; i < board[0].length - 1; i++) {
            if ((board[0][i] && board[0][i-1] && board[0][i+1]) || (board[board.length-1][i]
                    && board[board.length-1][i - 1] && board[board.length-1][i+1])) {
                return true;
            }
        }

        return false;
    }

    public boolean nextStep() {
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

    public void displayBoard() {

        System.out.println("Your Current Board \nO - Live Cell     X - Dead Cell \n");

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

    public int displayFinalState() {
        System.out.println("***** FINAL STATE *****");
        displayBoard();
        System.out.println("Do you want to continue? \nPress 1 to continue \nAny other number to exit");

        Scanner myInput = new Scanner(System.in);
        int choice = myInput.nextInt();

        return choice;
    }
}
